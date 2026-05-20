package Model.Entities.Cartas;

// Mov1: EliminarRedundancias   Mov2: MejorarRendimiento
// Pertenece a Optimizador

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Optimizador extends Carta {

    public Optimizador() {
        super("Optimizador", 100, 45, 15, 35, TipoCarta.COMPILADOR, Rareza.LEGENDARIA);
        this.movimientos[0] = new EliminarRedundancias();
        this.movimientos[1] = new MejorarRendimiento();
    }
}

