package Model.Entities.Movimientos.Creados;

// Pertenece a Transaccion

import Model.Entities.Cartas.Carta;

public class Rollback extends Movimiento {

    public Rollback() {
        super("Rollback", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        aliado.restaurarStats();

        return 0;
    }

}

