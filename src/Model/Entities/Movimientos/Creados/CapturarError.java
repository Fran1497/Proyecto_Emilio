package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class CapturarError extends Movimiento {

    public CapturarError() {
        super("CapturarError", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        System.out.println("Ejecutando CapturarError");

        double multiplicador = 1.0;

        if (enemigo.getTipoE() == TipoCarta.EXCEPCION) {
            multiplicador = 2.0;
        }

        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        return danioReal;
    }

}

