package com.mycompany.mensajes_app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MensajesDAO {
    
    public static void crearMensajeDB (Mensajes mensaje){
        conexion db_connect = new conexion();
        try ( Connection cnx = db_connect.get_connection() ){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (? ,?);";
                ps = cnx.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        }
    public static void leerMensajeDB(){
        conexion db_connect = new conexion();
        try (Connection cnx = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT * FROM `mensajes`";
                ps = cnx.prepareStatement(query);
                rs= ps.executeQuery();
                while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensajeS"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
                }
                } catch (SQLException ex) {
                System.out.println(ex);
                }
            } catch (SQLException e) {
            System.out.println(e);
        }
        }
    public static void borrarMensajeDB(int id_mensaje){
        conexion db_connect = new conexion();
        
        try(Connection conexion = db_connect.get_connection())  {
        PreparedStatement ps=null;
        
            try {
                String query="DELETE FROM mensajes WHERE id_mensajes = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");
            }catch(SQLException e) {
                System.out.println(e);
                 System.out.println("no se pudo borrar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        }
    public static void actualizarMensajeDB(Mensajes mensaje){
        conexion db_connect = new conexion();
        
        try(Connection conexion = db_connect.get_connection())  { 
        PreparedStatement ps=null;
        
            try{ 
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensajes = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje se actualizó correctamente");
            }catch(SQLException ex){ 
                System.out.println(ex);
                System.out.println("no se pudo actualizar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        }
}