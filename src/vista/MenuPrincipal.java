/**
 *
 * @author Sofi
 */

package vista;

import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;


/**
 * Ventana principal de la aplicación.
 * 
 * Esta clase representa el JFrame base donde se cargarán los diferentes paneles
 * de gestión (clientes, servicios, reservas). Funciona como contenedor principal
 * dentro del patrón MVC, mostrando únicamente la vista, mientras los controladores
 * manejan los eventos.
 */

public class MenuPrincipal extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());

    /**
     * Constructor de la ventana principal.
     * 
     * Llama a initComponents() para construir el diseño y luego crea
     * la instancia del ControladorMenu que se encargará de manejar los eventos
     * del menú superior.
     */
    public MenuPrincipal() {
        initComponents();
        new controlador.ControladorMenu(this);
        
    }

    /**
     * Método generado automáticamente por NetBeans.
     * 
     * Construye el menú, agrega los ítems y configura el layout inicial vacío
     * donde luego se insertarán los paneles dinámicamente.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jmenuBarPrincipal = new JMenuBar();
        jmenuGestion = new JMenu();
        jmenuItemClientes = new JMenuItem();
        jmenuItemServicios = new JMenuItem();
        jmenuItemReservas = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jmenuBarPrincipal.setToolTipText("");

        jmenuGestion.setText("Gestionar");

        jmenuItemClientes.setText("Clientes");
        jmenuItemClientes.setToolTipText("");
        jmenuGestion.add(jmenuItemClientes);

        jmenuItemServicios.setText("Servicios");
        jmenuGestion.add(jmenuItemServicios);

        jmenuItemReservas.setText("Reservas");
        jmenuGestion.add(jmenuItemReservas);

        jmenuBarPrincipal.add(jmenuGestion);

        setJMenuBar(jmenuBarPrincipal);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void mostrarPanel(javax.swing.JPanel panel) {
        panel.setSize(800, 600);
        panel.setLocation(0, 0);

        this.getContentPane().removeAll(); 
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    
    public JMenuItem getMenuItemClientes() {
        return jmenuItemClientes;
    }

    public JMenuItem getMenuItemServicios() {
        return jmenuItemServicios;
    }

    public JMenuItem getMenuItemReservas() {
        return jmenuItemReservas;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
      

        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuBar jmenuBarPrincipal;
    private JMenu jmenuGestion;
    public JMenuItem jmenuItemClientes;
    public JMenuItem jmenuItemReservas;
    public JMenuItem jmenuItemServicios;
    // End of variables declaration//GEN-END:variables
}
