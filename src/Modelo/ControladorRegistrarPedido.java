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
public class ControladorRegistrarPedido 
{
    private IVentanaPedido ventana;
    
    public ControladorRegistrarPedido()
    {
        
    }

    public IVentanaPedido getVentana() {
        return ventana;
    }

    public void setVentana(IVentanaPedido ventana) {
        this.ventana = ventana;
    }
    
    
}
