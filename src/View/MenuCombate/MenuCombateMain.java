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

        private final ArrayList<Carta> cartasPuestas = new ArrayList<>();

        public PanelCombate() {
            inicializarRectangulos();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point puntoClic = e.getPoint();

                    // 1. Zona del Mazo / Mano (Espacios 1 al 4 -> Índices 6, 7, 8, 9)
                    for (int i = 6; i <= 9; i++) {
                        Rectangle r = RectanguloOscuro.get(i);
                        if (r.contains(puntoClic)) {
                            if (cartasPuestas.get(i) == null) {
                                System.out.println("Clic en tu MAZO - Casilla: " + (i - 5)); // Muestra del 1 al 4
                                cartasPuestas.set(i, new Carta("Guerrero", 12, 10));
                                repaint();
                            }
                            return; // Salimos del evento ya que encontramos la casilla
                        }
                    }

                    // 2. Zona de Cartas Activas (Espacios 5 y 6 -> Índices 10, 11)
                    for (int i = 10; i <= 11; i++) {
                        Rectangle r = RectanguloOscuro.get(i);
                        if (r.contains(puntoClic)) {
                            if (cartasPuestas.get(i) == null) {
                                System.out.println("Clic en tu zona de CARTA ACTIVA - Casilla: " + (i - 5)); // Muestra 5 o 6
                                cartasPuestas.set(i, new Carta("Defensor", 5, 20));
                                repaint();
                            }
                            return;
                        }
                    }
                }
            });
        }

        private void inicializarRectangulos() {
            // PARTE SUPERIOR (Enemigo - Índices del 0 al 5)
            RectanguloClaro.add(new Rectangle(550, 20, 150, 200));  // Index 0
            RectanguloClaro.add(new Rectangle(750, 20, 150, 200));  // Index 1
            RectanguloClaro.add(new Rectangle(950, 20, 150, 200));  // Index 2
            RectanguloClaro.add(new Rectangle(1150, 20, 150, 200)); // Index 3
            RectanguloClaro.add(new Rectangle(750, 260, 150, 200)); // Index 4
            RectanguloClaro.add(new Rectangle(950, 260, 150, 200)); // Index 5

            RectanguloOscuro.add(new Rectangle(555, 25, 140, 190));  // Index 0
            RectanguloOscuro.add(new Rectangle(755, 25, 140, 190));  // Index 1
            RectanguloOscuro.add(new Rectangle(955, 25, 140, 190));  // Index 2
            RectanguloOscuro.add(new Rectangle(1155, 25, 140, 190)); // Index 3
            RectanguloOscuro.add(new Rectangle(755, 265, 140, 190)); // Index 4
            RectanguloOscuro.add(new Rectangle(955, 265, 140, 190)); // Index 5

            // PARTE INFERIOR (Jugador - Índices del 6 al 11)
            // Mazo (Tus espacios 1, 2, 3, 4)
            RectanguloClaro.add(new Rectangle(550, 775, 150, 200));  // Index 6
            RectanguloClaro.add(new Rectangle(750, 775, 150, 200));  // Index 7
            RectanguloClaro.add(new Rectangle(950, 775, 150, 200));  // Index 8
            RectanguloClaro.add(new Rectangle(1150, 775, 150, 200)); // Index 9
            // Cartas Activas (Tus espacios 5 y 6)
            RectanguloClaro.add(new Rectangle(750, 535, 150, 200));  // Index 10
            RectanguloClaro.add(new Rectangle(950, 535, 150, 200));  // Index 11

            // Mazo Oscuro
            RectanguloOscuro.add(new Rectangle(555, 780, 140, 190));  // Index 6
            RectanguloOscuro.add(new Rectangle(755, 780, 140, 190));  // Index 7
            RectanguloOscuro.add(new Rectangle(955, 780, 140, 190));  // Index 8
            RectanguloOscuro.add(new Rectangle(1155, 780, 140, 190)); // Index 9
            // Cartas Activas Oscuro
            RectanguloOscuro.add(new Rectangle(755, 540, 140, 190));  // Index 10
            RectanguloOscuro.add(new Rectangle(955, 540, 140, 190));  // Index 11

            for (int i = 0; i < RectanguloOscuro.size(); i++) {
                cartasPuestas.add(null);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            g2.setColor(fondo);
            g2.fillRect(0, 0, w, h);

            g2.setColor(sombraMadera);
            g2.fillRect(700, 30, 50, 175);
            g2.fillRect(900, 30, 50, 175);
            g2.fillRect(1100, 30, 50, 175);
            g2.fillRect(900, 270, 50, 175);

            g2.fillRect(700, 790, 50, 175);
            g2.fillRect(900, 790, 50, 175);
            g2.fillRect(1100, 790, 50, 175);
            g2.fillRect(900, 545, 50, 175);

            g2.setColor(madera);
            for (Rectangle r : RectanguloClaro) {
                g2.fillRect(r.x, r.y, r.width, r.height);
            }

            for (int i = 0; i < RectanguloOscuro.size(); i++) {
                Rectangle r = RectanguloOscuro.get(i);
                Carta cartaActual = cartasPuestas.get(i);

                if (cartaActual != null) {
                    cartaActual.dibujar(g2, r.x, r.y, r.width, r.height);
                } else {
                    g2.setColor(maderaOscura);
                    g2.fillRect(r.x, r.y, r.width, r.height);
                }
            }
        }
    }

    static class Carta {
        private String nombre;
        private int ataque;
        private int vida;

        public Carta(String nombre, int ataque, int vida) {
            this.nombre = nombre;
            this.ataque = ataque;
            this.vida = vida;
        }

        public void dibujar(Graphics2D g2, int x, int y, int width, int height) {
            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, height);

            g2.setColor(Color.BLACK);
            g2.drawRect(x, y, width, height);

            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString(nombre, x + 15, y + 35);

            g2.setFont(new Font("Arial", Font.PLAIN, 12));
            g2.drawString("ATK: " + ataque, x + 15, y + 90);
            g2.drawString("HP: " + vida, x + 15, y + 120);
        }
    }

    public static void main(String[] args) {
        new MenuCombateMain();
    }
}