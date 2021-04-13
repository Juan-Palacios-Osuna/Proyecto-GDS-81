/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabla;

import testtabla.BebidasDialogs.AgregarBebidaDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import testtabla.EventosDialogs.ModificarEventoDialog;
import testtabla.Models.EventoModel;

/**
 *
 * @author Ghost
 */
public class EventosFrame extends javax.swing.JFrame {
    
    Connection conn = ConexionBD.getInstance().getConnection();
    
    /**
     * Creates new form EventosFrame
     */
    public EventosFrame() {
        initComponents();
        cargarEventos();
    }
    
    public void cargarEventos(){
        
        try {
            String query = "SELECT * FROM eventos";

			PreparedStatement execQuery = conn.prepareStatement(query);
			
			ResultSet resultQuery = execQuery.executeQuery();

			DefaultTableModel tablaTotal = (DefaultTableModel) tblEventos.getModel();

			//Hacer que la tabla se de cuenta de la ultima posición
            //tablaTotal.setRowCount(tablaTotal.getRowCount());
                        tablaTotal.setRowCount(0);

			while(resultQuery.next()){
				//Obtener precio total
				int id = resultQuery.getInt("id_evento");
                                String nombre = resultQuery.getString("nombre");
                                
                                boolean disponible = resultQuery.getBoolean("registro_disponible");
                                

				//Campos a rellenar
				Object resultado[] = {
					id,
                                        nombre,
                                        disponible
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

        jLabel2 = new javax.swing.JLabel();
        cboxFiltro = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eventos");

        jLabel2.setText("Filtro:");

        cboxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Disponible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEventos);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnActualizar)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnActualizar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        AgregarBebidaDialog dialog = new AgregarBebidaDialog(this, true);
        dialog.setVisible(true);
        dialog.dispose();
        cargarEventos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cargarEventos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int row = tblEventos.getSelectedRow();
        int col = 1;
        
        String nombre = tblEventos.getValueAt(row, col).toString();
        
        JOptionPane dialog = new JOptionPane(
            "¿Desea elminar el evento " + nombre + "?",
            JOptionPane.QUESTION_MESSAGE,
            JOptionPane.YES_NO_OPTION);
        
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea elminar el evento " + nombre + "?", "Aviso", JOptionPane.YES_NO_OPTION);
        
        //opcion.setVisible(true);
        
        //String valueStr = opcion.getValue().toString();
        //int value = Integer.parseInt(valueStr);
        
        if(opcion == JOptionPane.YES_OPTION){
            Object id_object = tblEventos.getValueAt(row, 0);
            int id = Integer.parseInt(id_object.toString());
            
            eliminarEvento(id);
            cargarEventos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
        int row = tblEventos.getSelectedRow();
        
        int id = Integer.parseInt(tblEventos.getValueAt(row, 0).toString());
        String nombre = tblEventos.getValueAt(row, 1).toString();
        Boolean disponible = Boolean.parseBoolean(tblEventos.getValueAt(row, 2).toString());
        
        EventoModel evento = new EventoModel(id, nombre, disponible);
        
        ModificarEventoDialog dialog = new ModificarEventoDialog(this, true, evento);
        
        dialog.setVisible(true);
        
        if(dialog.getCambio()){
            cargarEventos();
        }
        
        dialog.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarEvento(int id){
		
		//Modificar el producto
		try {
			String query = "DELETE FROM eventos WHERE id_evento = ?";

			PreparedStatement execQuery = conn.prepareStatement(query);
			execQuery.setInt(1, id);

			execQuery.executeUpdate();

			//Mostrar mensaje
			JOptionPane.showMessageDialog(null, "Evento eliminado.");
		} catch (SQLException errorMod) {
			JOptionPane.showMessageDialog(null, "Error al eliminar. \n" + errorMod, "Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEventos;
    // End of variables declaration//GEN-END:variables
}
