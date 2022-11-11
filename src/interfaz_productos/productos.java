/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_productos;

import conexiones.MyConnection;
import facturacion.vista_factura;
import static facturacion.vista_factura.txt_factura;
import interfaz_empleados.registro_nuevo_emp;
import interfaz_empleados.roles_empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author DELL
 */
public class productos extends javax.swing.JFrame {
    
   DefaultTableModel productopostres;
  
    public productos() {
       initComponents();
       this.productopostres = (DefaultTableModel) tabla.getModel();
       Mostrardatos("");
         
           
             
         
         
       
    }
    public final void Mostrardatos(String valor){
           
            MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
           RefrescarTabla();
          productopostres.addColumn("ID_producto");
            productopostres.addColumn("Nombre");
            productopostres.addColumn("Precio");
            productopostres.addColumn("Descripcion");
           
            productopostres.addColumn("Ingredientes");
              productopostres.addColumn("Codigo_producto");

 
            this.tabla.setModel(productopostres);
            String sql;
            if (valor.equals(""))
            {
            sql="SELECT * FROM producto_postres";
            }
            else{
            sql="SELECT * FROM producto_postres WHERE producto_postres='"+valor+"'";
            } 

            String []datos=new String [6];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            datos[5]=rs.getString(6);

 
         productopostres.addRow(datos);
            }
            tabla.setModel((TableModel) productopostres);
            }catch(SQLException ex){
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    
    
public final void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        productopostres.setColumnCount(0);
       productopostres.setRowCount(0);
        tabla.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
}
        
        public void Limpiar(){
       
        try{
        txt_nombre.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
  
        txt_ingredientes.setText("");
        txt_codigo.setText("");
        }
        
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        } 
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_ingredientes = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        boton_insertar = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 224, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel1.setBackground(new java.awt.Color(102, 102, 0));
        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 24)); // NOI18N
        jLabel1.setText("CONTROL DE PRODUCTOS (POSTRES)");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
                s(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Ingresa su ID");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Buscar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ingredientes");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Codigo del producto");

        boton_insertar.setBackground(new java.awt.Color(255, 255, 255));
        boton_insertar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        boton_insertar.setText("Insertar un nuevo producto");
        boton_insertar.setBorder(null);
        boton_insertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertar(evt);
            }
        });
        boton_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_insertarActionPerformed(evt);
            }
        });

        boton_modificar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        boton_modificar.setText("Modificar producto");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        boton_eliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        boton_eliminar.setText("Eliminar producto");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(boton_insertar)
                                .addGap(39, 39, 39)
                                .addComponent(boton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_descripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(87, 87, 87))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(312, 312, 312)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_modificar)
                    .addComponent(boton_eliminar)
                    .addComponent(boton_insertar))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PreparedStatement ps;
         ResultSet rs;
                 String query =("SELECT*FROM producto_postres WHERE ID_producto = ?");
    
             try {
           ps = MyConnection.getConnection().prepareStatement(query);
           ps.setString(1, txt_id.getText());
           
            rs=ps.executeQuery();
            
            if (rs.next()){
                txt_nombre.setText(rs.getString("Nombre"));
                txt_precio.setText(rs.getString("Precio"));
                 txt_descripcion.setText(rs.getString("Descripcion"));
            
                   txt_ingredientes.setText(rs.getString("Ingredientes"));
                 txt_codigo.setText(rs.getString("Codigo_producto"));
                
                
            } else {
                     JOptionPane.showMessageDialog(null, "Producto no encontrado" );
            }
                  
                  
                  
                  
                    } catch (SQLException ex) {
            Logger.getLogger(roles_empleados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
          
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void insertar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertar
      String nom = txt_nombre.getText();
      String prec= txt_precio.getText();
      String desc = txt_descripcion.getText();

      String ingre= txt_ingredientes.getText();
 
      String cod= txt_codigo.getText();
         
        PreparedStatement ps;
        String query = "INSERT INTO `producto_postres`(`Nombre`,`Precio`, `Descripcion`,`Ingredientes`,`Codigo_producto`) VALUES (?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
       ps.setString(1, nom);
       ps.setString(2, prec);
       ps.setString(3, desc);
      
       ps.setString(4,ingre);
       ps.setString(5,cod);
               
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo producto agregado");
                
            }
            
//        
                 
        } catch (SQLException ex) {
            Logger.getLogger(registro_nuevo_emp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
         Mostrardatos("");
    }//GEN-LAST:event_insertar

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        String id = txt_id.getText();
        String nom = txt_nombre.getText();
        String prec = txt_precio.getText();
        String desc = txt_descripcion.getText();
    
        String ingre = txt_ingredientes.getText();
        String cod = txt_codigo.getText();
        
        PreparedStatement ps;
        String query = "UPDATE producto_postres SET Nombre=?, Precio=?, Descripcion=?, Ingredientes=?, Codigo_producto=?  WHERE ID_producto=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            
            ps.setString(1, nom);
            ps.setString(2, prec);
            ps.setString(3, desc);
            ps.setString(4, ingre);
            ps.setString(5, cod);
            ps.setString(6, id);
        
 
            ps.executeUpdate();
                JOptionPane.showMessageDialog(null, " Producto Modificado");
               
                
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
         Mostrardatos("");
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
  
              
        String id = txt_id.getText();
      
          
        PreparedStatement ps;
        String query = "DELETE FROM producto_postres WHERE ID_producto=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            
            ps.setString(1, id);
         
        
 
            ps.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(null, " Producto eliminado");
               
                
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "error "+ex);
            }
           Mostrardatos("");

    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
    

 
 
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
           
    try {  
        String id = (String) productopostres.getValueAt(tabla.getSelectedRow(),0);
        String nombre = (String) productopostres.getValueAt(tabla.getSelectedRow(),1);
        String precio = (String) productopostres.getValueAt(tabla.getSelectedRow(),2);
        String descripcion = (String) productopostres.getValueAt(tabla.getSelectedRow(),3);
      
String ingre = (String) productopostres.getValueAt(tabla.getSelectedRow(),4);
String cod = (String) productopostres.getValueAt(tabla.getSelectedRow(),5);
        
        txt_id.setText(id);
        txt_nombre.setText(nombre);
        txt_precio.setText(precio);
        txt_descripcion.setText(descripcion);
      txt_ingredientes.setText(ingre);
          txt_codigo.setText(cod);
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    Mostrardatos("");
    
    }//GEN-LAST:event_tablaMousePressed

    private void s(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s
     
    }//GEN-LAST:event_s

    private void boton_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_insertarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_insertarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new productos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_eliminar;
    public javax.swing.JButton boton_insertar;
    public javax.swing.JButton boton_modificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ingredientes;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
