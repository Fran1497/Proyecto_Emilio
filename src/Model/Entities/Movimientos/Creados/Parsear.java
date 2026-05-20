package Model.Entities.Movimientos.Creados;

// Pertenece a AnalisisSintactico

import Model.Entities.Cartas.Carta;

public class Parsear extends Movimiento {

    public Parsear() {
        super("Parsear", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        efectoService.aplicarBuffSpd(aliado, 10);

        return danioReal;
    }

}

