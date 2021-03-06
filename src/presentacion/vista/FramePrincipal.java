package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorPrincipal;

/**
 *
 * @author marces
 */
public class FramePrincipal 
        extends javax.swing.JFrame
        implements Vista{
    
    private ControladorPrincipal controlador;
    
    public FramePrincipal() {
        initComponents();
        localInit();
    }
    
    private void localInit() { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorPrincipal) controlador;
    }

    @Override
    public void mostrarMensaje(String st) {
        JOptionPane.showMessageDialog(new JFrame(), st);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        menuBar = new javax.swing.JMenuBar();
        menuAplicacion = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        itemVerClientes = new javax.swing.JMenuItem();
        menuFuncion = new javax.swing.JMenu();
        itemVerFunciones = new javax.swing.JMenuItem();
        menuTicket = new javax.swing.JMenu();
        itemVerTickets = new javax.swing.JMenuItem();
        menuTeatro = new javax.swing.JMenu();
        itemVerTeatros = new javax.swing.JMenuItem();
        itemContenido = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        itemAcercaDe = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de tickets");
        setResizable(false);

        menuAplicacion.setMnemonic('f');
        menuAplicacion.setText("Aplicacion");

        itemSalir.setMnemonic('x');
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuAplicacion.add(itemSalir);

        menuBar.add(menuAplicacion);

        menuCliente.setMnemonic('c');
        menuCliente.setText("Clientes");

        itemVerClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemVerClientes.setText("Ver todos");
        itemVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerClientesActionPerformed(evt);
            }
        });
        menuCliente.add(itemVerClientes);

        menuBar.add(menuCliente);

        menuFuncion.setMnemonic('f');
        menuFuncion.setText("Funciones");

        itemVerFunciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        itemVerFunciones.setMnemonic('t');
        itemVerFunciones.setText("Ver todas");
        itemVerFunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerFuncionesActionPerformed(evt);
            }
        });
        menuFuncion.add(itemVerFunciones);

        menuBar.add(menuFuncion);

        menuTicket.setMnemonic('t');
        menuTicket.setText("Tickets");

        itemVerTickets.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        itemVerTickets.setText("Ver todos");
        itemVerTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerTicketsActionPerformed(evt);
            }
        });
        menuTicket.add(itemVerTickets);

        menuBar.add(menuTicket);

        menuTeatro.setText("Teatros");

        itemVerTeatros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        itemVerTeatros.setText("Ver todos");
        itemVerTeatros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerTeatrosActionPerformed(evt);
            }
        });
        menuTeatro.add(itemVerTeatros);

        menuBar.add(menuTeatro);

        itemContenido.setMnemonic('h');
        itemContenido.setText("Ayuda");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contenido");
        itemContenido.add(contentsMenuItem);

        itemAcercaDe.setMnemonic('a');
        itemAcercaDe.setText("Acerca de");
        itemContenido.add(itemAcercaDe);

        menuBar.add(itemContenido);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // <editor-fold defaultstate="collapsed" desc="Manejamos eventos del menú">      
    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerClientesActionPerformed
       controlador.mostrarClientes();
    }//GEN-LAST:event_itemVerClientesActionPerformed

    private void itemVerFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerFuncionesActionPerformed
        controlador.mostrarFunciones();
    }//GEN-LAST:event_itemVerFuncionesActionPerformed

    private void itemVerTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerTicketsActionPerformed
        controlador.mostrarTickets();
    }//GEN-LAST:event_itemVerTicketsActionPerformed

    private void itemVerTeatrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerTeatrosActionPerformed
        controlador.mostrarTeatros();
    }//GEN-LAST:event_itemVerTeatrosActionPerformed
    //</editor-fold>
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenu itemContenido;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemVerClientes;
    private javax.swing.JMenuItem itemVerFunciones;
    private javax.swing.JMenuItem itemVerTeatros;
    private javax.swing.JMenuItem itemVerTickets;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuAplicacion;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuFuncion;
    private javax.swing.JMenu menuTeatro;
    private javax.swing.JMenu menuTicket;
    // End of variables declaration//GEN-END:variables
}
