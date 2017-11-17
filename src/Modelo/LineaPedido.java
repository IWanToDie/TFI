/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ignacio Alvarez
 */
public class LineaPedido 
{
    private Producto producto;
    private int cantidad;
    private String caracteristica;

    public LineaPedido(Producto producto, int cantidad) 
    {
        this.producto = producto;
        this.cantidad = cantidad;
        this.caracteristica = null;
    }

    public LineaPedido(Producto producto, String caracteristica) 
    {
        this.producto = producto;
        this.caracteristica = caracteristica;
        this.cantidad = 1;
    }
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotal()
    {
        return producto.getPrecio() * cantidad;
    }
}
