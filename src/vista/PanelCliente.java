/**
 *
 * @author Sofi
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 * PanelCliente
 * 
 * Vista encargada de la gestión de clientes dentro del sistema.
 * Incluye:
 *  - Formulario para ingresar datos
 *  - Tabla dinámica para visualizar registros
 *  - Botones de CRUD (Agregar, Actualizar, Eliminar, Limpiar)
 * 
 * Sigue el patrón MVC:
 *  - Este panel corresponde a la VISTA.
 *  - La lógica se delega al modelo (ClienteDAO).
 */


public class PanelCliente extends javax.swing.JPanel {

    /**
     * Constructor.
     * 
     * Inicializa la interfaz y carga los registros existentes en la tabla.
     * Además, desactiva los botones Actualizar/Eliminar hasta que se seleccione
     * una fila de la tabla.
     */
    public PanelCliente() {
        initComponents();
        cargarTabla();
        
        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
    }

    /**
     * Método generado por NetBeans.
     * 
     * Construye todos los componentes visuales:
     *  - Labels, TextFields, Botones
     *  - Tabla con scroll
     *  - Estilos, fuentes y posiciones
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jlblNombre = new JLabel();
        jlblTelefono = new JLabel();
        jlblCorreo = new JLabel();
        jlblTitulo = new JLabel();
        jtxtNombre = new JTextField();
        jtxtTelefono = new JTextField();
        jtxtCorreo = new JTextField();
        jbtnAgregar = new JButton();
        jbtnActualizar = new JButton();
        jbtnEliminar = new JButton();
        jbtnLimpiar = new JButton();
        jscrollTabla = new JScrollPane();
        jtblClientes = new JTable();

        setBackground(new Color(255, 255, 255));

        jlblNombre.setFont(new Font("Calibri Light", 0, 18)); // NOI18N
        jlblNombre.setText("Nombre:");

        jlblTelefono.setFont(new Font("Calibri Light", 0, 18)); // NOI18N
        jlblTelefono.setText("Teléfono:");

        jlblCorreo.setFont(new Font("Calibri Light", 0, 18)); // NOI18N
        jlblCorreo.setText("Correo:");

        jlblTitulo.setFont(new Font("Calibri Light", 1, 36)); // NOI18N
        jlblTitulo.setText("Gestión de Clientes");

        jtxtNombre.setFont(new Font("Calibri Light", 2, 18)); // NOI18N

        jtxtTelefono.setFont(new Font("Calibri Light", 2, 18)); // NOI18N

        jtxtCorreo.setFont(new Font("Calibri Light", 2, 18)); // NOI18N

        jbtnAgregar.setFont(new Font("Calibri Light", 1, 14)); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnActualizar.setFont(new Font("Calibri Light", 1, 14)); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new Font("Calibri Light", 1, 14)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnLimpiar.setFont(new Font("Calibri Light", 1, 14)); // NOI18N
        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLimpiarActionPerformed(evt);
            }
        });

        jtblClientes.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jtblClientesMouseClicked(evt);
            }
        });
        jscrollTabla.setViewportView(jtblClientes);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblNombre)
                                    .addComponent(jlblTelefono)
                                    .addComponent(jlblCorreo))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtNombre, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jtxtTelefono)
                                    .addComponent(jtxtCorreo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jbtnAgregar)
                        .addGap(31, 31, 31)
                        .addComponent(jbtnActualizar)
                        .addGap(31, 31, 31)
                        .addComponent(jbtnEliminar)
                        .addGap(36, 36, 36)
                        .addComponent(jbtnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jscrollTabla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jlblTitulo, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNombre)
                    .addComponent(jtxtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTelefono)
                    .addComponent(jtxtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCorreo)
                    .addComponent(jtxtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jbtnActualizar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnLimpiar))
                .addGap(27, 27, 27)
                .addComponent(jscrollTabla, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        String nombre = jtxtNombre.getText().trim();
        String telefono = jtxtTelefono.getText().trim();
        String correo = jtxtCorreo.getText().trim();

        if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente(0, nombre, telefono, correo);

        if (dao.agregarCliente(c)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
            cargarTabla();
            limpiarCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo agregar. Verifique duplicados o formato de correo.");
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnActualizarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        int fila = jtblClientes.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente de la tabla.");
            return;
        }

        int id = Integer.parseInt(jtblClientes.getValueAt(fila, 0).toString());
        String nombre = jtxtNombre.getText().trim();
        String telefono = jtxtTelefono.getText().trim();
        String correo = jtxtCorreo.getText().trim();

        Cliente c = new Cliente(id, nombre, telefono, correo);

        ClienteDAO dao = new ClienteDAO();

        if (dao.actualizarCliente(c)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
            cargarTabla();
            limpiarCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar. Revise los datos.");
        }
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnEliminarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        int fila = jtblClientes.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
            return;
        }

        int id = Integer.parseInt(jtblClientes.getValueAt(fila, 0).toString());

        int opcion = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Eliminar cliente ID " + id + "?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            ClienteDAO dao = new ClienteDAO();

            if (dao.eliminarCliente(id)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente eliminado.");
                cargarTabla();
                limpiarCampos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo eliminar.");
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    
    private void jbtnLimpiarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

    private void jtblClientesMouseClicked(MouseEvent evt) {//GEN-FIRST:event_jtblClientesMouseClicked
        int fila = jtblClientes.getSelectedRow();
        jtxtNombre.setText(jtblClientes.getValueAt(fila, 1).toString());
        jtxtTelefono.setText(jtblClientes.getValueAt(fila, 2).toString());
        jtxtCorreo.setText(jtblClientes.getValueAt(fila, 3).toString());
        
        jbtnActualizar.setEnabled(true);
        jbtnEliminar.setEnabled(true);

    }//GEN-LAST:event_jtblClientesMouseClicked

    public void limpiarCampos() {
        jtxtNombre.setText("");
        jtxtTelefono.setText("");
        jtxtCorreo.setText("");
        jtblClientes.clearSelection();
        
        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);

    }
    
    public void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jtblClientes.getModel();
        model.setRowCount(0);

        ClienteDAO dao = new ClienteDAO();
        for (Cliente c : dao.listarClientes()) {
            model.addRow(new Object[]{
                c.getIdCliente(),
                c.getNombre(),
                c.getTelefono(),
                c.getCorreo()
            });
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jbtnActualizar;
    public JButton jbtnAgregar;
    public JButton jbtnEliminar;
    public JButton jbtnLimpiar;
    public JLabel jlblCorreo;
    public JLabel jlblNombre;
    public JLabel jlblTelefono;
    public JLabel jlblTitulo;
    public JScrollPane jscrollTabla;
    public JTable jtblClientes;
    public JTextField jtxtCorreo;
    public JTextField jtxtNombre;
    public JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables
}
