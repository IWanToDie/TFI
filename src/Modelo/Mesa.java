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
public class Mesa 
{
    private int numero;
    private boolean estado = false;
    private ArrayList<Pedido> listaPedidos;
    
    public Mesa(int numero)
    {
        this.numero = numero;
        listaPedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void agregarPedido(Pedido p)
    {
        listaPedidos.add(p);
    }
    public double calcularTotal()
    {
        double total = 0;
        for(Pedido p: listaPedidos)
        {
            total += p.getTotal();
        }
        return total;
    }
    
}
