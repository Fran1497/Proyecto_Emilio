package Model.Entities.Cartas;

// Mov1: CondicionDeCarrera   Mov2: ResultadoInesperado
// Pertenece a RaceCondition

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class RaceCondition extends Carta {

    public RaceCondition() {
        super("RaceCondition", 75, 55, 8, 60, TipoCarta.HILO, Rareza.RARA);
        this.movimientos[0] = new CondicionDeCarrera();
        this.movimientos[1] = new ResultadoInesperado();
    }
}

