/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pam
 */
public class ProductoData {

    private Connection con = null;
 public static List<Producto> productos = new ArrayList<>();


    public ProductoData() {
        con = Conexion.getConexion();
    }

    public void nuevoProducto(Producto producto) {
        String sql = "INSERT INTO Producto (NombreProducto, Descripcion, PrecioActual, Stock, Estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto cargado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
    }

    public void modificarProducto(Producto producto) {
        String sql = "UPDATE Producto SET NombreProducto=?, Descripcion=?, PrecioActual=?, Stock=?, Estado=? WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "UPDATE Producto SET Estado=0 WHERE idProducto=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
    }

    public Producto buscarPorId(int id) {
        String sql = "SELECT NombreProducto, Descripcion, PrecioActual, Stock, Estado FROM Producto WHERE idProducto=?";

        Producto producto = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("NombreProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecioActual(rs.getDouble("PrecioActual"));
                producto.setStock(rs.getInt("Stock"));
                producto.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return producto;
    }

    public Producto buscarPorNombre(String nombre) {
        String sql = "SELECT idProducto, NombreProducto, Descripcion, PrecioActual, Stock, Estado FROM Producto WHERE NombreProducto=?";

        Producto producto = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("NombreProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecioActual(rs.getDouble("PrecioActual"));
                producto.setStock(rs.getInt("Stock"));
                producto.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return producto;
    }

    public List<Producto> listarProductos() {
        String sql = "SELECT idProducto, NombreProducto, Descripcion, PrecioActual, Stock FROM Producto WHERE Estado=1";

        productos = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("NombreProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecioActual(rs.getDouble("PrecioActual"));
                producto.setStock(rs.getInt("Stock"));
                producto.setEstado(true);
                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }

        return productos;
    }

    public void actualizarStock(int idProducto, int cantVendida) {
        String sql = "SELECT Stock FROM Producto WHERE idProducto = ?";
        int stock = 0;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                stock = rs.getInt("Stock") - cantVendida;
                if (stock < 0) {
                    stock = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }


        try {
            sql = "UPDATE Producto SET Stock=? WHERE idProducto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, idProducto);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Stock actualizado. Restante: " + stock);
            } else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el Stock");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
    }
}
