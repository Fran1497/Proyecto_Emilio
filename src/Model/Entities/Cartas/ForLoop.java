package Model.Entities.Cartas;

import Model.Entities.Movimientos.*;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public class ForLoop extends Carta {

    public ForLoop() {
        super(80,20,30,40,Rareza.COMUN,TipoCarta.BUCLE);
        OverFlow mov1 = new OverFlow();
        IteraciónConstante mov2 = new IteraciónConstante();
        movimientos[0] = mov1;
        movimientos[1] = mov2;
    }
}

