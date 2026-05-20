package Model.Entities.Movimientos.Creados;

// Pertenece a ArithmeticException

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class DivisionPorCero extends Movimiento {

    public DivisionPorCero() {
        super("DivisionPorCero", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 2.0, this.getDanio());

        // Antes: aliado.setSkipTurn(true);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}
