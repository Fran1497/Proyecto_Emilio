package Model.Entities.Movimientos.Creados;

// Pertenece a CustomException

import Model.Entities.Cartas.Carta;

public class CancelacionTotal extends Movimiento {

    public CancelacionTotal() {
        super("CancelacionTotal", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        enemigo.clearBuffs();

        return 0;
    }

}

