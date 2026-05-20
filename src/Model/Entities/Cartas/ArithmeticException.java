package Model.Entities.Cartas;

// Mov1: DivisionPorCero   Mov2: ErrorFatal
// Pertenece a ArithmeticException

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class ArithmeticException extends Carta {

    public ArithmeticException() {
        super("ArithmeticException", 75, 55, 8, 40, TipoCarta.EXCEPCION, Rareza.RARA);
        this.movimientos[0] = new DivisionPorCero();
        this.movimientos[1] = new ErrorFatal();
    }
}

