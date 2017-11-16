/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Producto;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ignacio Alvarez
 */
public class ProductoDaoMySQL implements ProductoDao 
{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tfi";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    private void registrarDriver() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) 
    {
        Connection conn = null;
        try {
            registrarDriver();
            conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            try (Statement stmt = (Statement) conn.createStatement()) {
                stmt.executeUpdate("delete from product where id = " + id + ";");
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
            registrarDriver(); 
            conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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
            registrarDriver();
            conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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
}

