/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorTicket;
import presentacion.modelo.FuncionComboBoxModel;

/**
 *
 * @author marces
 */
public class PanelFuncionComboBox
        extends javax.swing.JPanel
        implements Vista {

    private ControladorTicket controlador;

    /**
     * Creamos una nueva instancia de PanelNuevoTicket
     * Ésta vista se utiliza tanto para el alta de un ticket,
     * como también para su modificación.
     */   
    public PanelFuncionComboBox() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        datosLibro = new javax.swing.JPanel();
        comboBoxFuncion = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        btnGuardar.setText("Aceptar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        datosLibro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elija la función", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        comboBoxFuncion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        comboBoxFuncion.setModel(new FuncionComboBoxModel());
        comboBoxFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFuncionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datosLibroLayout = new javax.swing.GroupLayout(datosLibro);
        datosLibro.setLayout(datosLibroLayout);
        datosLibroLayout.setHorizontalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosLibroLayout.setVerticalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datosLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(datosLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    // <editor-fold defaultstate="collapsed" desc="Nuestro código">   
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorTicket) controlador;
    }
    
    @Override
    public void mostrarMensaje(String st) {
        JOptionPane.showMessageDialog(new JFrame(), st);
    }
     //</editor-fold>  

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        controlador.funcionElegida(comboBoxFuncion.getModel().getSelectedItem());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboBoxFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFuncionActionPerformed
        // Hasta que no elijamos una funcion, el boton estará deshabilitado.
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_comboBoxFuncionActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables generadas por el editor">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboBoxFuncion;
    private javax.swing.JPanel datosLibro;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>  
}
