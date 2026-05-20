package Model.Entities.Movimientos.Creados;

// Pertenece a DO-WHILE

import Model.Entities.Cartas.Carta;

public class PrimeraEjecucion extends Movimiento {

    public PrimeraEjecucion() {
        super("PrimeraEjecucion", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.5, this.getDanio());

        return danioReal;
    }

}

