/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conexion {
    
    Connection con=null;
    String user="tU9mvPkeof";// User de BD
    String pass="CHCEIwABky";// Pass de BD
    String server="jdbc:mysql://remotemysql.com:3306/"; //URL de Servidor que aloja la BD (localhost significa que está en su propio computador.
    String db="tU9mvPkeof"; //nombre de la BD
    String driver="com.mysql.jdbc.Driver"; //Dependiendo del motor de BD que use, debe modificar este valor.
    //MYSQL : "jdbc:mysql://localhost/bdejemplo"
    //Derby : "jdbc:derby://localhost/bdejemplo"
    
public Conexion() {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(server+db, user, pass);
            //JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public Connection getConexion(){
        return con;   
    }

    public Connection cerrarConexion(){
        
        try {
            con.close();
             System.out.println("Cerrando conexion a "+server+db+" . . . . . Ok");
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        con=null;
        return con;

    }

}
    
