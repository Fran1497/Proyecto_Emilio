package Model.Entities.Movimientos.Creados;

// Pertenece a Trigger

import Model.Entities.Cartas.Carta;

public class EjecucionAutomatica extends Movimiento {

    public EjecucionAutomatica() {
        super("EjecucionAutomatica", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        efectoService.aplicarBuffSpd(aliado, 10);

        return danioReal;
    }

}

