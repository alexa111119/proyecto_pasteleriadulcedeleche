/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;
import clientes.nuevo_cliente;
import conexiones.MyConnection;
import interfaz_empleados.registro_nuevo_emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static facturacion.factura_clases.suma;
import static facturacion.factura_clases.monto;
import static facturacion.factura_clases.guardar;
import static facturacion.factura_clases.resta;
import interfaz_empleados.roles_empleados;
import interfaz_ingredientes.ingredientes;
import interfaz_productos.productos;
import java.sql.ResultSet;
import java.sql.Statement;




public class vista_factura extends javax.swing.JFrame {
    

        DefaultTableModel deta;
        
    public vista_factura() {
        
        
        initComponents();
      
       this.deta = (DefaultTableModel) tabla.getModel();
       Mostrardatos("");
    suma();
    num();
    txt_fecha.setText(Fecha());
    
//    usuario();
    
    
    
    }
    public static void usuario ()   {
        
                   String nom= roles_empleados.txt_nombre.getText();
                    String ap= roles_empleados.txt_apellido.getText();
                    txt_empleadonombre.setText(nom);
                     txt_empleadoapellido.setText(ap);
                     
        
    }
       public static void inv ()   {
        
                    int inv;
                   

                
                   inv = Integer.parseInt(txt_inv.getText());
                   
                   if (inv<5 ){
                      JOptionPane.showMessageDialog(null, "El producto se esta agotando" );
                      
                   }
//                  
//                 
//                     
//        
    }
       
//              
//                  public static void invcan ()   {
//        
//                  
//                 //este metodo compara la cantidad comprada con el inventario
//                     
//        
//    }
//              
//              
       
       
    
    
                    
     int lastid;
    Statement st;
    ResultSet rs;
    
    public static String Fecha(){
     Date fecha = new Date();
     SimpleDateFormat formatofecha=new SimpleDateFormat("YYYY/MM/dd");
        return formatofecha.format(fecha);
        
    }
    public void num()
    {
        try{
            Connection con = MyConnection.getConnection();
            String sql = "select max(ID_Factura) from factura";
            st= con.createStatement();
            
            rs=st.executeQuery(sql);
            if(rs.next()){
                lastid = rs.getInt(1);
                lastid++;
                vista_factura.txt_factura.setText(Integer.toString(lastid));
            }
            else{
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(factura_clases.class.getName()).log(Level.SEVERE, null, ex);
        }
//  
    
    }

   
        public final void Mostrardatos(String valor){
           
            MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
          
        deta.addColumn("ID_producto");
            deta.addColumn("Nombre");
            deta.addColumn("Precio");
               deta.addColumn("Cantidad");
     }
        
        //metodo para vaciar la tabla.
          public  void LimpiarTabla() {
        for (int i = 0; i < deta.getRowCount(); i++) {
            deta.removeRow(i);
            i = i - 1;
        }
   }
       

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog2 = new javax.swing.JDialog();
        jFrame2 = new javax.swing.JFrame();
        jDialog3 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        btt_buscarp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_empleadonombre = new javax.swing.JTextField();
        txt_empleadoapellido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigocliente1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_clienten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_clientea = new javax.swing.JTextField();
        btt_cliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_nombrepro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btt_sumar = new javax.swing.JButton();
        btt_restar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        btt_nueva = new javax.swing.JButton();
        btt_guardar = new javax.swing.JButton();
        btt_imprimir = new javax.swing.JButton();
        x = new javax.swing.JLabel();
        txt_precio1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btt_cliente2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_inv = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        agregar_cliente = new javax.swing.JButton();
        inventario_ingredientes = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        inv_pro = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FACTURA");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("NO. factura.");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 101, -1, -1));

        txt_factura.setEditable(false);
        jPanel2.add(txt_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 178, -1));

        btt_buscarp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btt_buscarp.setText("Buscar producto");
        btt_buscarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_buscarpActionPerformed(evt);
            }
        });
        jPanel2.add(btt_buscarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 327, -1, 16));

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel4.setText("Persona que atendio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel11.setText("Nombre");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel12.setText("Apellido");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        txt_empleadonombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empleadonombreActionPerformed(evt);
            }
        });
        jPanel2.add(txt_empleadonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 161, -1));
        jPanel2.add(txt_empleadoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 161, -1));

        jLabel13.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel13.setText("FECHA");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 136, -1, -1));

        jLabel15.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel15.setText("DATOS GENERALES.");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel16.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel16.setText("DATOS DEL CLIENTE");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Codigo del cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));
        jPanel2.add(txt_codigocliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 138, -1));

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        txt_clienten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clientenActionPerformed(evt);
            }
        });
        jPanel2.add(txt_clienten, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 183, -1));

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 172, -1, -1));
        jPanel2.add(txt_clientea, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 183, -1));

        btt_cliente.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_cliente.setText("Buscar cliente");
        btt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(btt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        jLabel10.setText("SISTEMA DE VENTAS");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        txt_fecha.setEditable(false);
        txt_fecha.setText("YYYY/MM/DD");
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 180, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel6.setText("Codigo del producto");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel4.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 210, -1));

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel7.setText("Nombre del producto");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        jPanel4.add(txt_nombrepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 210, -1));

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel8.setText("Cantidad");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));
        jPanel4.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 129, -1));

        btt_sumar.setBackground(new java.awt.Color(204, 204, 255));
        btt_sumar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btt_sumar.setText("+");
        btt_sumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_sumarActionPerformed(evt);
            }
        });
        jPanel4.add(btt_sumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        btt_restar.setBackground(new java.awt.Color(204, 204, 255));
        btt_restar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btt_restar.setText("-");
        btt_restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_restarActionPerformed(evt);
            }
        });
        jPanel4.add(btt_restar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, -1, -1));

        tabla.setFont(new java.awt.Font("Ebrima", 0, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 695, 200));
        jPanel4.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 169, -1));

        btt_nueva.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_nueva.setText("NUEVA FACTURA");
        btt_nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_nuevaActionPerformed(evt);
            }
        });
        jPanel4.add(btt_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        btt_guardar.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_guardar.setText("GUARDAR");
        btt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(btt_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        btt_imprimir.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_imprimir.setText("IMPRIMIR");
        btt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_imprimirActionPerformed(evt);
            }
        });
        jPanel4.add(btt_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        x.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        x.setText("Precio del producto");
        jPanel4.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel4.add(txt_precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, -1));

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel9.setText("Total");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, -1, 20));

        btt_cliente2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btt_cliente2.setText("Ver todos los productos");
        btt_cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cliente2ActionPerformed(evt);
            }
        });
        jPanel4.add(btt_cliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel14.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel14.setText("Monto");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));
        jPanel4.add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 130, -1));

        jLabel18.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel18.setText("Inventario");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        txt_inv.setEditable(false);
        jPanel4.add(txt_inv, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 130, -1));

        jPanel6.setBackground(new java.awt.Color(202, 189, 255));

        agregar_cliente.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        agregar_cliente.setText("Agregar nuevo cliente");
        agregar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_clienteActionPerformed(evt);
            }
        });

        inventario_ingredientes.setBackground(new java.awt.Color(255, 255, 255));
        inventario_ingredientes.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        inventario_ingredientes.setText("Ver inventario de ingredientes");
        inventario_ingredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventario_ingredientesActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono2_1.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Ebrima", 0, 11)); // NOI18N
        jLabel19.setText("\"Endulzando tu alma con miles de sabores\"");

        jLabel20.setFont(new java.awt.Font("Ebrima", 1, 17)); // NOI18N
        jLabel20.setText("Pasteleria dulce de leche");

        inv_pro.setBackground(new java.awt.Color(255, 255, 255));
        inv_pro.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        inv_pro.setText("Ver inventario de productos");
        inv_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_proActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(agregar_cliente)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel19))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inv_pro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inventario_ingredientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(57, 57, 57)
                .addComponent(agregar_cliente)
                .addGap(27, 27, 27)
                .addComponent(inventario_ingredientes)
                .addGap(27, 27, 27)
                .addComponent(inv_pro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(827, 827, 827))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_imprimirActionPerformed
 Connection cn= MyConnection.getConnection();
        try{
            int txtFac;
          JasperReport jr = (JasperReport) JRLoader.loadObject(vista_factura.class.getResource("/facturacion/reportenuevo.jasper"));
          Map parametros = new HashMap<>();
          parametros.put("factura",txtFac = Integer.parseInt(txt_factura.getText()));
          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setVisible(true); 
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }       

        //imprime la factura.
       
    }//GEN-LAST:event_btt_imprimirActionPerformed

    private void btt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_guardarActionPerformed
       //guardar factura
         int inv;
                    int can;
                   inv = Integer.parseInt(txt_inv.getText());
                      can = Integer.parseInt(txt_cantidad.getText());
                   
                   if (can>inv){
                      JOptionPane.showMessageDialog(null, "No hay suficiente inventario para realizar esta venta" );
                       
                   }
                   else{
                       
                 
     String detalle = txt_factura.getText();
    for (int i=0; i<tabla.getRowCount();i++){
        
        PreparedStatement ps;
        String query = "INSERT INTO `detalle_factura`(`ID_detalle`,`ID_producto`, `Nombrepro`,`Precio`,`Cantidad`) VALUES (?,?,?,?,?)";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
              
            ps.setString(1, detalle);
    
          ps.setString(2, tabla.getValueAt(i, 0).toString());
          ps.setString(3, tabla.getValueAt(i, 1).toString());
          ps.setString(4, tabla.getValueAt(i, 2).toString());
          ps.setString(5, tabla.getValueAt(i, 3).toString());
     
            if(ps.executeUpdate() > 0)
            {
            }
            
//        
                 
        } catch (SQLException ex) {
            Logger.getLogger(registro_nuevo_emp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }
      guardar();
    }
    
  
    }//GEN-LAST:event_btt_guardarActionPerformed

    private void btt_nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_nuevaActionPerformed
        txt_codigocliente1.setText("");
        txt_clienten.setText("");
        txt_clientea.setText("");
        txt_codigo.setText("");
        txt_precio1.setText("");
        txt_nombrepro.setText("");
        txt_total.setText("");
        txt_monto.setText("");
        txt_factura.setText("");
         txt_fecha.setText("");
          txt_factura.setText("");
           txt_empleadonombre.setText("");
            txt_empleadoapellido.setText("");
            txt_cantidad.setText("");
        LimpiarTabla();
        num();
    
     //limpia los campos.
    }//GEN-LAST:event_btt_nuevaActionPerformed

    private void btt_restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_restarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        dtm.removeRow(tabla.getSelectedRow());
        resta();
        //resta algo seleccionado dentro de la tabla
    }//GEN-LAST:event_btt_restarActionPerformed

    private void btt_sumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_sumarActionPerformed
monto();
        String cod = txt_codigo.getText();
        String nombre = txt_nombrepro.getText();
        String precio = txt_monto.getText();
        String cantidad = txt_cantidad.getText();

        deta.addRow(new Object[]{cod,nombre,precio,cantidad});
        suma();

//suma algo seleccionado a la tabla
    }//GEN-LAST:event_btt_sumarActionPerformed

    private void btt_cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cliente2ActionPerformed
        buscar_producto produ= new buscar_producto();
        produ.setVisible(true);
    }//GEN-LAST:event_btt_cliente2ActionPerformed

    private void btt_buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_buscarpActionPerformed
        buscar_producto pro= new buscar_producto();
        pro.setVisible(true);
    }//GEN-LAST:event_btt_buscarpActionPerformed

    private void btt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_clienteActionPerformed
        buscar_cliente cl= new buscar_cliente();
        cl.setVisible(true);
    }//GEN-LAST:event_btt_clienteActionPerformed

    private void agregar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_clienteActionPerformed
   nuevo_cliente cliente= new nuevo_cliente ();
        cliente.setVisible(true);
    }//GEN-LAST:event_agregar_clienteActionPerformed

    private void inventario_ingredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventario_ingredientesActionPerformed
     ingredientes ingre= new ingredientes ();
       ingre.setVisible(true);
    }//GEN-LAST:event_inventario_ingredientesActionPerformed

    private void txt_clientenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clientenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clientenActionPerformed

    private void txt_empleadonombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empleadonombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empleadonombreActionPerformed

    private void inv_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_proActionPerformed
        // TODO add your handling code here:
         productos ingre= new productos ();
       ingre.setVisible(true);
    }//GEN-LAST:event_inv_proActionPerformed

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
            java.util.logging.Logger.getLogger(vista_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton agregar_cliente;
    public javax.swing.JButton btt_buscarp;
    public javax.swing.JButton btt_cliente;
    public javax.swing.JButton btt_cliente2;
    public javax.swing.JButton btt_guardar;
    public javax.swing.JButton btt_imprimir;
    public javax.swing.JButton btt_nueva;
    public javax.swing.JButton btt_restar;
    public javax.swing.JButton btt_sumar;
    public javax.swing.JButton inv_pro;
    public javax.swing.JButton inventario_ingredientes;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_clientea;
    public static javax.swing.JTextField txt_clienten;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_codigocliente1;
    public static javax.swing.JTextField txt_empleadoapellido;
    public static javax.swing.JTextField txt_empleadonombre;
    public static javax.swing.JTextField txt_factura;
    public static javax.swing.JTextField txt_fecha;
    public static javax.swing.JTextField txt_inv;
    public static javax.swing.JTextField txt_monto;
    public static javax.swing.JTextField txt_nombrepro;
    public static javax.swing.JTextField txt_precio1;
    public static javax.swing.JTextField txt_total;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
