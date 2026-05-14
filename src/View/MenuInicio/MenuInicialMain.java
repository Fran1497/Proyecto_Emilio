package View.MenuInicio;

import javax.swing.*;
import java.awt.*;

public class MenuInicialMain extends JFrame {

    public MenuInicialMain() {
        // Ventana principal
        setTitle("DAM-Duel");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Añadir panel de dibujo
        add(new DibujarMenu());

        // Mostrar ventana
        setVisible(true);
    }

    public static class DibujarMenu extends JPanel {

        public DibujarMenu() {
            // Color de fondo del panel
            setBackground(new Color(0x2B2B2B));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Rectángulo oscuro
            g.setColor(new Color(0x584530));
            g.fillRect(780, 55, 348, 82);

            // Rectángulo claro
            g.setColor(new Color(0x896B49));
            g.fillRect(775, 50, 348, 82);

            // Texto
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.WHITE);
            g.drawString("DAM-DUEL", 800, 110);
        }
    }

    public static void main(String[] args) {
        new MenuInicialMain();
    }
}