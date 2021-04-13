/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import testtabla.Models.EventoModel;

/**
 *
 * @author Ghost
 */
public class HistorialFrame extends javax.swing.JFrame {
    
    Connection conn = ConexionBD.getInstance().getConnection();
    EventoModel evento = new EventoModel();
    
    DefaultTableModel modTblBebidas;
    DefaultTableModel modTblConsumo;

    /**
     * Creates new form HistorialFrame
     */
    public HistorialFrame() {
        initComponents();
        cargarBebidas();
        this.modTblBebidas = (DefaultTableModel) tblBebidas.getModel();
        this.modTblConsumo = (DefaultTableModel) tblConsumo.getModel();
    }
    
    public void cargarBebidas(){
        
        try {
            String query = "SELECT * FROM bebidas";

			PreparedStatement execQuery = conn.prepareStatement(query);
			
			ResultSet resultQuery = execQuery.executeQuery();

			DefaultTableModel tablaTotal = (DefaultTableModel) tblBebidas.getModel();

			//Hacer que la tabla se de cuenta de la ultima posición
            //tablaTotal.setRowCount(tablaTotal.getRowCount());
                        tablaTotal.setRowCount(0);

			while(resultQuery.next()){
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        btnEvento = new javax.swing.JButton();
        lblEvento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        cboxDenominacion = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBebidas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsumo = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEvento.setText("Elegir evento");
        btnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventoActionPerformed(evt);
            }
        });

        lblEvento.setText("[Evento]");

        jLabel1.setText("Personas:");

        cboxDenominacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mililitros", "Medio litros", "Litros", "Dos litros", "Tres litros" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tblBebidas);

        tblConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblConsumo);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEvento)
                    .addComponent(lblEvento)
                    .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventoActionPerformed
        // TODO add your handling code here:
        InputEventoDialog dialog = new InputEventoDialog(this, true);
        dialog.setVisible(true);
        
        evento = dialog.getModel();
        
        String nombre = evento.getNombre();
        lblEvento.setText(nombre);
        System.out.println("ID: ");
        System.out.println(String.valueOf(evento.getId()));
        dialog.dispose();
    }//GEN-LAST:event_btnEventoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        int row = tblBebidas.getSelectedRow();
        
        //Obtener las variables que pasaremos
        int id = Integer.parseInt(tblBebidas.getValueAt(row, 0).toString());
        System.out.println(String.valueOf(id));
        String nombre = tblBebidas.getValueAt(row, 1).toString();
        System.out.println(nombre);
        float cantidad = Float.parseFloat(txtCantidad.getText());
        System.out.println(String.valueOf(cantidad));
        String denominacion = cboxDenominacion.getSelectedItem().toString();
        System.out.println(denominacion);
        
        Object rowData[] = {
            id,
            nombre,
            cantidad,
            denominacion
        };
        
        modTblConsumo.addRow(rowData);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        int row = tblConsumo.getSelectedRow();
        
        modTblConsumo.removeRow(row);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        try{
            int filas = modTblConsumo.getRowCount();
            int personas = Integer.parseInt(txtPersonas.getText());

            for(int i = 0; i < filas; i++){

                int idBebida = Integer.parseInt(modTblConsumo.getValueAt(i, 0).toString());
                //System.out.println(String.valueOf(idBebida));

                int idEvento = this.evento.getId();
                float cantidad = Float.parseFloat(modTblConsumo.getValueAt(i, 2).toString());
                String denominacion = modTblConsumo.getValueAt(i, 3).toString();

                float consumo = mlPorPersona(cantidad, personas, denominacion);

                //Modificar el producto
                
                String query = "INSERT INTO `predictor`.`historial_consumo` (id_evento, id_bebida, mililitros) VALUES (?, ?, ?)";

                PreparedStatement execQuery = conn.prepareStatement(query);
                execQuery.setInt(1, idEvento);
                execQuery.setInt(2, idBebida);
                execQuery.setFloat(3, consumo);

                execQuery.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(null, "Consumo registrado.");
        } catch (SQLException errorMod) {
                JOptionPane.showMessageDialog(null, "Error al agregar. \n" + errorMod, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(HistorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialFrame().setVisible(true);
            }
        });
    }
    
    public float mlPorPersona(float cantidad, int personas, String denominacion){
        float ml = cantidad/personas;
        
        switch(denominacion){
            case "Mililitros":
                return ml;
            case "Medio litros":
                return (500*ml);
            case "Litros":
                return (1000*ml);
            case "Dos litros":
                return (2000*ml);
            case "Tres litros":
                return (3000*ml);
            default:
                return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEvento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cboxDenominacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEvento;
    private javax.swing.JTable tblBebidas;
    private javax.swing.JTable tblConsumo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPersonas;
    // End of variables declaration//GEN-END:variables
}
