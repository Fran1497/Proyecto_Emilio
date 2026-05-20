package Model.Entities.Cartas;

// Mov1: BloqueoMutuo   Mov2: SeccionCritica
// Pertenece a Synchronized

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Synchronized extends Carta {

    public Synchronized() {
        super("Synchronized", 90, 40, 15, 20, TipoCarta.HILO, Rareza.EPICA);
        this.movimientos[0] = new BloqueoMutuo();
        this.movimientos[1] = new SeccionCritica();
    }
}

