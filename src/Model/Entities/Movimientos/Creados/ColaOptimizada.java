package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionDeCola

import Model.Entities.Cartas.Carta;

public class ColaOptimizada extends Movimiento {

    public ColaOptimizada() {
        super("ColaOptimizada", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.5, this.getDanio());

        return danioReal;
    }

}

