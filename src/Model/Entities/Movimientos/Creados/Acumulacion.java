package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionDeCola

import Model.Entities.Cartas.Carta;

public class Acumulacion extends Movimiento {

    public Acumulacion() {
        super("Acumulacion", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 10);

        return 0;
    }

}

