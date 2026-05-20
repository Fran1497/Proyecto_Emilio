package Model.Entities.Cartas;

// Mov1: DividirProblema   Mov2: CombinarSoluciones
// Pertenece a DivideYVenceras

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class DivideYVenceras extends Carta {

    public DivideYVenceras() {
        super("DivideYVenceras", 85, 50, 10, 45, TipoCarta.RECURSIVO, Rareza.EPICA);
        this.movimientos[0] = new DividirProblema();
        this.movimientos[1] = new CombinarSoluciones();
    }
}

