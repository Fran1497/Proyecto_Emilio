package Model.Entities.Movimientos.Creados;

// Pertenece a WHILELoop

import Model.Entities.Cartas.Carta;

public class BucleInfinito extends Movimiento {

    public BucleInfinito() {
        super("BucleInfinito", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioBase = this.getDanio();

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, danioBase);

        return danioReal;
    }

}
