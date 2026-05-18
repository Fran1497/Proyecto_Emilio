package Model.Entities;

import Model.Entities.Cartas.Carta;

public class Tablero {
    private Casilla[] casillasJ2;
    private Casilla[] casillasJ1;
    private static final int Posiciones = 2;

    public Tablero() {
        casillasJ1 = new Casilla[Posiciones];
        casillasJ2 = new Casilla[Posiciones];
    }

    public boolean isLlenoA() {
        for (int i = 0; i < Posiciones; i++) {
            if (casillasJ1[i] == null) return false;
        }
        return true;
    }

    public boolean isLlenoB() {
        for (int i = 0; i < Posiciones; i++) {
            if (casillasJ2[i] != null) return true;
        }
        return false;
    }

    public int getPosiciones(Casilla casilla) {
        for (int i = 0; i < Posiciones; i++) {
            if (casillasJ2[i] == casilla) return i;
        }
        return 0;
    }

    public Carta obtenerEnemigoEnFrente(boolean esJugador1, Casilla casilla) {
        Casilla[] casillasEnemigas;
        if (esJugador1) {
            casillasEnemigas = casillasJ2;
        } else {
            casillasEnemigas = casillasJ1;
        }

        if (this.getPosiciones(casilla) < 0 || (this.getPosiciones(casilla) >= Posiciones)) {
            return null;
        }

        return casillasEnemigas[(this.getPosiciones(casilla))].getCarta();
    }
}
