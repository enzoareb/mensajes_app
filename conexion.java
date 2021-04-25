package com.mycompany.mensajes_app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    
    public Connection get_connection(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensjes_app","root","");
        }catch(SQLException e){
            System.out.println(e);
        }
        return conexion;
    }
    
}