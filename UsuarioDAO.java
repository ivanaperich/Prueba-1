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

/**
 *
 * @author usuario
 */
public class UsuarioDAO {  
    Conexion con;

    public UsuarioDAO() {
        this.con= new Conexion();
    }
    
    public ArrayList<Usuario> getUsuarios(){
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM usuario";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                String nombre = resultados.getString("nombre");
                int id_usuario = Integer.parseInt(resultados.getString("id_usuario"));
                usuarios.add(new Usuario(id_usuario, nombre));
            }
            accesoBD.close();
            return usuarios;
        }catch (Exception e){System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
      
    }    
    

    
  public boolean guardarUsuario(Usuario u){
        boolean respuesta = false; 
        try{
            Connection con = this.con.getConexion();
            Statement statement=con.createStatement(); 
            String sql= "INSERT INTO usuario"+
                        "Values (null,"+u.getNombre()+","+u.getId_usuario();
             statement.executeUpdate(sql);
            respuesta = true; 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    
}

    

