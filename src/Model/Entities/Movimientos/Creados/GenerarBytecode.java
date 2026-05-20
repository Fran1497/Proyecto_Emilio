package Model.Entities.Movimientos.Creados;

// Pertenece a Compilacion

import Model.Entities.Cartas.Carta;

public class GenerarBytecode extends Movimiento {

    public GenerarBytecode() {
        super("GenerarBytecode", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 15);

        return 0;
    }

}

