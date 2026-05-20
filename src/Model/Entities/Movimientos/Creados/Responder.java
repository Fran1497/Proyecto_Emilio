package Model.Entities.Movimientos.Creados;

// Pertenece a Servidor

import Model.Entities.Cartas.Carta;

public class Responder extends Movimiento {

    public Responder() {
        super("Responder", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 10);

        return 0;
    }

}

