package Model.Entities.Movimientos.Creados;

// Pertenece a Trigger

import Model.Entities.Cartas.Carta;

public class Activacion extends Movimiento {

    public Activacion() {
        super("Activacion", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 20);

        return 0;
    }

}

