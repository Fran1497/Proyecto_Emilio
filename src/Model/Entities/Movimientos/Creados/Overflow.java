package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class Overflow extends Movimiento {

    public Overflow() {
        super("Overflow", 12); // un poco más fuerte que IteracionConstante
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        double multiplicador = enemigo.getTipoE() == TipoCarta.EXCEPCION ? 2.0 : 1.0;

        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        return danioReal;
    }


}


