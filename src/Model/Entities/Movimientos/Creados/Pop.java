package Model.Entities.Movimientos.Creados;

// Pertenece a Stack

import Model.Entities.Cartas.Carta;

public class Pop extends Movimiento {

    public Pop() {
        super("Pop", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.2, this.getDanio());

        return danioReal;
    }

}

