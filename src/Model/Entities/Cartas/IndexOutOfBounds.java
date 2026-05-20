package Model.Entities.Cartas;

// Mov1: AccesoIlegal   Mov2: Desbordamiento
// Pertenece a IndexOutOfBounds

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class IndexOutOfBounds extends Carta {

    public IndexOutOfBounds() {
        super("IndexOutOfBounds", 80, 50, 10, 35, TipoCarta.EXCEPCION, Rareza.RARA);
        this.movimientos[0] = new AccesoIlegal();
        this.movimientos[1] = new Desbordamiento();
    }
}
