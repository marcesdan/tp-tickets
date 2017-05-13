/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista;

import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author marces
 */
public class ValidadorDeCampos implements DocumentListener {
    
    // Mantiene los campos de texto a validar.
    private List<JTextField> monitorDeCampos;
    
    // Mantiene el botón que queremos habilitar/deshabilitar.
    private JButton boton;

    /**
     * @param campos JTextFields recibidos como un array mediante "Varargs"
     * Crea un nuevo validador de campos
     */
    public ValidadorDeCampos(JTextField... campos) {
        monitorDeCampos = Arrays.asList(campos);
        monitorDeCampos.forEach((campo) -> {   
            // Les dice a los campos que van a ser "escuchados" por él.
            campo.getDocument().addDocumentListener(this);
        });
    }
    
    /**
     * @param boton boton que queremos habilitar/deshabilitar
     */
    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        change();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        change();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        change();
    }

    private void change(){

        boolean enabled = true;
        for (JTextField campo : monitorDeCampos) {  
            // Quita los espacios y pregunta si esta vacío.
            if (campo.getText().trim().isEmpty()) {
                enabled = false;
                break;
            }
        }
        
        boton.setEnabled(enabled);
    }
}

