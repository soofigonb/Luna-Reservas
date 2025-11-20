package controlador;

import vista.MenuPrincipal;
import vista.PanelCliente;
import vista.PanelServicio;
import vista.PanelReserva;

/**
 *
 * @author Sofi
 * 
 */

/**
 * Controlador responsável de manejar los eventos del menú principal.
 * Se encarga de escuchar los botones del menú y cargar el panel correspondiente
 * dentro de la ventana principal.
 *
 * Aplica parte del patrón MVC: este controlador actúa como intermediario
 * entre la vista (MenuPrincipal) y los paneles que se deben mostrar.
 */
public class ControladorMenu {

    // Referencia a la ventana principal (vista)
    private MenuPrincipal menu;

    /**
     * Constructor que recibe la vista MenuPrincipal.
     * Al iniciarse, llama al método para registrar los eventos del menú.
     */
    public ControladorMenu(MenuPrincipal menu) {
        this.menu = menu;
        iniciarEventos();  // Activa listeners de los ítems del menú
    }

    /**
     * Registra los ActionListener para cada opción del menú.
     * Cada opción carga un panel distinto.
     */
    private void iniciarEventos() {

        // Evento para mostrar el panel de clientes
        menu.getMenuItemClientes().addActionListener(e -> {
            mostrarPanel(new PanelCliente());
        });

        // Evento para mostrar el panel de servicios
        menu.getMenuItemServicios().addActionListener(e -> {
            mostrarPanel(new PanelServicio());
        });

        // Evento para mostrar el panel de reservas
        menu.getMenuItemReservas().addActionListener(e -> {
            mostrarPanel(new PanelReserva());
        });
    }

    /**
     * Método que reemplaza el contenido actual del JFrame
     * con el panel recibido por parámetro.
     *
     * Este método permite que toda la aplicación funcione
     * dentro de una sola ventana, sin abrir múltiples frames.
     */
    private void mostrarPanel(javax.swing.JPanel panel) {
        panel.setSize(900, 600);
        panel.setLocation(0, 0);

        // Remueve lo que había antes
        menu.getContentPane().removeAll();

        // Inserta el nuevo panel
        menu.getContentPane().add(panel);

        // Actualiza la vista
        menu.getContentPane().revalidate();
        menu.getContentPane().repaint();
    }
}
