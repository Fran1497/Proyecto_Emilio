package Model.Entities.Movimientos.Creados;

// Pertenece a Paquete

import Model.Entities.Cartas.Carta;

public class Fragmentar extends Movimiento {

    public Fragmentar() {
        super("Fragmentar", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.2, this.getDanio());

        efectoService.aplicarBuffAtk(aliado, 10);

        return danioReal;
    }

}
