// Pertenece a Socket
package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;

public class Desconexion extends Movimiento {

    public Desconexion() {
        super("Desconexion", 0); // no hace daño
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        enemigo.setTurnosAturdido(1); // aturde 1 turno

        return 0;
    }
}
