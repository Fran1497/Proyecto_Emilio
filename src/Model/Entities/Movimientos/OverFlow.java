package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;

public class OverFlow extends Movimiento {

    public OverFlow() {
        super("OverFlow");
    }

    @Override
    public void usar(Carta aliado, Carta enemigo) {
        System.out.println("Overflow");
    }
}

