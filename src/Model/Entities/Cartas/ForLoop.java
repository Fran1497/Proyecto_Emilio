package Model.Entities.Cartas;

import Model.Entities.Movimientos.IteraciónConstante;
import Model.Entities.Movimientos.OverFlow;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public class ForLoop extends Carta{
    public ForLoop() {
        super("For-Loop",80,40,30,20,TipoCarta.BUCLE,Rareza.COMUN,"");

        //Movimientos
        OverFlow mov1 = new OverFlow();
        IteraciónConstante mov2 = new IteraciónConstante();
        movimientos[0] = mov1;
        movimientos[1] = mov2;
    }
}
