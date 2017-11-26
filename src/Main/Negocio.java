/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Modelo.Mesa;
import Modelo.Mozo;
import Modelo.IVendible;
import java.util.ArrayList;

/**
 *
 * @author Ignacio Alvarez
 */
public class Negocio 
{
    private ArrayList<Mesa> listaMesas;
    private ArrayList<Mozo> listaMozos;
    private ArrayList<IVendible> listaVendibles;
    
    public Negocio()
    {
        listaMesas = new ArrayList<>();
        listaMozos = new  ArrayList<>();
        listaVendibles = new ArrayList<>();
    }
}
