package Model.Entities.Cartas;

// Mov1: Interrupcion   Mov2: CancelacionDeTurno
// Pertenece a BreakStatement

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class BreakStatement extends Carta {

    public BreakStatement() {
        super("BreakStatement", 70, 30, 12, 35, TipoCarta.BUCLE, Rareza.RARA);
        this.movimientos[0] = new Interrupcion();
        this.movimientos[1] = new CancelacionDeTurno();
    }
}

