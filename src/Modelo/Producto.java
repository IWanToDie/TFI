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
public class Producto implements IVendible
{
    private int id;
    private String descripcion;
    private double precio;
    private ArrayList<Producto> listaAgregados;
    private boolean esAgregado;

    public Producto(int id,String descripcion, double precio,boolean esAgregado)
    {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esAgregado = esAgregado;
        listaAgregados = new ArrayList<>();
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public void agregarProducto(Producto p)
    {
        if((p != null) && p.isEsAgregado() && !this.isEsAgregado())
            this.listaAgregados.add(p);
    }
    @Override
    public double calcularPrecio()
    {
        double total = this.precio;
        for(Producto p: listaAgregados)
        {
            total += p.calcularPrecio();
        }
        return total;
    }

    public ArrayList<Producto> getListaAgregados() {
        return listaAgregados;
    }

    public void setListaAgregados(ArrayList<Producto> listaAgregados) {
        this.listaAgregados = listaAgregados;
    }

    public boolean isEsAgregado() {
        return esAgregado;
    }

    public void setEsAgregado(boolean esAgregado) {
        this.esAgregado = esAgregado;
    }
    
    
    
}
