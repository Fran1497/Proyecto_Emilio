package Model.Entities.Movimientos.Creados;

// Pertenece a Constructor

import Model.Entities.Cartas.Carta;

public class Inicializar extends Movimiento {

    public Inicializar() {
        super("Inicializar", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        aliado.restaurarStats();

        return 0;
    }

}

