/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabla;

import java.sql.*;
//import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import testtabla.Models.EventoModel;

/**
 *
 * @author Ghost
 */
public class MainFrame extends javax.swing.JFrame {

    Connection conn = ConexionBD.getInstance().getConnection();
    EventoModel evento = new EventoModel();

    DefaultTableModel modTblBebidas;
    DefaultTableModel modTblPrediccion;
    
    String itosDenominacion(int code){
        switch(code){
            case 0:
                return "Mililitros";
            case 1:
                return "Medio litros";
            case 2:
                return "Litros";
            case 3:
                return "Dos litros";
            case 4:
                return "Tres litros";
        }
        return "Error";
    }

    /*public void cargarComboBoxBarras(){
     try{
     String qBuscarProductos = "SELECT * FROM barras";

     PreparedStatement execQuery = conn.prepareStatement(qBuscarProductos);
     ResultSet resQuery = execQuery.executeQuery();

     DefaultComboBoxModel listaBarras = new DefaultComboBoxModel();

     while(resQuery.next()){
     String producto = resQuery.getString("nombre");

     //Agregar elemento
     listaBarras.addElement(producto);
     }

     cboxBarra.setModel(listaBarras);
     }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
     }
     }*/
    public void cargarBebidas() {

        try {
            String query = "SELECT * FROM bebidas";

            PreparedStatement execQuery = conn.prepareStatement(query);

            ResultSet resultQuery = execQuery.executeQuery();

            DefaultTableModel tablaTotal = (DefaultTableModel) tblBebidas.getModel();

            //Hacer que la tabla se de cuenta de la ultima posición
            //tablaTotal.setRowCount(tablaTotal.getRowCount());
            tablaTotal.setRowCount(0);

            while (resultQuery.next()) {
                //Obtener precio total
                int id = resultQuery.getInt("id_bebida");
                String nombre = resultQuery.getString("nombre");

                //Campos a rellenar
                Object resultado[] = {
                    id,
                    nombre
                };

                //Poner información en la tabla 
                tablaTotal.addRow(resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        //cargarComboBoxBarras();
        cargarBebidas();

        this.modTblBebidas = (DefaultTableModel) tblBebidas.getModel();
        this.modTblPrediccion = (DefaultTableModel) tblPrediccion.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrediccion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelNombreEvento = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBebidas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEventos = new javax.swing.JMenu();
        menuBebidas = new javax.swing.JMenu();
        menuHistorial = new javax.swing.JMenu();
        menuOpciones = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");
        setResizable(false);

        tblPrediccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad", "Denominación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPrediccion);

        jLabel1.setText("Evento:");

        labelNombreEvento.setText("[Nombre de evento]");

        jButton1.setText("Elegir Evento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Personas:");

        txtPersonas.setText("0");

        btnGenerar.setText("Generar Pronóstico");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel4.setText("Agregar");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBebidas);

        menuEventos.setText("Eventos");
        menuEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEventosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuEventos);

        menuBebidas.setText("Bebidas");
        menuBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBebidasMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuBebidas);

        menuHistorial.setText("Historial");
        menuHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHistorialMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuHistorial);

        menuOpciones.setText("Opciones");
        menuOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOpcionesMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuOpciones);

        menuAyuda.setText("Ayuda");
        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar)
                .addGap(274, 274, 274)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(labelNombreEvento)
                        .addGap(246, 246, 246)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(labelNombreEvento)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEventosMouseClicked
        // TODO add your handling code here:
        System.out.println("Botón Eventos");
        new EventosFrame().setVisible(true);
    }//GEN-LAST:event_menuEventosMouseClicked

    private void menuBebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBebidasMouseClicked
        // TODO add your handling code here:
        System.out.println("Botón Bebidas");
        new BebidasFrame().setVisible(true);
    }//GEN-LAST:event_menuBebidasMouseClicked

    private void menuOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOpcionesMouseClicked
        // TODO add your handling code here:
        System.out.println("Botón Opciones");
        new OpcionesFrame().setVisible(true);
    }//GEN-LAST:event_menuOpcionesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        InputEventoDialog dialog = new InputEventoDialog(this, true);
        dialog.setVisible(true);

        evento = dialog.getModel();

        String nombre = evento.getNombre();
        labelNombreEvento.setText(nombre);
        dialog.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        int filas = tblPrediccion.getRowCount();
        //Revisar que no este vacia la tabla        

        if (filas == 0) {
            return;
        }
        
        //Limpiar tabla
        //modTblPrediccion.setRowCount(0);

        //1. Obtener informacion de bebida
        try {
            for (int i = 0; i < filas; i++) {
                //String query = "SELECT nombre, mililitros FROM historial_consumo WHERE id_bebida = ? AND registro_disponible = TRUE AND id_evento = ?";
                String query = "SELECT mililitros FROM historial_consumo WHERE id_bebida = ? AND registro_disponible = TRUE AND id_evento = ?";

                PreparedStatement execQuery = conn.prepareStatement(query);
                int idBebida = Integer.parseInt(modTblPrediccion.getValueAt(i, 0).toString());
                execQuery.setInt(1, idBebida);
                System.out.println(String.valueOf(this.evento.getId()));
                execQuery.setInt(2, this.evento.getId());

                ResultSet resultQuery = execQuery.executeQuery();
                
                //Obtener denominacion de bebida
                query = "SELECT denominacion FROM bebidas WHERE id_bebida = ?";
                execQuery = conn.prepareStatement(query);
                execQuery.setInt(1, idBebida);
                
                ResultSet resultDenominacion = execQuery.executeQuery();
                resultDenominacion.next();
                
                int denominacion = resultDenominacion.getInt("denominacion");
                String strDenominacion = itosDenominacion(denominacion);
                
                float repeticiones = 0;
                float ml = 0;
                
                while(resultQuery.next()){
                    repeticiones++;
                    ml += resultQuery.getFloat("mililitros");
                }
                
                float cantidad = mlPorDenominacion(ml, strDenominacion);
                cantidad = cantidad/repeticiones;
                
                float personas = Integer.parseInt(txtPersonas.getText());
                cantidad = cantidad*personas;
                
                modTblPrediccion.setValueAt(cantidad, i, 2);
                modTblPrediccion.setValueAt(strDenominacion, i, 3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*String query = "SELECT nombre, denominacion FROM historial_consumo WHERE ((id_bebida = ";

         for (int i = 0; i < filas; i++) {

         if (i == 0) {
         query = query + "?";
         } else {
         query = query + "OR id_bebida = ?";
         }
         }

         query = query + ") AND registro_disponible = ? AND id_evento = ? ORDER BY id_bebida;";

         try {
         PreparedStatement execQuery = conn.prepareStatement(query);

         ResultSet resultQuery = execQuery.executeQuery();

         DefaultTableModel tablaTotal = (DefaultTableModel) tblPrediccion.getModel();

         tablaTotal.setRowCount(0);

         while (resultQuery.next()) {
         //Obtener precio total
         int id = resultQuery.getInt("id_bebida");
         String nombre = resultQuery.getString("nombre");
         int denominacion = resultQuery.getInt("denominacion");
         String strdenominacion = itosDenominacion(denominacion);

         boolean disponible = resultQuery.getBoolean("registro_disponible");

         //Campos a rellenar
         Object resultado[] = {
         id,
         nombre,
         strdenominacion,
         disponible
         };

         //Poner información en la tabla 
         tablaTotal.addRow(resultado);
         }

         } catch (SQLException errorMod) {
         JOptionPane.showMessageDialog(null, "Error al hacer búsqueda. \n" + errorMod, "Error", JOptionPane.ERROR_MESSAGE);
         }*/

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void menuHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHistorialMouseClicked
        // TODO add your handling code here:
        new HistorialFrame().setVisible(true);
    }//GEN-LAST:event_menuHistorialMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        int row = tblBebidas.getSelectedRow();

        int id = Integer.parseInt(tblBebidas.getValueAt(row, 0).toString());
        String nombre = tblBebidas.getValueAt(row, 1).toString();

        Object registro[] = {
            id,
            nombre,
            null,
            null
        };

        modTblPrediccion.addRow(registro);
    }//GEN-LAST:event_btnAgregarActionPerformed

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
                    //if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Connection conn = ConexionBD.getInstance().getConnection();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse con la base de datos. \n\nFavor de contactarse con el técnico del programa.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Método para poder iniciar la ventana login

            //Todas las excepciones generadas fueron por parte del NetBeans
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
                System.out.println("Activado");
            }
        });
    }
    
    public float mlPorDenominacion(float ml, String denominacion){
        
        switch(denominacion){
            case "Mililitros":
                return ml;
            case "Medio litros":
                return (ml/500);
            case "Litros":
                return (ml/1000);
            case "Dos litros":
                return (ml/2000);
            case "Tres litros":
                return (ml/3000);
            default:
                return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNombreEvento;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuBebidas;
    private javax.swing.JMenu menuEventos;
    private javax.swing.JMenu menuHistorial;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JTable tblBebidas;
    private javax.swing.JTable tblPrediccion;
    private javax.swing.JTextField txtPersonas;
    // End of variables declaration//GEN-END:variables
}
