package Model.Entities.Cartas;

// Mov1: CondicionPersistente   Mov2: BucleInfinito
// Pertenece a WHILELoop

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class WHILELoop extends Carta {

    public WHILELoop() {
        super("While", 85, 40, 10, 30, TipoCarta.BUCLE, Rareza.COMUN);
        this.movimientos[0] = new CondicionPersistente();
        this.movimientos[1] = new BucleInfinito();
    }
}
