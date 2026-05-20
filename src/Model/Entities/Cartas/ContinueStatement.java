package Model.Entities.Cartas;

// Mov1: SaltarIteracion   Mov2: Aceleracion
// Pertenece a ContinueStatement

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class ContinueStatement extends Carta {

    public ContinueStatement() {
        super("ContinueStatement", 75, 30, 10, 35, TipoCarta.BUCLE, Rareza.RARA);
        this.movimientos[0] = new SaltarIteracion();
        this.movimientos[1] = new Aceleracion();
    }
}

