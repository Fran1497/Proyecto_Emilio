package View.MenuCombate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuCombateMain extends JFrame {

    public MenuCombateMain() {
        setTitle("Combate");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelCombate panelCombate = new PanelCombate();
        add(panelCombate);
        setVisible(true);
    }

    static class PanelCombate extends JPanel {

        private final Color fondo = new Color(0x1F1F23);
        private final Color madera = new Color(0xA65300);
        private final Color maderaOscura = new Color(0x964B00);
        private final Color sombraMadera = new Color(0x7B3D00);
        private final Color verdeOscuro = new Color(0x008E2B);
        private final Color verdeClaro = new Color(0x00D23F);
        private final Color grisClaro = new Color(0xD9D9D9);
        private final Color grisOscuroTr = new Color(0xBFA2A2A2, true);

        private final ArrayList<Rectangle> RectanguloClaro = new ArrayList<>();
        private final ArrayList<Rectangle> RectanguloOscuro = new ArrayList<>();

        public PanelCombate() {
            inicializarRectangulos();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    for (int i = 0; i < RectanguloOscuro.size(); i++) {
                        Rectangle r = RectanguloOscuro.get(i);
                        if (r.contains(e.getPoint())) {
                            System.out.println("Funciona =)");
                            break;
                        }
                    }
                }
            });
        }

        private void inicializarRectangulos() {
            // parte inferior claro
            RectanguloClaro.add(new Rectangle(550, 775, 150, 200));
            RectanguloClaro.add(new Rectangle(750, 775, 150, 200));
            RectanguloClaro.add(new Rectangle(950, 775, 150, 200));
            RectanguloClaro.add(new Rectangle(1150, 775, 150, 200));
            RectanguloClaro.add(new Rectangle(750, 535, 150, 200));
            RectanguloClaro.add(new Rectangle(950, 535, 150, 200));


            // parte inferior oscuro
            RectanguloOscuro.add(new Rectangle(555, 780, 140, 190));
            RectanguloOscuro.add(new Rectangle(755, 780, 140, 190));
            RectanguloOscuro.add(new Rectangle(955, 780, 140, 190));
            RectanguloOscuro.add(new Rectangle(1155, 780, 140, 190));
            RectanguloOscuro.add(new Rectangle(755, 540, 140, 190));
            RectanguloOscuro.add(new Rectangle(955, 540, 140, 190));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            // Dibujar fondo
            g2.setColor(fondo);
            g2.fillRect(0, 0, w, h);

            // parte superior claro
            g2.setColor(madera);
            g2.fillRect(550, 20, 150, 200);
            g2.fillRect(750, 20, 150, 200);
            g2.fillRect(950, 20, 150, 200);
            g2.fillRect(1150, 20, 150, 200);
            g2.fillRect(750, 260, 150, 200);
            g2.fillRect(950, 260, 150, 200);

            // parte superior oscuro
            g2.setColor(maderaOscura);
            g2.fillRect(555, 25, 140, 190);
            g2.fillRect(755, 25, 140, 190);
            g2.fillRect(955, 25, 140, 190);
            g2.fillRect(1155, 25, 140, 190);
            g2.fillRect(755, 265, 140, 190);
            g2.fillRect(955, 265, 140, 190);

            // Dibujar sombras entre cartas
            g2.setColor(sombraMadera);
            g2.fillRect(700, 30, 50, 175);
            g2.fillRect(900, 30, 50, 175);
            g2.fillRect(1100, 30, 50, 175);
            g2.fillRect(900, 270, 50, 175);

            g2.fillRect(700, 790, 50, 175);
            g2.fillRect(900, 790, 50, 175);
            g2.fillRect(1100, 790, 50, 175);
            g2.fillRect(900, 545, 50, 175);

            // Dibujar rectángulos claros
            g2.setColor(madera);
            for (Rectangle r : RectanguloClaro) {
                g2.fillRect(r.x, r.y, r.width, r.height);
            }

            // Dibujar rectángulos oscuros
            g2.setColor(maderaOscura);
            for (Rectangle r : RectanguloOscuro) {
                g2.fillRect(r.x, r.y, r.width, r.height);
            }
        }
    }

    public static void main(String[] args) {
        new MenuCombateMain();
    }
}