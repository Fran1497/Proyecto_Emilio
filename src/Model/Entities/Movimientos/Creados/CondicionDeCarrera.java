package Model.Entities.Movimientos.Creados;

// Pertenece a RaceCondition

import Model.Entities.Cartas.Carta;

public class CondicionDeCarrera extends Movimiento {

    public CondicionDeCarrera() {
        super("CondicionDeCarrera", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        double multiplicador = Math.random() < 0.5 ? 0.5 : 2.0;

        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        return danioReal;
    }

}

