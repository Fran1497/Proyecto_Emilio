package Model.Entities.Movimientos.Creados;

// Pertenece a Heap

import Model.Entities.Cartas.Carta;

public class LiberarMemoria extends Movimiento {

    public LiberarMemoria() {
        super("LiberarMemoria", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 20);

        return 0;
    }

}

