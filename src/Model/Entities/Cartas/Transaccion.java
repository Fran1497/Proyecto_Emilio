package Model.Entities.Cartas;

// Mov1: Commit   Mov2: Rollback
// Pertenece a Transaccion

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Transaccion extends Carta {

    public Transaccion() {
        super("Transaccion", 95, 40, 15, 25, TipoCarta.BD, Rareza.EPICA);
        this.movimientos[0] = new Commit();
        this.movimientos[1] = new Rollback();
    }
}
