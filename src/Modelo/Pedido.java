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
    private ArrayList<LineaPedido> listaLineaPedido;
    private Date fecha;

    public Pedido(Mozo mozo, Mesa mesa) {
        this.mozo = mozo;
        this.mesa = mesa;
        listaLineaPedido = new ArrayList<>();
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

    public ArrayList<LineaPedido> getListaProductos() {
        return listaLineaPedido;
    }

    public void setListaProductos(ArrayList<LineaPedido> listaProductos) {
        this.listaLineaPedido = listaProductos;
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
        for(LineaPedido p: listaLineaPedido)
        {
            total += p.getTotal();
        }
        return total;
    }
    public void agregarProducto(LineaPedido p)
    {
        listaLineaPedido.add(p);
    }
}
