package models.database;

import java.io.File;
import java.util.Scanner;


//Por el momento no usamos el cifrador
public class Lector{
    private String[] Datos;
    
    public Lector(){
        this.Datos = leerArchivo();
    }

    private String[] leerArchivo(){
        try {
            File archivo = new File("DB_info.txt");
            Scanner datos = new Scanner(archivo);
            String linea= datos.nextLine();
            linea = datos.nextLine();
            String[] parte = linea.split(",");
            datos.close();
            return parte;
            
        } catch (Exception e) {
            String[] parte = null;
            return parte;
        }
    }

    public String[] getDatos(){
        return Datos;
    }

    /* 
    public static void main (String []args){
        Lector lec = new Lector();
        System.out.println(lec.getDatos());
    }
    */


}