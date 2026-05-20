package Model.Entities.Movimientos.Creados;

// Pertenece a Optimizador

import Model.Entities.Cartas.Carta;

public class MejorarRendimiento extends Movimiento {

    public MejorarRendimiento() {
        super("MejorarRendimiento", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 15);
        efectoService.aplicarBuffSpd(aliado, 15);

        return 0;
    }

}

