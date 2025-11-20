/**
 *
 * @author Sofi
 */
package vista;

import javax.swing.table.DefaultTableModel;
import modelo.Servicio;
import modelo.ServicioDAO;

/**
 * PanelServicio
 *
 * Vista del módulo de Servicios.
 * Permite realizar el CRUD completo:
 *   - Agregar nuevos servicios
 *   - Listar automáticamente todos los registros
 *   - Actualizar servicios existentes
 *   - Eliminar servicios seleccionados
 *
 * Esta clase pertenece a la capa Vista dentro del patrón MVC.
 * NO contiene lógica de negocio ni acceso directo a la base de datos.
 */

public class PanelServicio extends javax.swing.JPanel {

    /**
     * Constructor.
     * Carga los componentes gráficos, llena la tabla inicial
     * y deshabilita Actualizar/Eliminar hasta que el usuario seleccione una fila.
     */
    public PanelServicio() {
        initComponents();
        cargarTabla();
        
        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
    }

    /**
     * Código generado automáticamente por el Diseñador de NetBeans.
     * Construye la interfaz: labels, campos, botones, tabla, combos.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jlblTitulo = new javax.swing.JLabel();
        jlblNombreServicio = new javax.swing.JLabel();
        jlblPrecio = new javax.swing.JLabel();
        jlblDuracion = new javax.swing.JLabel();
        jlblTipo = new javax.swing.JLabel();
        jtxtNombreServicio = new javax.swing.JTextField();
        jtxtPrecio = new javax.swing.JTextField();
        jtxtDuracion = new javax.swing.JTextField();
        jcmbTipoServicio = new javax.swing.JComboBox<>();
        jbtnAgregar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jscrollTabla = new javax.swing.JScrollPane();
        jtblServicios = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jlblTitulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        jlblTitulo.setText("Gestión de Servicios");

        jlblNombreServicio.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblNombreServicio.setText("Nombre del Servicio:");

        jlblPrecio.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblPrecio.setText("Precio ($):");

        jlblDuracion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblDuracion.setText("Duración (minutos):");

        jlblTipo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblTipo.setText("Tipo de Servicio:");

        jtxtNombreServicio.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N

        jtxtPrecio.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N

        jtxtDuracion.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N

        jcmbTipoServicio.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jcmbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cabello", "Manos y Pies", "Rostro", "Masajes", "Depilación", "Terapias Alternativas" }));
        jcmbTipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbTipoServicioActionPerformed(evt);
            }
        });

        jbtnAgregar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnActualizar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnLimpiar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarActionPerformed(evt);
            }
        });

        jtblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Duración", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblServiciosMouseClicked(evt);
            }
        });
        jscrollTabla.setViewportView(jtblServicios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblPrecio)
                            .addComponent(jlblDuracion))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblNombreServicio)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(jtxtNombreServicio)
                                    .addComponent(jtxtDuracion)))
                            .addComponent(jscrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jlblTipo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jbtnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(jbtnLimpiar)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNombreServicio)
                    .addComponent(jtxtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPrecio)
                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDuracion)
                    .addComponent(jtxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTipo)
                    .addComponent(jcmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jbtnActualizar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnLimpiar))
                .addGap(27, 27, 27)
                .addComponent(jscrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        
        int fila = jtblServicios.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un servicio.");
            return;
        }

        int id = Integer.parseInt(jtblServicios.getValueAt(fila, 0).toString());

        String nombre = jtxtNombreServicio.getText().trim();
        String precioTxt = jtxtPrecio.getText().trim();
        String duracionTxt = jtxtDuracion.getText().trim();
        String tipo = (String) jcmbTipoServicio.getSelectedItem();

        if (nombre.isEmpty() || precioTxt.isEmpty() || duracionTxt.isEmpty() || tipo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        int precio, duracion;
        try {
            precio = Integer.parseInt(precioTxt);
            duracion = Integer.parseInt(duracionTxt);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Precio y duración deben ser números enteros.");
            return;
        }

        Servicio s = new Servicio(id, nombre, precio, duracion, tipo);
        ServicioDAO dao = new ServicioDAO();

        if (dao.actualizarServicio(s)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Servicio actualizado correctamente.");
            cargarTabla();
            limpiarCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
        }
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        String nombre = jtxtNombreServicio.getText().trim();
        String precioTxt = jtxtPrecio.getText().trim();
        String duracionTxt = jtxtDuracion.getText().trim();
        String tipo = (String) jcmbTipoServicio.getSelectedItem();

        if (nombre.isEmpty() || precioTxt.isEmpty() || duracionTxt.isEmpty() || tipo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        int precio, duracion;

        try {
            precio = Integer.parseInt(precioTxt);
            duracion = Integer.parseInt(duracionTxt);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Precio y duración deben ser números enteros.");
            return;
        }

        Servicio s = new Servicio(0, nombre, precio, duracion, tipo);
        ServicioDAO dao = new ServicioDAO();

        if (dao.agregarServicio(s)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Servicio agregado correctamente.");
            cargarTabla();
            limpiarCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo agregar. Verifique duplicados.");
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jcmbTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbTipoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbTipoServicioActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        
        int fila = jtblServicios.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un servicio.");
            return;
        }

        int id = Integer.parseInt(jtblServicios.getValueAt(fila, 0).toString());

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar servicio ID " + id + "?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            ServicioDAO dao = new ServicioDAO();

            if (dao.eliminarServicio(id)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Servicio eliminado.");
                cargarTabla();
                limpiarCampos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo eliminar.");
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jtblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblServiciosMouseClicked
        
        int fila = jtblServicios.getSelectedRow();

        jtxtNombreServicio.setText(jtblServicios.getValueAt(fila, 1).toString());
        jtxtPrecio.setText(jtblServicios.getValueAt(fila, 2).toString());
        jtxtDuracion.setText(jtblServicios.getValueAt(fila, 3).toString());
        jcmbTipoServicio.setSelectedItem(jtblServicios.getValueAt(fila, 4).toString());

        jbtnActualizar.setEnabled(true);
        jbtnEliminar.setEnabled(true);
    }//GEN-LAST:event_jtblServiciosMouseClicked

    private void jbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

    
    private void limpiarCampos() {
        jtxtNombreServicio.setText("");
        jtxtPrecio.setText("");
        jtxtDuracion.setText("");
        jcmbTipoServicio.setSelectedIndex(0);
        jtblServicios.clearSelection();

        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
    }
    
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jtblServicios.getModel();
        model.setRowCount(0);

        ServicioDAO dao = new ServicioDAO();
        for (Servicio s : dao.listarServicios()) {
            model.addRow(new Object[]{
                s.getIdServicio(),
                s.getNombre(),
                s.getPrecio(),
                s.getDuracion(),
                s.getTipo()
            });
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JComboBox<String> jcmbTipoServicio;
    private javax.swing.JLabel jlblDuracion;
    private javax.swing.JLabel jlblNombreServicio;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JLabel jlblTipo;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JScrollPane jscrollTabla;
    private javax.swing.JTable jtblServicios;
    private javax.swing.JTextField jtxtDuracion;
    private javax.swing.JTextField jtxtNombreServicio;
    private javax.swing.JTextField jtxtPrecio;
    // End of variables declaration//GEN-END:variables
}
