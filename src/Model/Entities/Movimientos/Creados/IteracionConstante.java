package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;

public class IteracionConstante extends Movimiento {

    public IteracionConstante() {
        super("IteracionConstante", 10); // daño base estándar
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }

}

