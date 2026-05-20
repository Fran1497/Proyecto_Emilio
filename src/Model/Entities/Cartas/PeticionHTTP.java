package Model.Entities.Cartas;

// Mov1: GET   Mov2: POST
// Pertenece a PeticionHTTP

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class PeticionHTTP extends Carta {

    public PeticionHTTP() {
        super("PeticionHTTP", 75, 45, 10, 55, TipoCarta.RED, Rareza.COMUN);
        this.movimientos[0] = new GET();
        this.movimientos[1] = new POST();
    }
}

