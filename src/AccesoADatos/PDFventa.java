package AccesoADatos;

import Entidades.Cliente;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
                direccion_cliente = rs.getString("Direccion");

            }
            con.close();
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
                if (fecha.charAt(i) == '/') {
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
            Encabezado.addCell(imag);
            
            String Cuit = "21546541253";
            String nombre = "Compre Hoy ¡Mañana es mas Caro!";
            String telf = "266515452";
            String direccion = "San Rafael MZA";
            String razon = "ULP University";
            
            
            
        } catch (DocumentException | IOException e) {
            System.out.println("Eerror en: " + e);
        }

    }

}
