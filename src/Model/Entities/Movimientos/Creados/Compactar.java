package Model.Entities.Movimientos.Creados;

// Pertenece a GarbageCollector

import Model.Entities.Cartas.Carta;

public class Compactar extends Movimiento {

    public Compactar() {
        super("Compactar", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 20);

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.2, this.getDanio());

        return danioReal;
    }

}

