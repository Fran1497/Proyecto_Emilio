package Model.Entities.Movimientos.Creados;

// Pertenece a ClaseAbstracta

import Model.Entities.Cartas.Carta;

public class MetodoAbstracto extends Movimiento {

    public MetodoAbstracto() {
        super("MetodoAbstracto", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 10);

        return 0;
    }


}

