package Model.Entities.Cartas;

// Mov1: Referenciar   Mov2: Desreferenciar
// Pertenece a Puntero

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Puntero extends Carta {

    public Puntero() {
        super("Puntero", 70, 50, 10, 55, TipoCarta.MEMORIA, Rareza.COMUN);
        this.movimientos[0] = new Referenciar();
        this.movimientos[1] = new Desreferenciar();
    }
}

