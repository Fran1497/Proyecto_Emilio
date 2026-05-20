package Model.Entities.Movimientos.Creados;

// Pertenece a Servidor

import Model.Entities.Cartas.Carta;

public class Escuchar extends Movimiento {

    public Escuchar() {
        super("Escuchar", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 10);

        return 0;
    }

}
