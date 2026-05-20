package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;

public class CapturarError extends Movimiento {


    //Pertenece a TRYCATCH
    public CapturarError() {
        super("CapturarError", 0);
    }
    @Override
    public void usar(Carta aliado, Carta enemigo) {
        efectoService.aplicarDebuffBuffAtk(enemigo,30);
    }
}
