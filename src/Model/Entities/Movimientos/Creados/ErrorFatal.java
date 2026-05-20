package Model.Entities.Movimientos.Creados;

// Pertenece a ArithmeticException

import Model.Entities.Cartas.Carta;

public class ErrorFatal extends Movimiento {

    public ErrorFatal() {
        super("ErrorFatal", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 2.5, this.getDanio());

        aliado.setHpActual(aliado.getHpActual() - (danioReal / 2));

        return danioReal;
    }

}
