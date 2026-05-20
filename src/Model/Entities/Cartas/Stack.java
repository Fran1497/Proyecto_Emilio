package Model.Entities.Cartas;

// Mov1: Push   Mov2: Pop
// Pertenece a Stack

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Stack extends Carta {

    public Stack() {
        super("Stack", 85, 55, 10, 45, TipoCarta.MEMORIA, Rareza.EPICA);
        this.movimientos[0] = new Push();
        this.movimientos[1] = new Pop();
    }
}

