/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import conexiones.MyConnection;
import facturacion.vista_factura;
import static facturacion.vista_factura.txt_cantidad;
import static facturacion.vista_factura.txt_clientea;
import static facturacion.vista_factura.txt_clienten;
import static facturacion.vista_factura.txt_codigo;
import static facturacion.vista_factura.txt_codigocliente1;
import static facturacion.vista_factura.txt_empleadoapellido;
import static facturacion.vista_factura.txt_empleadonombre;
import static facturacion.vista_factura.txt_factura;


import static facturacion.vista_factura.txt_nombrepro;
import static facturacion.vista_factura.txt_precio1;
import static facturacion.vista_factura.txt_total;
import interfaz_empleados.registro_nuevo_emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static facturacion.vista_factura.txt_fecha;

public class factura_clases {


  
    public static void suma (){ //realiza la suma para el total
        int a=0;
       int  b=0;

        for (int i=0; i<vista_factura.tabla.getRowCount(); i++){
            a= Integer.parseInt(vista_factura.tabla.getValueAt(i,2).toString());
            
          b+=a;
        }
        
        
   vista_factura.txt_total.setText(""+  b);
    }
    
           public static void resta (){ //realiza la resta para el total
        int a=0;
       int  b=0;

        for (int i=0; i<vista_factura.tabla.getRowCount(); i++){
            a= Integer.parseInt(vista_factura.tabla.getValueAt(i,2).toString());
            
          b-=a;
        }
        
        
   vista_factura.txt_total.setText(""+  b);
    }
        
    

         public static void monto(){ //realiza el monto.
   
        int mon,prec,canti;
   prec=Integer.parseInt(txt_precio1.getText());
      canti=Integer.parseInt(txt_cantidad.getText());
   mon=prec*canti;
  vista_factura.txt_monto.setText(String.valueOf(mon));
   
}
    public static void guardar (){ //guarda datos en la tabla factura.
  


          String detall = txt_factura.getText();
      String nomEm= txt_empleadonombre.getText();
          String apEm= txt_empleadoapellido.getText(); 
             String codclie= txt_codigocliente1.getText();
              String nomclie= txt_clienten.getText();
                  String apel= txt_clientea.getText();
                         String total= txt_total.getText();
                        String fecha= txt_fecha.getText();
     
//Date date = (Date) vista_factura.txt_fecha.getDate(); 
//long d = date.getTime(); 
//java.sql.Date fecha = new java.sql.Date(d);
//DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                            
      
// 
 
              PreparedStatement ps;
        String query = "INSERT INTO `factura`(`ID_detalle`,`Nombre_empleado`,`Apellido_empleado`,`ID_cliente`,`Nombre`,`Apellido`,`Total`,`Fecha_compra`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
       ps.setString(1, detall);
       ps.setString(2, nomEm);
       ps.setString(3, apEm);
       ps.setString(4, codclie);
       ps.setString(5, nomclie);
       ps.setString(6, apel);
        ps.setString(7, total);
         ps.setString(8, fecha);
 
               
         if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Factura guardada");
                
            }
            
//        
                 
        } catch (SQLException ex) {
            Logger.getLogger(registro_nuevo_emp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }

         
         
    }    
}
