/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Mensaje;
import modelo.Usuario;


public class MensajeDAO {
    Conexion con;

    public MensajeDAO() {
        this.con= new Conexion();
    }
    
        public ArrayList<Mensaje> getMensajes(){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
             while ( resultados.next() ) {
                int id_mensaje = resultados.getInt("id_mensaje");
                int id_emisor = resultados.getInt("id_usr_emisor");
                int id_receptor = resultados.getInt("id_usr_receptor");
                String contenido = resultados.getString("contenido");
                mensajes.add(new Mensaje(id_mensaje, id_emisor, id_receptor, contenido));                
            }
            accesoBD.close();
            return mensajes;
        }catch (Exception e){System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
      
    }    
    
    public ArrayList<Mensaje> getMensajesdeUsuario(int idUsuarioLogueado){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje WHERE id_usr_receptor="+idUsuarioLogueado;
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id_mensaje = resultados.getInt("id_mensaje");
                int id_emisor = resultados.getInt("emisor");
                int id_receptor = resultados.getInt("receptor");
                String contenido = resultados.getString("contenido");
                mensajes.add(new Mensaje(id_mensaje, id_emisor, id_receptor, contenido));                
            }
            accesoBD.close();
            return mensajes;
        }catch (Exception e){System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
    
    
  public boolean guardarMensaje(Mensaje m){
        boolean respuesta = false; 
        try{
            Connection con = this.con.getConexion();
            Statement statement=con.createStatement(); 
            String sql= "INSERT INTO mensaje"+
                        "Values (null,"+m.getId_mensaje()+","+m.getContenido()+"";
             statement.executeUpdate(sql);
            respuesta = true; 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    
    
}
