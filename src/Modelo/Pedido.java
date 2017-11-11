/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ignacio Alvarez
 */
public class Pedido 
{
    private Mozo mozo;
    private Mesa mesa;
    private ArrayList<Producto> listaProductos;
    private Date fecha;

    public Pedido(Mozo mozo, Mesa mesa) {
        this.mozo = mozo;
        this.mesa = mesa;
        listaProductos = new ArrayList<>();
        fecha = new Date();
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    public double getTotal()
    {
        double total = 0;
        for(Producto p: listaProductos)
        {
            total += p.getPrecio();
        }
        return total;
    }
}
