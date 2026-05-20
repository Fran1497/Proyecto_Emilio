package Model.Entities.Cartas;

// Mov1: Recolectar   Mov2: Compactar
// Pertenece a GarbageCollector

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class GarbageCollector extends Carta {

    public GarbageCollector() {
        super("GarbageCollector", 90, 35, 15, 30, TipoCarta.MEMORIA, Rareza.LEGENDARIA);
        this.movimientos[0] = new Recolectar();
        this.movimientos[1] = new Compactar();
    }
}

