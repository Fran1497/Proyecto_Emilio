package Model.Entities.Movimientos.Creados;

// Pertenece a ClaseInstanciada

import Model.Entities.Cartas.Carta;

public class CrearInstancia extends Movimiento {

    public CrearInstancia() {
        super("CrearInstancia", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 15);

        return 0;
    }

}

