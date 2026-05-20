package Model.Entities.Cartas;

// Mov1: EnviarPaquete   Mov2: Fragmentar
// Pertenece a Paquete

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Paquete extends Carta {

    public Paquete() {
        super("Paquete", 80, 55, 10, 45, TipoCarta.RED, Rareza.EPICA);
        this.movimientos[0] = new EnviarPaquete();
        this.movimientos[1] = new Fragmentar();
    }
}

