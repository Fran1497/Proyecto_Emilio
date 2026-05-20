package Model.Entities.Cartas;

// Mov1: Acumulacion   Mov2: ColaOptimizada
// Pertenece a RecursionDeCola

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class RecursionDeCola extends Carta {

    public RecursionDeCola() {
        super("RecursionDeCola", 90, 40, 12, 35, TipoCarta.RECURSIVO, Rareza.RARA);
        this.movimientos[0] = new Acumulacion();
        this.movimientos[1] = new ColaOptimizada();
    }
}

