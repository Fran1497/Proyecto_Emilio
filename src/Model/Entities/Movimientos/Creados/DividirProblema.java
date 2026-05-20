package Model.Entities.Movimientos.Creados;

// Pertenece a DivideYVenceras

import Model.Entities.Cartas.Carta;

public class DividirProblema extends Movimiento {

    public DividirProblema() {
        super("DividirProblema", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 10);
        efectoService.aplicarBuffDef(aliado, 10);

        return 0;
    }

}

