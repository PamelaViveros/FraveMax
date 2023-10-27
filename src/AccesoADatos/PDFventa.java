package AccesoADatos;

import Entidades.Cliente;
import Vista.Facturar.JInternalNuevaVenta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sergio Mendez
 */
public class PDFventa {

    private String nombreCliente;
    private String dni_cliente;
    private String telefono;
    private String direccion_cliente;

    private String fechaActual = "";
    private String nomArchivoPDF = "";

    public void carga_datos_cliente(int idCliente) throws SQLException {
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM Cliente WHERE idCliente = '" + idCliente + "'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("Nombre") + " " + rs.getString("Apellido");
                dni_cliente = String.valueOf(rs.getInt("Dni"));
                telefono = String.valueOf(rs.getInt("Telefono"));
                direccion_cliente = rs.getString("Domicilio");
            }
        } catch (SQLException e) {
            System.out.println("Error al recibir datos del Cliente" + e);
        }
    }

    public void FacturaPDF() {

        try {

            Date f = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(f);

            String fecha = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fecha = fechaActual.replace("/", "_");
                }
            }
            
            nomArchivoPDF = "Compra Cliente_" + nombreCliente + "_" + fecha + ".pdf";
            
            FileOutputStream archivo;
            File file = new File("src/Pdf/" + nomArchivoPDF);
            archivo = new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image imag = Image.getInstance("src/Imag/carrito4.png");
            Paragraph fech = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD, BaseColor.BLUE);
            fech.add(Chunk.NEWLINE);
            
            fech.add("Factura: 0001" + "\nFecha: " + fechaActual + "\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//Sin Borde
            
            float[] EncabezadoColumna = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(EncabezadoColumna);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(imag);/// Agrega celdas
            
            String Cuit = "21546541253";
            String nombre = "Compre Hoy ¡Mañana es mas Caro!";
            String telf = "266515452";
            String direccion = "San Rafael MZA";
            String razon = "ULP University";
            
            Encabezado.addCell("");//Lugar vacio
            Encabezado.addCell("Cuit: " + Cuit + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telf + "\nDIRECCIÓN: " + direccion + "\nRAZON SOCIAL:" + razon);
            Encabezado.addCell(fech);
            doc.add(Encabezado);
            
            ///DATOS DE LA VENTA///
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("CLIENTE: " + "\n\n");
            doc.add(cliente);
            
            PdfPTable tableCliente = new PdfPTable(4);
            tableCliente.setWidthPercentage(100);
            tableCliente.getDefaultCell().setBorder(0);
            //TAMAÑO DE CELDAS//
            float[] ColumnaC = new float[]{25f, 45f, 30f, 40f};
            tableCliente.setWidths(ColumnaC);
            tableCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell encabezado_cliente1 = new PdfPCell(new Phrase("DNI/CU: ", negrita));
            PdfPCell encabezado_cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell encabezado_cliente3 = new PdfPCell(new Phrase("Teléfono/CEL: ", negrita));
            PdfPCell encabezado_cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));
            encabezado_cliente1.setBorder(0);//setBorder(0) = Sin Borde
            encabezado_cliente2.setBorder(0);//Sin Borde
            encabezado_cliente3.setBorder(0);//Sin Borde
            encabezado_cliente4.setBorder(0);//Sin Borde
                        ///AGREGO CELDAS///
            tableCliente.addCell(encabezado_cliente1);
            tableCliente.addCell(encabezado_cliente2);
            tableCliente.addCell(encabezado_cliente3);
            tableCliente.addCell(encabezado_cliente4);
            tableCliente.addCell(dni_cliente);
            tableCliente.addCell(nombreCliente);
            tableCliente.addCell(telefono);
            tableCliente.addCell(direccion_cliente);
            
            doc.add(tableCliente);//AGREGADO AL DOCUMENTO
            
            Paragraph lugarEnBlanco = new Paragraph();
            
            lugarEnBlanco.add(Chunk.NEWLINE);
            lugarEnBlanco.add("");
            lugarEnBlanco.setAlignment(Element.ALIGN_CENTER);
            doc.add(lugarEnBlanco);
            
                    ///AÑADIR PRODUCTOS AL DOCUMENTO///
            PdfPTable tableProducto = new PdfPTable(4);
            tableProducto.setWidthPercentage(100);
            tableProducto.getDefaultCell().setBorder(0);
            
            float[] ColumnaP = new float[]{15f, 50f, 15f, 20f};
            tableProducto.setWidths(ColumnaP);
            tableProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell encabezado_producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell encabezado_producto2 = new PdfPCell(new Phrase("Nombre/Desc: ", negrita));
            PdfPCell encabezado_producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell encabezado_producto4 = new PdfPCell(new Phrase("P/Total: ", negrita));
            encabezado_producto1.setBorder(0);
            encabezado_producto2.setBorder(0);
            encabezado_producto3.setBorder(0);
            encabezado_producto4.setBorder(0);
            
            encabezado_producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            encabezado_producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            encabezado_producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            encabezado_producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            tableProducto.addCell(encabezado_producto1);
            tableProducto.addCell(encabezado_producto2);
            tableProducto.addCell(encabezado_producto3);
            tableProducto.addCell(encabezado_producto4);
            
            for (int i = 0; i < JInternalNuevaVenta.jTable_Productos.getRowCount(); i++) {
                String producto = JInternalNuevaVenta.jTable_Productos.getValueAt(i, 1).toString();
                String cantidad = JInternalNuevaVenta.jTable_Productos.getValueAt(i, 2).toString();
                String precio = JInternalNuevaVenta.jTable_Productos.getValueAt(i, 3).toString();
                String total = JInternalNuevaVenta.jTable_Productos.getValueAt(i, 6).toString();
                
                tableProducto.addCell(cantidad);
                tableProducto.addCell(producto);
                tableProducto.addCell(precio);
                tableProducto.addCell(total);
            }
            
            doc.add(tableProducto);
            ///////////////////
            ///Precio Final///
            Paragraph p_final = new Paragraph();
            p_final.add(Chunk.NEWLINE);
            p_final.add("Total a Pagar: " + JInternalNuevaVenta.jtxt_total_A_Pagar.getText());
            p_final.setAlignment(Element.ALIGN_RIGHT);
            doc.add(p_final);
            
            ///Firma de confirmacion de Pago
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma Cliente\n\n");
            firma.add("____________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            
            doc.add(firma);
            
            Paragraph saludo = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("¡Gracias por su compra!");
            
            firma.setAlignment(Element.ALIGN_CENTER);
            
            doc.add(saludo);
            
            doc.close();
            archivo.close();
            
            //Lanzar PDF al cargar compra
            Desktop.getDesktop().open(file);
            
        } catch (DocumentException | IOException e) {
            System.out.println("Eerror en: " + e);
        }

    }

}
