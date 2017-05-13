/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorTicketNuevo;
import presentacion.modelo.FuncionComboBoxModel;

/**
 *
 * @author marces
 */
public class PanelTicketNuevo
        extends javax.swing.JPanel
        implements VistaHija {

    private ControladorTicketNuevo controlador;
    private Long id = null;
    private InfoTicket info;

    /**
     * Creamos una nueva instancia de PanelNuevoTicket
     * Ésta vista se utiliza tanto para el alta de un ticket,
     * como también para su modificación.
     */   
    public PanelTicketNuevo() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        datosLibro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxFuncion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTeatro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        datosLibro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del ticket", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel5.setText("Precio");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel6.setText("Documento");

        txtDocumento.setEditable(false);
        txtDocumento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel3.setText("Funcion *");

        comboBoxFuncion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        comboBoxFuncion.setModel(new FuncionComboBoxModel());
        comboBoxFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFuncionActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        txtTeatro.setEditable(false);
        txtTeatro.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel7.setText("Teatro");

        javax.swing.GroupLayout datosLibroLayout = new javax.swing.GroupLayout(datosLibro);
        datosLibro.setLayout(datosLibroLayout);
        datosLibroLayout.setHorizontalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBoxFuncion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );
        datosLibroLayout.setVerticalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txtDocumento.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 274, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(datosLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    // <editor-fold defaultstate="collapsed" desc="Nuestro código">   
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorTicketNuevo) controlador;
    }

    @Override
    public void setDatos(Object campos) {
        
        // Doloroso pero necesario cast
        InfoTicket auxInfo = (InfoTicket) campos;
        
        // Necesitamos el id para luego actualizar el ticket adecuado.
        this.id = auxInfo.getId();
        
        // Seteamos los campos. Los nulos quedarán vacíos.
        txtDocumento.setText(auxInfo.getDocumento());
        txtNombre.setText(auxInfo.getNombre());
        txtPrecio.setText(auxInfo.getPrecio());
        txtTeatro.setText(auxInfo.getTeatro());
        comboBoxFuncion.getModel().setSelectedItem(auxInfo.getFuncion());
        
        // Lo guardamos porque solo se modificaría la funcion.
        this.info = auxInfo;
    }
    
    @Override
    public void mostrarMensaje(String st) {
        JOptionPane.showMessageDialog(new JFrame(), st);
    }
     //</editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Manejamos eventos">  
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Main.getInstance().cerrarDialogAux();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        controlador.guardarTicket(
                info.withFuncion(comboBoxFuncion.getModel().getSelectedItem()));
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboBoxFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFuncionActionPerformed
        // Hasta que no elijamos una funcion, el boton estará deshabilitado.
        btnGuardar.setEnabled(true);
        
        // Le pedimos al controlador que nos traiga la info actualizada de la funcion.
        controlador.cambiaFuncion(info, comboBoxFuncion.getModel().getSelectedItem());
        
        // Actualizamos los campos que dependen del comboBoxFuncion
        txtPrecio.setText(info.getPrecio());
        txtTeatro.setText(info.getTeatro());
    }//GEN-LAST:event_comboBoxFuncionActionPerformed
    //</editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Variables generadas por el editor">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboBoxFuncion;
    private javax.swing.JPanel datosLibro;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTeatro;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>  
}
