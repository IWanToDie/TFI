/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Producto;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ignacio Alvarez
 */
public class ProductoDaoMySQL implements ProductoDao 
{    
    @Override
    public void delete(Integer id) 
    {
        Connection conn = null;
        try {
            conn = ConexionMySQL.getInstancia().getConexion();
            try (Statement stmt = (Statement) conn.createStatement()) {
                stmt.executeUpdate("delete from producto where id = " + id + ";");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void insert(Producto producto) {
        Connection conn = null;
        try {
            conn = ConexionMySQL.getInstancia().getConexion();
            try (Statement stmt = (Statement) conn.createStatement()) {
                stmt.executeUpdate("insert into product values ("
                        + producto.getId() + ",'"
                        + producto.getDescripcion() + "',"
                        + producto.getPrecio() + ");");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Producto product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Producto select(Integer id) 
    {
        Connection conn = null;
        Producto producto = null;

        try {
            conn = ConexionMySQL.getInstancia().getConexion();
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from product where id = ?")) 
            {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) 
                {
                    if (rs.next()) 
                    {
                        producto = new Producto(id,
                                rs.getString("descripcion"),
                                rs.getDouble("precio"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return producto;
    }

    @Override
    public List<Producto> getTodosProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

