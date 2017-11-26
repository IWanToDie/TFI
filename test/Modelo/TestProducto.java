/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Alvarez
 */
public class TestProducto {
    
    public TestProducto() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void calcularTotal()
    {
        Producto milanesa = new Producto(1, "milanesa", 70, false);
        Producto huevoFrito = new Producto(2,"huevoFrito",15,true);
        Producto jamonCocido = new Producto(3,"jamon cocido",15,true);
        
        milanesa.agregarProducto(huevoFrito);
        milanesa.agregarProducto(jamonCocido);
        
        assertEquals(100, milanesa.calcularPrecio(), 0.05);
    }
    @Test
    public void calcularTotal1()
    {
        Producto milanesa = new Producto(1, "milanesa", 70, false);
        Producto huevoFrito = new Producto(2,"huevoFrito",15,true);
        Producto jamonCocido = new Producto(3,"jamon cocido",15,true);
        
        milanesa.agregarProducto(milanesa);
        milanesa.agregarProducto(huevoFrito);
        milanesa.agregarProducto(jamonCocido);
        
        assertEquals(100, milanesa.calcularPrecio(), 0.05);
    }
    @Test
    public void calcularTota2()
    {
        Producto milanesa = new Producto(1, "milanesa", 70, false);
        Producto huevoFrito = new Producto(2,"huevoFrito",15,true);
        Producto jamonCocido = new Producto(3,"jamon cocido",15,true);
        
        huevoFrito.agregarProducto(jamonCocido);
        milanesa.agregarProducto(milanesa);
        milanesa.agregarProducto(huevoFrito);
        
        
        assertEquals(85, milanesa.calcularPrecio(), 0.05);
    }
    @Test
    public void calcularTota3()
    {
        Producto milanesa = new Producto(1, "milanesa", 70, false);
        
        milanesa.agregarProducto(null);
        
        assertEquals(70, milanesa.calcularPrecio(), 0.05);
    }
}
