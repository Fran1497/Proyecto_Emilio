package Model.Entities.Movimientos;

import Model.Entities.Cartas.*;
import Model.Entities.Movimientos.Creados.Movimiento;
import Model.Entities.Service.CombateService;

import java.util.Scanner;

public class MainCombateTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CombateService combateService = new CombateService();

        // Cartas SIN STUN
        Carta carta1 = new Paquete();
        Carta carta2 = new Compilacion();

        System.out.println("=== COMBATE DE PRUEBA (SIN STUN) ===");
        System.out.println(carta1.getNombre() + " VS " + carta2.getNombre());
        System.out.println("-------------------------------------");

        boolean turnoJugador1 = true;

        while (carta1.getHpActual() > 0 && carta2.getHpActual() > 0) {

            Carta atacante = turnoJugador1 ? carta1 : carta2;
            Carta defensor = turnoJugador1 ? carta2 : carta1;

            System.out.println("\nTurno de: " + atacante.getNombre());
            System.out.println("HP " + atacante.getNombre() + ": " + atacante.getHpActual());
            System.out.println("HP " + defensor.getNombre() + ": " + defensor.getHpActual());

            Movimiento[] movs = atacante.getMovimientos();

            System.out.println("Elige movimiento:");
            System.out.println("1. " + movs[0].getNombre());
            System.out.println("2. " + movs[1].getNombre());
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            if (opcion < 1 || opcion > 2) opcion = 1;

            Movimiento elegido = movs[opcion - 1];

            System.out.println(atacante.getNombre() + " usa " + elegido.getNombre());

            int danioReal = elegido.usar(atacante, defensor);

            combateService.aplicarUltimoDanio(defensor, danioReal);

            if (defensor.getHpActual() <= 0) {
                System.out.println("\n*** " + defensor.getNombre() + " ha sido derrotado ***");
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }

        System.out.println("\n=== FIN DEL COMBATE ===");
    }
}
