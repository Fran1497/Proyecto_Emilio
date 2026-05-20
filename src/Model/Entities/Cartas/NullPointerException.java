package Model.Entities.Cartas;

// Mov1: ReferenciaNula   Mov2: Crash
// Pertenece a NullPointerException

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class NullPointerException extends Carta {

    public NullPointerException() {
        super("NullPointerException", 70, 60, 8, 45, TipoCarta.EXCEPCION, Rareza.EPICA);
        this.movimientos[0] = new ReferenciaNula();
        this.movimientos[1] = new Crash();
    }
}

