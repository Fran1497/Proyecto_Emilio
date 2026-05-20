package Model.Entities.Cartas;

// Mov1: LlamadaRecursiva   Mov2: PasoBase
// Pertenece a RecursionSimple

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class RecursionSimple extends Carta {

    public RecursionSimple() {
        super("RecursionSimple", 80, 45, 10, 40, TipoCarta.RECURSIVO, Rareza.COMUN);
        this.movimientos[0] = new LlamadaRecursiva();
        this.movimientos[1] = new PasoBase();
    }
}

