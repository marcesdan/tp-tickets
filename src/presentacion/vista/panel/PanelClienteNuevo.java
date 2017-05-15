/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista.panel;

import presentacion.vista.info.InfoCliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorClienteNuevo;
import presentacion.vista.Main;
import presentacion.vista.VistaHija;
import static presentacion.vista.info.InfoCliente.crearInfoCliente;

/**
 *
 * @author marces
 */
public class PanelClienteNuevo
        extends javax.swing.JPanel
        implements VistaHija {

    private ControladorClienteNuevo controlador;
    private Long id = null;

    /**
     * Creamos una nueva instancia de PanelNuevoCliente
     * Ésta vista se utiliza tanto para el alta de un cliente,
     * como también para su modificación.
     */   
    public PanelClienteNuevo() {
        initComponents();
        localInit();
    }
    
    /**
     * Nuestro propio método de inicialización local.
     */ 
    private void localInit() {
        
        // Le pasamos los textFields que no deben estar vacíos.
        ValidadorDeCampos validador = new ValidadorDeCampos(
                txtApellido,txtNombre,txtDocumento,txtTelefono, 
                txtCalle, txtDepto
        );
        
        /* Le pasamos el botón que estará habilitado solo si dichos 
        campos no estan vacíos */
        validador.setBoton(btnGuardar);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        datosLibro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtDepto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        txtBarrio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

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

        datosLibro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel5.setText("Nombre *");

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel1.setText("Documento *");

        txtDocumento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel6.setText("Apellido *");

        txtApellido.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel3.setText("Teléfono *");

        jLabel2.setText("Calle *");

        jLabel4.setText("Depto. *");

        txtCalle.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        txtDepto.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel7.setText("Código postal");

        txtCodigoPostal.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        txtBarrio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel8.setText("Barrio");

        javax.swing.GroupLayout datosLibroLayout = new javax.swing.GroupLayout(datosLibro);
        datosLibro.setLayout(datosLibroLayout);
        datosLibroLayout.setHorizontalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(txtCalle)
                        .addComponent(txtDocumento)
                        .addComponent(txtBarrio))
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addComponent(txtDepto)
                                .addComponent(txtTelefono)
                                .addComponent(txtCodigoPostal))
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        datosLibroLayout.setVerticalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtApellido.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    // <editor-fold defaultstate="collapsed" desc="Nuestro código">   
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorClienteNuevo) controlador;
    }

    @Override
    public void setDatos(Object campos) {
        
        // Doloroso pero necesario cast
        InfoCliente info = (InfoCliente) campos;
        
        // Necesitamos el id para luego actualizar el cliente adecuado.
        this.id = info.getId();
        
        // Seteamos los campos. Los nulos quedarán vacíos.
        txtApellido.setText(info.getApellido());
        txtNombre.setText(info.getNombre());
        txtDocumento.setText(info.getDocumento());
        txtTelefono.setText(info.getTelefono());
        txtCalle.setText(info.getCalle());
        txtDepto.setText(info.getDepto());
        txtBarrio.setText(info.getBarrio());
        txtCodigoPostal.setText(info.getCodigo());
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
 
        controlador.guardarCliente(crearInfoCliente()
                .withId(id)
                .withApellido(txtApellido.getText())
                .withNombre(txtNombre.getText())
                .withDocumento(txtDocumento.getText())
                .withTelefono(txtTelefono.getText())
                .withCalle(txtCalle.getText())
                .withDepto(txtDepto.getText())
                .withBarrio(txtBarrio.getText())
                .withCodigo(txtCodigoPostal.getText()));
    }//GEN-LAST:event_btnGuardarActionPerformed
    //</editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Variables generadas por el editor">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel datosLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBarrio;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>  
}
