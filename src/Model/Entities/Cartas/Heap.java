package Model.Entities.Cartas;

// Mov1: ReservarMemoria   Mov2: LiberarMemoria
// Pertenece a Heap

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Heap extends Carta {

    public Heap() {
        super("Heap", 100, 40, 12, 20, TipoCarta.MEMORIA, Rareza.RARA);
        this.movimientos[0] = new ReservarMemoria();
        this.movimientos[1] = new LiberarMemoria();
    }
}
