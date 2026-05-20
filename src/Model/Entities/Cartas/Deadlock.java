package Model.Entities.Cartas;

// Mov1: ParalizacionTotal   Mov2: Interbloqueo
// Pertenece a Deadlock

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Deadlock extends Carta {

    public Deadlock() {
        super("Deadlock", 100, 35, 15, 15, TipoCarta.HILO, Rareza.LEGENDARIA);

        this.movimientos[0] = new ParalizacionTotal();
        this.movimientos[1] = new Interbloqueo();
    }
}

