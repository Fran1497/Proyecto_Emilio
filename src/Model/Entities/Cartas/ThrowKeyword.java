package Model.Entities.Cartas;

// Mov1: LanzarError   Mov2: InterrupcionThrow
// Pertenece a ThrowKeyword

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class ThrowKeyword extends Carta {

    public ThrowKeyword() {
        super("ThrowKeyword", 70, 35, 8, 50, TipoCarta.EXCEPCION, Rareza.COMUN);
        this.movimientos[0] = new LanzarError();
        this.movimientos[1] = new InterrupcionThrow();
    }
}

