package Model.Entities.Cartas;

// Mov1: PrimeraEjecucion   Mov2: RepeticionForzada
// Pertenece a DO-WHILE

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class DOWHILE extends Carta {

    public DOWHILE() {
        super("DoWhile", 90, 50, 8, 20, TipoCarta.BUCLE, Rareza.COMUN);
        this.movimientos[0] = new PrimeraEjecucion();
        this.movimientos[1] = new RepeticionForzada();
    }
}

