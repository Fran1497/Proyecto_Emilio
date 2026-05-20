package Model.Entities.Movimientos.Creados;

// Pertenece a BreakStatement

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class CancelacionDeTurno extends Movimiento {

    public CancelacionDeTurno() {
        super("CancelacionDeTurno", 5);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: enemigo.setSkipTurn(true);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
