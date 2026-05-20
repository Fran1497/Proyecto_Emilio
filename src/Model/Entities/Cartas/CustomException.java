package Model.Entities.Cartas;

// Mov1: ExcepcionPersonalizada   Mov2: CancelacionTotal
// Pertenece a CustomException

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class CustomException extends Carta {

    public CustomException() {
        super("CustomException", 85, 40, 12, 35, TipoCarta.EXCEPCION, Rareza.EPICA);
        this.movimientos[0] = new ExcepcionPersonalizada();
        this.movimientos[1] = new CancelacionTotal();
    }
}

