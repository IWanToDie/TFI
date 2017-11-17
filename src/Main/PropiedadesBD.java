/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Ignacio Alvarez
 */
public class PropiedadesBD 
{
    private final File archivo;
    private static PropiedadesBD instance = null;
    private Map<String,String> mapPropiedades;
    private Properties properties;
    
    private String[] listaPropiedades;

    private PropiedadesBD() {
        
        mapPropiedades = new HashMap<>();
        
        archivo = new File("D:\\Documentos\\NetBeansProjects\\TFI\\propiedadesBD.txt");
        
        try (FileInputStream fileInput = new FileInputStream(archivo)) 
        {
            properties = new Properties();
            properties.load(fileInput);
            Enumeration enuKeys = properties.keys();
            int i = 0;
            while (enuKeys.hasMoreElements()) 
            {
                String key = (String) enuKeys.nextElement();
                listaPropiedades[i] = properties.getProperty(key);
                i++;
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static PropiedadesBD getInstance() {
        if (instance == null){
            instance = new PropiedadesBD();
        } 
        
        return instance;
    }

    public Map<String, String> getMapPropiedades() {
        return mapPropiedades;
    }

    public void setMapPropiedades(Map<String, String> mapPropiedades) {
        this.mapPropiedades = mapPropiedades;
    }

    public String[] getListaPropiedades() {
        return listaPropiedades;
    }

    public void setListaPropiedades(String[] listaPropiedades) {
        this.listaPropiedades = listaPropiedades;
    }
    

    
    
}
