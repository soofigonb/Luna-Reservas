/**
 *
 * @author Sofi
 */
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;
import modelo.ReservaDAO;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Servicio;
import modelo.ServicioDAO;

/**
 * PanelReserva
 * 
 * Vista encargada de gestionar las reservas del sistema.
 * Permite:
 *   - Registrar nuevas reservas
 *   - Cargar clientes y servicios desde la BD
 *   - Validar fecha, hora y disponibilidad
 *   - Actualizar o eliminar solo cuando se seleccione una fila
 *   - Mostrar todos los registros en una tabla dinámica
 * 
 * Forma parte del patrón MVC: esta clase es únicamente la vista.
 */

public class PanelReserva extends javax.swing.JPanel {

    /**
     * Constructor.
     * Inicializa los componentes, carga los combos con datos reales,
     * muestra la tabla y configura placeholders.
     * 
     * También deshabilita Actualizar/Eliminar hasta seleccionar una reserva.
     */
    public PanelReserva() {
        initComponents();
        configurarPlaceholderFecha();
        cargarCombos();
        cargarTabla();
        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
    }

    /**
     * Código generado por NetBeans.
     * Construye todos los elementos gráficos:
     * labels, combos, campos, botones y tabla.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jscrollReservas = new javax.swing.JScrollPane();
        jtblReservas = new javax.swing.JTable();
        jlblTitulo = new javax.swing.JLabel();
        jlblCliente = new javax.swing.JLabel();
        jlblServicio = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jcmbServicio = new javax.swing.JComboBox<>();
        jtxtFecha = new javax.swing.JTextField();
        jcmbHora = new javax.swing.JComboBox<>();
        jcmbEstado = new javax.swing.JComboBox<>();
        jcmbCliente = new javax.swing.JComboBox<>();
        jbtnAgregar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jtblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Servicio", "Fecha", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblReservasMouseClicked(evt);
            }
        });
        jscrollReservas.setViewportView(jtblReservas);

        jlblTitulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        jlblTitulo.setText("Gestión de Reservas");

        jlblCliente.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblCliente.setText("Cliente:");

        jlblServicio.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblServicio.setText("Servicio:");

        jlblFecha.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblFecha.setText("Fecha:");

        jlblHora.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblHora.setText("Hora:");

        jlblEstado.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jlblEstado.setText("Estado:");

        jcmbServicio.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jcmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cabello", "Manos y Pies", "Rostro", "Masajes", "Depilación", "Terapias Alternativas" }));

        jtxtFecha.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jtxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFechaActionPerformed(evt);
            }
        });

        jcmbHora.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jcmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "13:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00" }));

        jcmbEstado.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jcmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Confirmada", "Cancelada" }));

        jcmbCliente.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N

        jbtnAgregar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnActualizar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnLimpiar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblCliente)
                                    .addComponent(jlblServicio)
                                    .addComponent(jlblFecha)
                                    .addComponent(jlblHora)
                                    .addComponent(jlblEstado))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jbtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)))
                .addComponent(jscrollReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblCliente)
                            .addComponent(jcmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblServicio)
                            .addComponent(jcmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblFecha)
                            .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblHora)
                            .addComponent(jcmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblEstado)
                            .addComponent(jcmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnAgregar)
                            .addComponent(jbtnActualizar))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnEliminar)
                            .addComponent(jbtnLimpiar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jscrollReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents
    
    private void configurarPlaceholderFecha() {
        jtxtFecha.setText("yyyy-mm-dd");
        jtxtFecha.setForeground(java.awt.Color.GRAY);

        jtxtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jtxtFecha.getText().equals("yyyy-mm-dd")) {
                    jtxtFecha.setText("");
                    jtxtFecha.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jtxtFecha.getText().trim().isEmpty()) {
                    jtxtFecha.setText("yyyy-mm-dd");
                    jtxtFecha.setForeground(java.awt.Color.GRAY);
                }
            }
        });
    }

    
    private void cargarCombos() {
        ClienteDAO cdao = new ClienteDAO();
        ServicioDAO sdao = new ServicioDAO();

        jcmbCliente.removeAllItems();
        for (Cliente c : cdao.listarClientes()) {
            jcmbCliente.addItem(c.getIdCliente() + " - " + c.getNombre());
        }

        jcmbServicio.removeAllItems();
        for (Servicio s : sdao.listarServicios()) {
            jcmbServicio.addItem(s.getIdServicio() + " - " + s.getNombre());
        }
    }
    
private void cargarTabla() {
    DefaultTableModel model = (DefaultTableModel) jtblReservas.getModel();
    model.setRowCount(0);

    ReservaDAO dao = new ReservaDAO();
    ClienteDAO cdao = new ClienteDAO();
    ServicioDAO sdao = new ServicioDAO();

    for (Reserva r : dao.listarReservas()) {

        Cliente cli = cdao.buscarClientePorId(r.getIdCliente());
        Servicio ser = sdao.buscarServicioPorId(r.getIdServicio());

        String nombreCliente = (cli != null) ? cli.getNombre() : "Desconocido";
        String nombreServicio = (ser != null) ? ser.getNombre() : "Desconocido";

        model.addRow(new Object[]{
            r.getIdReserva(),
            nombreCliente,
            nombreServicio,
            r.getFecha(),
            r.getHora(),
            r.getEstado()
        });
    }
}

    
    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        
        int fila = jtblReservas.getSelectedRow();
        if (fila == -1) return;

        int id = Integer.parseInt(jtblReservas.getValueAt(fila, 0).toString());

        try {
            // VALIDAR FECHA
            String fechaTexto = jtxtFecha.getText().trim();

            if (!fechaTexto.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Formato inválido. Use yyyy-mm-dd");
                return;
            }

            java.sql.Date fecha = java.sql.Date.valueOf(fechaTexto);

            int idCliente = Integer.parseInt(jcmbCliente.getSelectedItem().toString().split(" - ")[0]);
            int idServicio = Integer.parseInt(jcmbServicio.getSelectedItem().toString().split(" - ")[0]);
            java.sql.Time hora = java.sql.Time.valueOf(jcmbHora.getSelectedItem() + ":00");
            String estado = jcmbEstado.getSelectedItem().toString();

            Reserva r = new Reserva(id, idCliente, idServicio, fecha, hora, estado);
            ReservaDAO dao = new ReservaDAO();

            if (dao.actualizarReserva(r)) {
                JOptionPane.showMessageDialog(this, "Reserva actualizada.");
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        
        try {
            // VALIDAR FORMATO DE FECHA
            String fechaTexto = jtxtFecha.getText().trim();

            if (!fechaTexto.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Formato inválido. Use yyyy-mm-dd");
                return;
            }

            java.sql.Date fecha = java.sql.Date.valueOf(fechaTexto);

            int idCliente = Integer.parseInt(jcmbCliente.getSelectedItem().toString().split(" - ")[0]);
            int idServicio = Integer.parseInt(jcmbServicio.getSelectedItem().toString().split(" - ")[0]);
            java.sql.Time hora = java.sql.Time.valueOf(jcmbHora.getSelectedItem() + ":00");
            String estado = jcmbEstado.getSelectedItem().toString();

            Reserva r = new Reserva(0, idCliente, idServicio, fecha, hora, estado);
            ReservaDAO dao = new ReservaDAO();

            if (dao.agregarReserva(r)) {
                JOptionPane.showMessageDialog(this, "Reserva agregada.");
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar. Verifique disponibilidad.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jtblReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblReservasMouseClicked
        
        int fila = jtblReservas.getSelectedRow();

        String cliente = jtblReservas.getValueAt(fila, 1).toString();
        String servicio = jtblReservas.getValueAt(fila, 2).toString();

        // Seleccionar cliente por nombre
        for (int i = 0; i < jcmbCliente.getItemCount(); i++) {
            if (jcmbCliente.getItemAt(i).contains(cliente)) {
                jcmbCliente.setSelectedIndex(i);
                break;
            }
        }

        // Seleccionar servicio por nombre
        for (int i = 0; i < jcmbServicio.getItemCount(); i++) {
            if (jcmbServicio.getItemAt(i).contains(servicio)) {
                jcmbServicio.setSelectedIndex(i);
                break;
            }
        }

        jtxtFecha.setText(jtblReservas.getValueAt(fila, 3).toString());
        jcmbHora.setSelectedItem(jtblReservas.getValueAt(fila, 4).toString());
        jcmbEstado.setSelectedItem(jtblReservas.getValueAt(fila, 5).toString());

        jbtnActualizar.setEnabled(true);
        jbtnEliminar.setEnabled(true);
    }//GEN-LAST:event_jtblReservasMouseClicked

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        
        int fila = jtblReservas.getSelectedRow();
        if (fila == -1) return;

        int id = Integer.parseInt(jtblReservas.getValueAt(fila, 0).toString());

        int op = javax.swing.JOptionPane.showConfirmDialog(
                this, "¿Eliminar reserva?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);

        if (op == javax.swing.JOptionPane.YES_OPTION) {
            ReservaDAO dao = new ReservaDAO();

            if (dao.eliminarReserva(id)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Reserva eliminada.");
                cargarTabla();
                limpiarCampos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo eliminar.");
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jtxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFechaActionPerformed

    private void limpiarCampos() {
        
        jcmbCliente.setSelectedIndex(0);
        jcmbServicio.setSelectedIndex(0);
        jtxtFecha.setText("");
        jcmbHora.setSelectedIndex(0);
        jcmbEstado.setSelectedIndex(0);
        jtblReservas.clearSelection();

        jbtnActualizar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JComboBox<String> jcmbCliente;
    private javax.swing.JComboBox<String> jcmbEstado;
    private javax.swing.JComboBox<String> jcmbHora;
    private javax.swing.JComboBox<String> jcmbServicio;
    private javax.swing.JLabel jlblCliente;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jlblServicio;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JScrollPane jscrollReservas;
    private javax.swing.JTable jtblReservas;
    private javax.swing.JTextField jtxtFecha;
    // End of variables declaration//GEN-END:variables
}
