/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;


import conexiones.MyConnection;
import static facturacion.vista_factura.inv;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
/**
 *
 * @author DELL
 */
public class buscar_producto extends javax.swing.JFrame {

    /**
     * Creates new form buscar_producto
     */
     DefaultTableModel producto;
    public buscar_producto() {
        initComponents();
        
            this.producto = (DefaultTableModel) tabla_producto.getModel();
       Mostrardatos("");
//       cantidad_reducida();
    }
    
    
//    public void cantidad_reducida(){
//   int cantidad = (int) producto.getValueAt(tabla_producto.getSelectedRow(),3);
//   
//        if (cantidad<5){
//                  JOptionPane.showMessageDialog(null, "el producto se esta acabando" );
//        }
//    }
  public final void Mostrardatos(String valor){
           
            MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
           RefrescarTabla();
          producto.addColumn("Codigo");
            producto.addColumn("Nombre del producto");
             producto.addColumn("Precio");  
             producto.addColumn("Cantidad en el inventario");
             
            
           
 
            this.tabla_producto.setModel(producto);
            String sql;
            if (valor.equals(""))
            {
            sql="SELECT ID_producto, Nombre, Precio, Cantidad_en_existencia FROM producto_postres";
            }
            else{
            sql="SELECT ID_producto, Nombre, Precio, Cantidad_en_existencia FROM producto_postres WHERE producto_postres='"+valor+"'";
            } 
            
            String []datos=new String [4];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);

 
         producto.addRow(datos);
            }
            tabla_producto.setModel((TableModel) producto);
            }catch(SQLException ex){
            Logger.getLogger(vista_factura.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    


    

public final void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        producto.setColumnCount(0);
       producto.setRowCount(0);
        tabla_producto.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
}
        
//        public void Limpiar(){
//       
//        try{
//        txt_nombre.setText("");
//        txt_precio.setText("");
//        txt_descripcion.setText("");
//  
//        txt_ingredientes.setText("");
//        txt_codigo.setText("");
//        }
//        
//        catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "error "+ex);
//        
//    }
//        } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_producto = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btt_aceptarp1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_productoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_productoMousePressed(evt);
            }
        });
        tabla_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_productoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_producto);

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel9.setText(" Productos");

        btt_aceptarp1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_aceptarp1.setText("Aceptar ");
        btt_aceptarp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_aceptarp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btt_aceptarp1)
                .addGap(251, 251, 251))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel9)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btt_aceptarp1)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productoMouseClicked
         
    try {  
        String id = (String) producto.getValueAt(tabla_producto.getSelectedRow(),0);
        String nombre = (String) producto.getValueAt(tabla_producto.getSelectedRow(),1);
               String precio = (String) producto.getValueAt(tabla_producto.getSelectedRow(),2);
               String inv = (String) producto.getValueAt(tabla_producto.getSelectedRow(),3);
               
            
   
       
       vista_factura.txt_codigo.setText(id);
       vista_factura.txt_nombrepro.setText(nombre);
       
              vista_factura.txt_precio1.setText(precio);
               vista_factura.txt_inv.setText(inv);
              
       
      
     
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    Mostrardatos("");
    
    }//GEN-LAST:event_tabla_productoMouseClicked

    private void tabla_productoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productoMousePressed
     
    }//GEN-LAST:event_tabla_productoMousePressed

    private void tabla_productoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_productoKeyPressed
  
    }//GEN-LAST:event_tabla_productoKeyPressed

    private void btt_aceptarp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_aceptarp1ActionPerformed
     inv();
//     
        this.dispose();
    }//GEN-LAST:event_btt_aceptarp1ActionPerformed

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
            java.util.logging.Logger.getLogger(buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscar_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btt_aceptarp1;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tabla_producto;
    // End of variables declaration//GEN-END:variables
}