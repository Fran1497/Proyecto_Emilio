package Model.Entities.Movimientos.Creados;

// Pertenece a Heap

import Model.Entities.Cartas.Carta;

public class ReservarMemoria extends Movimiento {

    public ReservarMemoria() {
        super("ReservarMemoria", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 15);

        return 0;
    }

}

