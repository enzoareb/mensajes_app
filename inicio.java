package com.mycompany.mensajes_app;
import java.sql.Connection;
import java.util.Scanner;

public class inicio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion=0;
        do {  
            System.out.println("------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar mensaje");
            System.out.println("3. editar mensaje");
            System.out.println("4. borrar mensaje");
            System.out.println("5. salir");
            //leemos opcion de usuario ingresa
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    mensajesService.crearMensaje();
                    break;
                case 2:
                    mensajesService.listarMensaje();
                    break;
                case 3:
                    mensajesService.editarMensaje();
                    break;
                case 4:
                    mensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
            
            
        } while (opcion != 5);
        
        
        
        
        
        
        
        
    }
    
    
}
