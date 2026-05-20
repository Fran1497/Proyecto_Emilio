package Model.Entities.Movimientos.Creados;

// Pertenece a Polimorfismo

import Model.Entities.Cartas.Carta;

public class Sobrecarga extends Movimiento {

    public Sobrecarga() {
        super("Sobrecarga", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.8, this.getDanio());

        return danioReal;
    }

}

