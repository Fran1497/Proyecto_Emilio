package Model.Entities.Movimientos.Creados;

// Pertenece a DivideYVenceras

import Model.Entities.Cartas.Carta;

public class CombinarSoluciones extends Movimiento {

    public CombinarSoluciones() {
        super("CombinarSoluciones", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 20);

        return 0;
    }

}

