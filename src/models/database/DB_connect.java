package models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





/* */

public class DB_connect {
    private String motor;
    private String server;
    private String puerto;
    private String bd;
    private String username;
    private String password;
    private Connection red;


    public DB_connect(){
        Lector lector = new Lector();
        String[] parte = lector.getDatos();
        //asigno valores por cada datos que tenemos por linea
        this.motor = parte[0];
        this.server = parte[1];
        this.puerto = parte[2];
        this.bd = parte[3];
        this.username = parte[4];
        this.password = parte[5];
    }

    public Connection Generate_Connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            red = (Connection)DriverManager.getConnection(("jdbc:" + motor + "://" + server + ":" + puerto + "/" + bd), username, password);

            
        } catch (Exception e) {
            System.out.println(e);

        }

        return red;
    }

    //Cierre de la conexion generada
    public void Finish () throws SQLException{
        red.close();
    }

    //Mandamos el url en forma de texto
    public String DBName(){
        return ("jdbc:" + motor + "://" + server + ":" + puerto + "/" + bd);
    }
}