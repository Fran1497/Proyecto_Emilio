package Model.Entities.Movimientos.Creados;

// Pertenece a Optimizador

import Model.Entities.Cartas.Carta;

public class EliminarRedundancias extends Movimiento {

    public EliminarRedundancias() {
        super("EliminarRedundancias", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 15);

        return 0;
    }

}

