package Model.Entities.Service;

import Model.Entities.Cartas.Carta;

public class CombateService {

    // ============================
    //   PROCESAR ATURDIMIENTOS
    // ============================
    public boolean procesarSaltosDeTurno(Carta atacante) {

        // Si tiene turnos de aturdimiento pendientes, pierde turno
        if (atacante.getTurnosAturdido() > 0) {
            System.out.println(atacante.getNombre() + " está aturdido y pierde su turno.");
            return true; // NO restamos turnos aquí
        }

        return false;
    }


    // ============================
    //   CALCULAR DAÑO REAL
    // ============================
    public int aplicardanio(Carta atacante, Carta defensor, double multiplicador, int danioBase) {

        int danio = (int) (danioBase * multiplicador);

        int defensa = defensor.getDefActual();
        if (defensa < 0) defensa = 0;

        // Fórmula final
        int danioFinal = Math.max(1, (danio * 4) - defensa);

        System.out.println("DEBUG danio recibido: " + danio);

        return danioFinal;
    }


    // ============================
    //   APLICAR DAÑO AL DEFENSOR
    // ============================
    public void aplicarUltimoDanio(Carta defensor, int danioReal) {

        System.out.println("DEBUG antes de aplicar: ultimoDanio = " + defensor.getUltimoDanio());

        defensor.setUltimoDanio(danioReal);

        // Si el movimiento NO hace daño (buffs, debuffs, control, etc.)
        if (danioReal <= 0) {
            System.out.println("Último daño recibido: 0");
            System.out.println("HP restante enemigo: " + defensor.getHpActual());
            return;
        }

        // Aplicar daño real
        defensor.setHpActual(defensor.getHpActual() - danioReal);

        System.out.println("Último daño recibido: " + danioReal);
        System.out.println("HP restante enemigo: " + defensor.getHpActual());
    }
}
