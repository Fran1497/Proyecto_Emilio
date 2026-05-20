package Model.Entities.Cartas;

// Mov1: LlamadaSinFin   Mov2: DesbordamientoPila
// Pertenece a RecursionInfinita

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class RecursionInfinita extends Carta {

    public RecursionInfinita() {
        super("RecursionInfinita", 70, 60, 8, 50, TipoCarta.RECURSIVO, Rareza.LEGENDARIA);
        this.movimientos[0] = new LlamadaSinFin();
        this.movimientos[1] = new DesbordamientoPila();
    }
}

