package models.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//////////////////////////////////////
/////Por el momento no se usa/////////
//////////////////////////////////////

public class Cifrador {



    //Con este metodo podemos encriptar un documento txt
    public static void cifrarTXT (String entrada, String salida, int clave){
  
        FileReader DocumentoALeer = null;

        try {
            File FileEntrada = new File(entrada);
            File FileSalida = new File(salida);

            DocumentoALeer = new FileReader(FileEntrada);
            FileWriter EscribirEn = new FileWriter(FileSalida);

            BufferedWriter lineaEscrita= new BufferedWriter(EscribirEn);
            BufferedReader lineaLeida = new BufferedReader(DocumentoALeer);
            String leido = null;

            while( (leido = lineaLeida.readLine()) != null ){
                String cifrado = cifrado_Xor(leido,clave);
                EscribirEn.write(cifrado);
  
                lineaEscrita.newLine();
                lineaEscrita.flush();

            }
            lineaEscrita.close();
            lineaLeida.close();
        } catch (Exception e) {
        }


    }

    public static String cifrado_Xor(String cadena, int clave) {
        String ret = "";

        char[] chars = cadena.toCharArray();

        for(int n = 0; n < chars.length;n++){
            char c = (char) (chars[n] ^ clave);
            ret = ret + c;
        }
        return ret;
    }

    public static void main(String []args){
        cifrarTXT("DB_info.txt","DB_criptado.txt",10);
    }


}
