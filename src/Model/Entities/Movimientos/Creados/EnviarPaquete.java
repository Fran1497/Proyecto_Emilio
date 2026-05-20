package Model.Entities.Movimientos.Creados;

// Pertenece a Paquete

import Model.Entities.Cartas.Carta;

public class EnviarPaquete extends Movimiento {

    public EnviarPaquete() {
        super("EnviarPaquete", 10);
    }
    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.2, this.getDanio());

        return danioReal;
    }

}

