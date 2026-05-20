package Model.Entities.Cartas;

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public class TryCatch extends Carta {

    public TryCatch() {
        super("TryCatch", 100, 18, 10, 18, TipoCarta.EXCEPCION, Rareza.RARA);

        this.movimientos[0] = new CapturarError();
        this.movimientos[1] = new Throw();
    }
}

