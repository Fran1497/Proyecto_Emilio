package Model.Entities.Cartas;

// Mov1: Activacion   Mov2: EjecucionAutomatica
// Pertenece a Trigger

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Trigger extends Carta {

    public Trigger() {
        super("Trigger", 85, 45, 10, 40, TipoCarta.BD, Rareza.EPICA);
        this.movimientos[0] = new Activacion();
        this.movimientos[1] = new EjecucionAutomatica();
    }
}

