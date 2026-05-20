package Model.Entities.Cartas;

// Mov1: Tokenizar   Mov2: FiltrarSimbolos
// Pertenece a AnalisisLexico

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class AnalisisLexico extends Carta {

    public AnalisisLexico() {
        super("AnalisisLexico", 80, 40, 10, 50, TipoCarta.COMPILADOR, Rareza.RARA);
        this.movimientos[0] = new Tokenizar();
        this.movimientos[1] = new FiltrarSimbolos();
    }
}

