package Model.Entities.Cartas;

// Mov1: MetodoAbstracto   Mov2: ImplementacionForzada
// Pertenece a ClaseAbstracta

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class ClaseAbstracta extends Carta {

    public ClaseAbstracta() {
        super("ClaseAbstracta", 80, 45, 10, 40, TipoCarta.OBJETO, Rareza.RARA);
        this.movimientos[0] = new MetodoAbstracto();
        this.movimientos[1] = new ImplementacionForzada();
    }
}

