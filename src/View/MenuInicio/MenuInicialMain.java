package View.MenuInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class MenuInicialMain extends JFrame {

    public MenuInicialMain(String nombre, int dinero) {
        setTitle("DAM-DUEL");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PanelMenu(nombre, dinero));
        setVisible(true);
    }

    static class PanelMenu extends JPanel {

        private final String nombre;
        private final int dinero;

        private final Color fondo = new Color(0x1F1F23);
        private final Color madera = new Color(0xA07850);
        private final Color maderaOscura = new Color(0x7A5C38);
        private final Color maderaClara = new Color(0xC09A6A);
        private final Color verdeOscuro = new Color(0x0A4A0A);
        private final Color verdeMedio = new Color(0x0D6B0D);
        private final Color verdeClaro = new Color(0x1A8A1A);
        private final Color cuerda = new Color(0x8B7355);

        // Áreas de clic de los tres carteles (se recalculan en cada paint)
        private Polygon areaIzquierda;
        private Rectangle areaCentro;
        private Polygon areaDerecha;

        public PanelMenu(String nombre, int dinero) {
            this.nombre = nombre;
            this.dinero = dinero;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point p = e.getPoint();
                    if (areaIzquierda != null && areaIzquierda.contains(p)) {
                        System.out.println("Funciona cartel INICIAR PARTIDA");
                    } else if (areaCentro != null && areaCentro.contains(p)) {
                        System.out.println("Funciona cartel CAMBIAR MAZO");
                    } else if (areaDerecha != null && areaDerecha.contains(p)) {
                        System.out.println("Funciona cartel JAVA HUB");
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            int w = getWidth();
            int h = getHeight();

            g2.setColor(fondo);
            g2.fillRect(0, 0, w, h);

            dibujarCesped(g2, w, h);

            int tituloW = 370, tituloH = 90;
            int tituloX = w / 2 - tituloW / 2;
            int tituloY = 55;

            g2.setColor(cuerda);
            g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(tituloX + 50, 0, tituloX + 50, tituloY);
            g2.drawLine(tituloX + tituloW - 50, 0, tituloX + tituloW - 50, tituloY);
            g2.setStroke(new BasicStroke(1));

            dibujarTitulo(g2, tituloX, tituloY, tituloW, tituloH);
            dibujarCajaSuperior(g2, 10, 10, 285, 52, nombre);
            dibujarCajaSuperior(g2, w - 190, 10, 180, 52, String.valueOf(dinero));
            dibujarMoneda(g2, w - 48, 14, 30);

            dibujarCartelFlecha(g2, w, h, true);
            dibujarCartelCentro(g2, w, h);
            dibujarCartelFlecha(g2, w, h, false);
        }

        private void dibujarCesped(Graphics2D g2, int w, int h) {
            int groundY = (int) (h * 0.72);
            int ellipseH = (int) (h * 0.55);

            g2.setColor(verdeOscuro);
            g2.fill(new Ellipse2D.Double(-w * 0.25, groundY, w * 1.5, ellipseH));

            g2.setColor(verdeMedio);
            Ellipse2D media = new Ellipse2D.Double(-w * 0.2, groundY + 8, w * 1.4, ellipseH * 0.9);
            g2.fill(media);

            Shape clipAnterior = g2.getClip();
            g2.clip(media);
            dibujarHierbajosCesped(g2, w, groundY, ellipseH);
            g2.setClip(clipAnterior);
        }

        private void dibujarHierbajosCesped(Graphics2D g2, int w, int groundY, int ellipseH) {
            Color hierbaOscura = new Color(0x055005);

            int[][] posiciones = {
                    {55, 20}, {160, 22}, {270, 18}, {w / 2 - 130, 20}, {w / 2 - 20, 19},
                    {w / 2 + 110, 21}, {w - 260, 19}, {w - 155, 22}, {w - 55, 20},
                    {100, 68}, {240, 62}, {410, 66}, {w / 2 - 70, 65},
                    {w / 2 + 90, 67}, {w - 400, 64}, {w - 240, 69}, {w - 100, 66},
                    {180, 140}, {w / 2 - 30, 135}, {w / 2 + 120, 140},
                    {w - 370, 138}, {w - 180, 142}
            };

            g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int[] pos : posiciones) {
                dibujarHierbajo(g2, pos[0], groundY + pos[1], hierbaOscura, 20);
            }
            g2.setStroke(new BasicStroke(1));
        }

        private void dibujarHierbajo(Graphics2D g2, int x, int y, Color color, int alto) {
            g2.setColor(color);
            g2.drawLine(x, y, x - 7, y - (int) (alto * 0.78));
            g2.drawLine(x + 7, y, x + 7, y - alto);
            g2.drawLine(x + 14, y, x + 21, y - (int) (alto * 0.72));
        }

        private void dibujarHierbajoBase(Graphics2D g2, int paloX, int groundY) {
            Color verdeTrasero = new Color(0x0A5A0A);
            g2.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            dibujarHierbajo(g2, paloX - 30, groundY + 28, verdeTrasero, 40);
            dibujarHierbajo(g2, paloX - 10, groundY + 25, verdeTrasero, 46);
            dibujarHierbajo(g2, paloX + 12, groundY + 28, verdeTrasero, 42);
            dibujarHierbajo(g2, paloX + 30, groundY + 28, verdeTrasero, 38);

            g2.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            dibujarHierbajo(g2, paloX - 25, groundY + 22, verdeClaro, 44);
            dibujarHierbajo(g2, paloX - 6, groundY + 18, verdeClaro, 50);
            dibujarHierbajo(g2, paloX + 14, groundY + 22, verdeClaro, 46);
            dibujarHierbajo(g2, paloX + 32, groundY + 24, verdeClaro, 40);
            g2.setStroke(new BasicStroke(1));
        }

        private void dibujarTitulo(Graphics2D g2, int x, int y, int w, int h) {
            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillRect(x + 6, y + 6, w, h);

            g2.setColor(maderaOscura);
            g2.fillRect(x, y, w, h);

            g2.setColor(madera);
            g2.fillRect(x + 2, y + 2, w - 4, h - 4);

            g2.setColor(maderaOscura);
            g2.setStroke(new BasicStroke(1.5f));
            for (int i = 1; i < 5; i++) {
                int vy = y + (h / 5) * i;
                g2.drawLine(x + 5, vy, x + w - 5, vy);
            }
            g2.setStroke(new BasicStroke(1));

            dibujarClavo(g2, x + 50, y + 10);
            dibujarClavo(g2, x + w - 50, y + 10);
            dibujarClavo(g2, x + 50, y + h - 10);
            dibujarClavo(g2, x + w - 50, y + h - 10);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 62));
            FontMetrics fm = g2.getFontMetrics();
            String titulo = "DAM-DUEL";
            g2.drawString(titulo,
                    x + (w - fm.stringWidth(titulo)) / 2,
                    y + (h + fm.getAscent() - fm.getDescent()) / 2);
        }

        private void dibujarClavo(Graphics2D g2, int cx, int cy) {
            g2.setColor(new Color(0x5A4A3A));
            g2.fillOval(cx - 4, cy - 4, 8, 8);
            g2.setColor(new Color(0xC0A880));
            g2.fillOval(cx - 2, cy - 2, 5, 5);
        }

        private void dibujarCajaSuperior(Graphics2D g2, int x, int y, int width, int height, String texto) {
            g2.setColor(new Color(0, 0, 0, 60));
            g2.fillRect(x + 3, y + 3, width, height);

            g2.setColor(new Color(0xA85600));
            g2.fillRect(x, y, width, height);

            g2.setColor(new Color(0x6B3500));
            g2.setStroke(new BasicStroke(2.5f));
            g2.drawRect(x, y, width, height);
            g2.setStroke(new BasicStroke(1));

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.PLAIN, 20));
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(texto, x + 12, y + ((height - fm.getHeight()) / 2) + fm.getAscent());
        }

        private void dibujarMoneda(Graphics2D g2, int x, int y, int size) {
            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillOval(x + 2, y + 2, size, size);

            g2.setColor(new Color(0xDAA520));
            g2.fillOval(x, y, size, size);

            g2.setColor(new Color(0xFFD700));
            g2.fillOval(x + 3, y + 3, size - 6, size - 6);

            g2.setColor(new Color(0xB8860B));
            g2.setFont(new Font("Serif", Font.BOLD, 16));
            FontMetrics fm = g2.getFontMetrics();
            String letter = "J";
            g2.drawString(letter,
                    x + (size - fm.stringWidth(letter)) / 2,
                    y + (size + fm.getAscent() - fm.getDescent()) / 2 - 1);
        }

        private void dibujarCartelFlecha(Graphics2D g2, int w, int h, boolean izquierda) {
            AffineTransform old = g2.getTransform();

            int groundY = (int) (h * 0.72);

            int cx, cy;
            double angulo;

            if (izquierda) {
                cx = (int) (w * 0.28);
                cy = (int) (h * 0.38);
                angulo = Math.toRadians(6);
            } else {
                cx = (int) (w * 0.72);
                cy = (int) (h * 0.38);
                angulo = Math.toRadians(-6);
            }

            g2.rotate(angulo, cx, cy);

            int paloX = cx - 9;
            int paloTop = cy + 40;
            int paloBottom = groundY + 35;

            g2.setColor(maderaOscura);
            g2.fillRect(paloX + 4, paloTop + 4, 18, paloBottom - paloTop);

            g2.setColor(madera);
            g2.fillRect(paloX, paloTop, 18, paloBottom - paloTop);

            g2.setColor(maderaOscura);
            g2.setStroke(new BasicStroke(1f));
            g2.drawLine(paloX + 6, paloTop + 10, paloX + 6, paloBottom - 10);
            g2.setStroke(new BasicStroke(1));

            dibujarHierbajoBase(g2, paloX, groundY);

            int fw = 260;
            int fh = 80;
            int punta = 35;

            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillPolygon(crearFlecha(cx, cy, fw, fh, punta, izquierda, 5, 5));

            g2.setColor(maderaOscura);
            g2.fillPolygon(crearFlecha(cx, cy, fw, fh, punta, izquierda, 2, 2));

            g2.setColor(madera);
            Polygon flecha = crearFlecha(cx, cy, fw, fh, punta, izquierda, 0, 0);
            g2.fillPolygon(flecha);

            // Guardar área de clic (sin rotación aplicada; usamos el bounding box del centro)
            if (izquierda) {
                areaIzquierda = flecha;
            } else {
                areaDerecha = flecha;
            }

            g2.setColor(maderaOscura);
            g2.setStroke(new BasicStroke(1.2f));
            for (int i = 1; i < 4; i++) {
                int vy = cy - fh / 2 + (fh / 4) * i;
                int fx1 = izquierda ? cx - fw / 2 + punta : cx - fw / 2;
                int fx2 = izquierda ? cx + fw / 2 : cx + fw / 2 - punta;
                g2.drawLine(fx1 + 5, vy, fx2 - 5, vy);
            }
            g2.setStroke(new BasicStroke(1));

            if (izquierda) {
                dibujarClavo(g2, cx - fw / 2 + punta + 15, cy - fh / 4);
                dibujarClavo(g2, cx + fw / 2 - 15, cy - fh / 4);
                dibujarClavo(g2, cx - fw / 2 + punta + 15, cy + fh / 4);
                dibujarClavo(g2, cx + fw / 2 - 15, cy + fh / 4);
            } else {
                dibujarClavo(g2, cx - fw / 2 + 15, cy - fh / 4);
                dibujarClavo(g2, cx + fw / 2 - punta - 15, cy - fh / 4);
                dibujarClavo(g2, cx - fw / 2 + 15, cy + fh / 4);
                dibujarClavo(g2, cx + fw / 2 - punta - 15, cy + fh / 4);
            }

            g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
            FontMetrics fm = g2.getFontMetrics();
            String texto = izquierda ? "INICIAR PARTIDA" : "JAVA HUB";
            int tx = cx - fm.stringWidth(texto) / 2;
            int ty = cy + fm.getAscent() / 2 - 2;

            g2.setColor(new Color(0, 0, 0, 100));
            g2.drawString(texto, tx + 2, ty + 2);
            g2.setColor(Color.WHITE);
            g2.drawString(texto, tx, ty);

            g2.setTransform(old);
        }

        private Polygon crearFlecha(int cx, int cy, int fw, int fh, int punta,
                                    boolean izquierda, int ox, int oy) {
            Polygon p = new Polygon();
            int x0 = cx - fw / 2 + ox;
            int x1 = cx + fw / 2 + ox;
            int y0 = cy - fh / 2 + oy;
            int y1 = cy + fh / 2 + oy;
            int ym = cy + oy;

            if (izquierda) {
                p.addPoint(x0, ym);
                p.addPoint(x0 + punta, y0);
                p.addPoint(x1, y0);
                p.addPoint(x1, y1);
                p.addPoint(x0 + punta, y1);
            } else {
                p.addPoint(x0, y0);
                p.addPoint(x1 - punta, y0);
                p.addPoint(x1, ym);
                p.addPoint(x1 - punta, y1);
                p.addPoint(x0, y1);
            }
            return p;
        }

        private void dibujarCartelCentro(Graphics2D g2, int w, int h) {
            int groundY = (int) (h * 0.72);
            int cx = w / 2;
            int cartelW = 210;
            int cartelH = 100;
            int cartelX = cx - cartelW / 2;
            int cartelY = (int) (h * 0.32);

            int paloX = cx - 9;
            int paloTop = cartelY + cartelH;
            int paloFin = groundY + 35;

            g2.setColor(maderaOscura);
            g2.fillRect(paloX + 4, paloTop + 4, 18, paloFin - paloTop);

            g2.setColor(madera);
            g2.fillRect(paloX, paloTop, 18, paloFin - paloTop);

            g2.setColor(maderaOscura);
            g2.setStroke(new BasicStroke(1f));
            g2.drawLine(paloX + 6, paloTop + 8, paloX + 6, paloFin - 5);
            g2.setStroke(new BasicStroke(1));

            dibujarHierbajoBase(g2, paloX, groundY);

            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillRect(cartelX + 6, cartelY + 6, cartelW, cartelH);

            g2.setColor(maderaOscura);
            g2.fillRect(cartelX, cartelY, cartelW, cartelH);

            g2.setColor(madera);
            g2.fillRect(cartelX + 2, cartelY + 2, cartelW - 4, cartelH - 4);

            g2.setColor(maderaOscura);
            g2.setStroke(new BasicStroke(1.2f));
            for (int i = 1; i < 4; i++) {
                int vy = cartelY + (cartelH / 4) * i;
                g2.drawLine(cartelX + 6, vy, cartelX + cartelW - 6, vy);
            }
            g2.setStroke(new BasicStroke(1));

            dibujarClavo(g2, cartelX + 12, cartelY + 12);
            dibujarClavo(g2, cartelX + cartelW - 12, cartelY + 12);
            dibujarClavo(g2, cartelX + 12, cartelY + cartelH - 12);
            dibujarClavo(g2, cartelX + cartelW - 12, cartelY + cartelH - 12);

            // Guardar área de clic del cartel central
            areaCentro = new Rectangle(cartelX, cartelY, cartelW, cartelH);

            g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
            FontMetrics fm = g2.getFontMetrics();
            String t1 = "CAMBIAR";
            String t2 = "MAZO";

            int t1x = cx - fm.stringWidth(t1) / 2;
            int t2x = cx - fm.stringWidth(t2) / 2;

            g2.setColor(new Color(0, 0, 0, 100));
            g2.drawString(t1, t1x + 2, cartelY + 38 + 2);
            g2.drawString(t2, t2x + 2, cartelY + 72 + 2);

            g2.setColor(Color.WHITE);
            g2.drawString(t1, t1x, cartelY + 38);
            g2.drawString(t2, t2x, cartelY + 72);
        }
    }

    public static void main(String[] args) {
        String nombre = "Jugador1";
        int dinero = 1000;
        SwingUtilities.invokeLater(() -> new MenuInicialMain(nombre, dinero));
    }
}
