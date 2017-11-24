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
    private IVendible vendible;
    private int cantidad;

    public LineaPedido(IVendible vendible, int cantidad) 
    {
        this.vendible = vendible;
        this.cantidad = cantidad;
    }

    public IVendible getVendible() {
        return vendible;
    }

    public void setVendible(IVendible vendible) {
        this.vendible = vendible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotal()
    {
        if(vendible != null)
            return vendible.calcularPrecio() * cantidad;
        return 0;
    }
}
