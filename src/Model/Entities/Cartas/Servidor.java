package Model.Entities.Cartas;

// Mov1: Escuchar   Mov2: Responder
// Pertenece a Servidor

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Servidor extends Carta {

    public Servidor() {
        super("Servidor", 95, 40, 15, 25, TipoCarta.RED, Rareza.LEGENDARIA);
        this.movimientos[0] = new Escuchar();
        this.movimientos[1] = new Responder();
    }
}

