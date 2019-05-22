/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.MensajeDAO;
import modelo.Mensaje;

/**
 *
 * @author usuario
 */
public class BandejaController {
    JTable tabla;
    int idUsuarioLogueado;

    public BandejaController(JTable tabla, int id) {
        this.tabla = tabla;
        idUsuarioLogueado=id;
    }
           
    public void actualizarTabla(){       
            DefaultTableModel dtm=(DefaultTableModel) tabla.getModel();
            dtm.setRowCount(0);
            MensajeDAO m= new MensajeDAO();
            ArrayList<Mensaje> msj = new ArrayList<>();
            msj=m.getMensajesdeUsuario(idUsuarioLogueado);
            
            for (int i = 0; i < msj.size(); i++) {
                Mensaje ms=msj.get(i);
                String v[]={""+ms.getId_emisor(),""+ms.getContenido()};
                dtm.addRow(v);
            }
            
        }
        
    }

