package Model.Entities.Movimientos.Creados;

// Pertenece a IndexOutOfBounds

import Model.Entities.Cartas.Carta;

public class Desbordamiento extends Movimiento {

    public Desbordamiento() {
        super("Desbordamiento", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.3, this.getDanio());

        return danioReal;
    }

}

