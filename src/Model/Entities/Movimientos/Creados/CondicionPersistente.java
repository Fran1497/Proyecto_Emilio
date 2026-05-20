package Model.Entities.Movimientos.Creados;

// Pertenece a WHILELoop

import Model.Entities.Cartas.Carta;

public class CondicionPersistente extends Movimiento {

    public CondicionPersistente() {
        super("CondicionPersistente", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 10);

        return 0;
    }

}
