/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ignacio Alvarez
 */
public class Promocion implements IVendible
{
    private int id;
    private String descripcion;
    private double descuento;
    private ArrayList<Producto> listaProductos;

    public Promocion(int id, String descripcion, double descuento) {
        this.id = id;
        this.descripcion = descripcion;
        this.descuento = descuento;
        listaProductos = new ArrayList<>();
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    @Override
    public double calcularPrecio()
    {
        double total = 0;
        for(Producto p: listaProductos)
        {
            total += p.calcularPrecio();
        }
        return total * descuento;
    }
    @Override
    public void agregarProducto(Producto p)
    {
        if((p != null) && (p.isEsAgregado() == false))
            this.listaProductos.add(p);
    }
    
}
