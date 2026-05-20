package Model.Entities.Cartas;

// Mov1: DeclararMetodo   Mov2: ImplementarMetodo
// Pertenece a Interfaz

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Interfaz extends Carta {

    public Interfaz() {
        super("Interfaz", 70, 30, 10, 55, TipoCarta.OBJETO, Rareza.RARA);
        this.movimientos[0] = new DeclararMetodo();
        this.movimientos[1] = new ImplementarMetodo();
    }
}

