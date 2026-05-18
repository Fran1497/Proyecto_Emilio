package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;

public class IteraciónConstante extends Movimiento {

    public IteraciónConstante() {
        super("IteracionConstante");
    }

    @Override
    public void usar(Carta aliada, Carta enemigo) {
        //Defines el codigo
    }
}
