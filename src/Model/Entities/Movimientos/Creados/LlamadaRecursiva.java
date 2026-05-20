package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionSimple

import Model.Entities.Cartas.Carta;

public class LlamadaRecursiva extends Movimiento {

    public LlamadaRecursiva() {
        super("LlamadaRecursiva", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.2, this.getDanio());

        efectoService.aplicarBuffAtk(aliado, 10);

        return danioReal;
    }

}

