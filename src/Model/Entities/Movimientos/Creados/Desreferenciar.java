package Model.Entities.Movimientos.Creados;

// Pertenece a Puntero

import Model.Entities.Cartas.Carta;

public class Desreferenciar extends Movimiento {

    public Desreferenciar() {
        super("Desreferenciar", 6);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        enemigo.clearBuffs();

        return danioReal;
    }


}


