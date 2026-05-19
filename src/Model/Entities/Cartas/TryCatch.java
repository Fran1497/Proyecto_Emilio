package Model.Entities.Cartas;

import Model.Entities.Movimientos.CapturarError;
import Model.Entities.Movimientos.Throw;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public class TryCatch extends Carta {
    public TryCatch(){
        super("TryCatch",50,10,30,20, TipoCarta.EXCEPCION, Rareza.RARO,"");
        Throw mov1 = new Throw();
        CapturarError mov2 = new CapturarError();
        movimientos[0] = mov1;
        movimientos[1] = mov2;
    }
}

