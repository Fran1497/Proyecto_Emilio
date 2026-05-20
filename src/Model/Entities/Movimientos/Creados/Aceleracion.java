package Model.Entities.Movimientos.Creados;

// Pertenece a ContinueStatement

import Model.Entities.Cartas.Carta;

public class Aceleracion extends Movimiento {

    public Aceleracion() {
        super("Aceleracion", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 20);

        return 0; // No hace daño
    }

}
