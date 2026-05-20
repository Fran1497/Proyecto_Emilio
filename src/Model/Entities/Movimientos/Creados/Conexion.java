package Model.Entities.Movimientos.Creados;

// Pertenece a Socket

import Model.Entities.Cartas.Carta;

public class Conexion extends Movimiento {

    public Conexion() {
        super("Conexion", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 15);

        return 0;
    }

}

