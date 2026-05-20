package Model.Entities.Movimientos.Creados;

// Pertenece a ContinueStatement

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class SaltarIteracion extends Movimiento {

    public SaltarIteracion() {
        super("SaltarIteracion", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: aliado.setSkipTurn(true);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}
