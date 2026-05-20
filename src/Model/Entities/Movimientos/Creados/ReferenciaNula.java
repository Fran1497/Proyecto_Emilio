package Model.Entities.Movimientos.Creados;

// Pertenece a NullPointerException

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class ReferenciaNula extends Movimiento {

    public ReferenciaNula() {
        super("ReferenciaNula", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real (aunque sea 0, sigue tu patrón)
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: enemigo.setSkipTurn(true);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
