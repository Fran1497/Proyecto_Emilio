package Model.Entities.Cartas;

import Model.Entities.Movimientos.Creados.IteracionConstante;
import Model.Entities.Movimientos.Creados.Overflow;
import Model.Entities.Movimientos.Creados.Overflow;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public class FORLoop extends Carta {


    //Mov1:OverFlow   Mov2:IteraciónConstante
    public FORLoop() {
        super("FORLoop", 80, 40, 30, 20, TipoCarta.BUCLE, Rareza.COMUN);
        Overflow mov1 = new Overflow();
        IteracionConstante mov2 = new IteracionConstante();
        movimientos[0] = mov1;
        movimientos[1] = mov2;
    }
}
