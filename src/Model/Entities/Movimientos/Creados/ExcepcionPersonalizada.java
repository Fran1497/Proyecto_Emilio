package Model.Entities.Movimientos.Creados;

// Pertenece a CustomException

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class ExcepcionPersonalizada extends Movimiento {

    public ExcepcionPersonalizada() {
        super("ExcepcionPersonalizada", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        double multiplicador = enemigo.getTipoE() == TipoCarta.EXCEPCION ? 2.0 : 1.0;

        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        return danioReal;
    }

}

