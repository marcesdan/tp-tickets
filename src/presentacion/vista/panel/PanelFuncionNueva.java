/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista.panel;
import presentacion.vista.info.InfoFuncion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorFuncionNuevo;
import presentacion.modelo.TeatroComboBoxModel;
import presentacion.vista.Main;
import presentacion.vista.VistaHija;
import static presentacion.vista.info.InfoFuncion.crearInfoFuncion;

/**
 *
 * @author marces
 */
public class PanelFuncionNueva
        extends javax.swing.JPanel
        implements VistaHija {

    private ControladorFuncionNuevo controlador;
    private Long id = null;

    /**
     * Creamos una nueva instancia de PanelNuevoFuncion
     * Ésta vista se utiliza tanto para el alta de un funcion,
     * como también para su modificación.
     */   
    public PanelFuncionNueva() {
        initComponents();
        localInit();
    }
    
    /**
     * Nuestro propio método de inicialización local.
     */ 
    private void localInit() {
        
        // Le pasamos los textFields que no deben estar vacíos.
        ValidadorDeCampos validador = new ValidadorDeCampos(
                txtNombre,txtPrecio, 
                dateTimePicker.getDatePicker().getComponentDateTextField(),
                dateTimePicker.getTimePicker().getComponentTimeTextField()
        );
        
        /* Le pasamos el botón que estará habilitado solo si dichos 
        campos no estan vacíos */
        validador.setBoton(btnGuardar);
        
        dateTimePicker.setDateTimePermissive(LocalDateTime.now());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxTeatro = new javax.swing.JComboBox<>();
        dateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        datosLibro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la función", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel5.setText("Precio *");

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel1.setText("Fecha *");

        jLabel6.setText("Nombre *");

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel3.setText("Teatro *");

        comboBoxTeatro.setModel(new TeatroComboBoxModel());
        comboBoxTeatro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        comboBoxTeatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTeatroActionPerformed(evt);
            }
        });

        jLabel2.setText("dd/mm/aaaa");

        jLabel4.setText("hh:mm");

        javax.swing.GroupLayout datosLibroLayout = new javax.swing.GroupLayout(datosLibro);
        datosLibro.setLayout(datosLibroLayout);
        datosLibroLayout.setHorizontalGroup(
            datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, datosLibroLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addComponent(dateTimePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datosLibroLayout.createSequentialGroup()
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboBoxTeatro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosLibroLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(datosLibroLayout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))))))
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
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(datosLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

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
        this.controlador = (ControladorFuncionNuevo) controlador;
    }

    @Override
    public void setDatos(Object campos) {
        
        // Doloroso pero necesario cast
        InfoFuncion info = (InfoFuncion) campos;
        
        // Necesitamos el id para luego actualizar el funcion adecuado.
        this.id = info.getId();
        
        // Seteamos los campos. Los nulos quedarán vacíos.
        txtNombre.setText(info.getNombre());
        txtPrecio.setText(info.getPrecio());
        comboBoxTeatro.getModel().setSelectedItem(info.getTeatro());
        
        // Formateamos la fecha (sino queda feita).
        DateTimeFormatter formatter 
                = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm");
        
        info.getFechaHora().format(formatter);    
        dateTimePicker.setDateTimePermissive(info.getFechaHora());
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
      
        controlador.guardarFuncion(crearInfoFuncion()
                .withId(id)
                .withNombre(txtNombre.getText())
                .withPrecio(txtPrecio.getText())
                .withFechaHora(LocalDateTime.of(
                        dateTimePicker.getDatePicker().getDate(),
                        dateTimePicker.getTimePicker().getTime()))
                .withTeatro(comboBoxTeatro.getModel().getSelectedItem()));  
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboBoxTeatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTeatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTeatroActionPerformed
    //</editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Variables generadas por el editor">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboBoxTeatro;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker;
    private javax.swing.JPanel datosLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>  
}
