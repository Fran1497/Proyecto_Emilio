package Model.Entities.Movimientos.Creados;

// Pertenece a Transaccion

import Model.Entities.Cartas.Carta;

public class Commit extends Movimiento {

    public Commit() {
        super("Commit", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 20);

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }

}

