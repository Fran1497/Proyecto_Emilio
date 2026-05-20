package Model.Entities.Movimientos.Creados;

// Pertenece a Compilacion

import Model.Entities.Cartas.Carta;

public class Compilar extends Movimiento {

    public Compilar() {
        super("Compilar", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 10);

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }

}

