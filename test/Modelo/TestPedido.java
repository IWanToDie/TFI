package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Alvarez
 */
public class TestPedido 
{
    
    @Test
    public void getTotal()
    {
        Pedido pedido = new Pedido(new Mozo("nombre", "apellido"), new Mesa(1));
        

        
        assertEquals(100.50, pedido.getTotal(),0.1);
    }
    
    
}
