package Model.Entities.Movimientos.Creados;

// Pertenece a AnalisisLexico

import Model.Entities.Cartas.Carta;

public class FiltrarSimbolos extends Movimiento {

    public FiltrarSimbolos() {
        super("FiltrarSimbolos", 5);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 10);

        return 0;
    }


}
