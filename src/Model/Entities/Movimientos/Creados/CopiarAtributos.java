package Model.Entities.Movimientos.Creados;

// Pertenece a ClaseInstanciada

import Model.Entities.Cartas.Carta;

public class CopiarAtributos extends Movimiento {

    public CopiarAtributos() {
        super("CopiarAtributos", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        aliado.copyRandomBuffFrom(enemigo);

        return 0;
    }

}

