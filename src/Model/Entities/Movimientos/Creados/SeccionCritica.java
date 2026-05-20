package Model.Entities.Movimientos.Creados;

// Pertenece a Synchronized

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class SeccionCritica extends Movimiento {

    public SeccionCritica() {
        super("SeccionCritica", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: aliado.setSkipTurns(1); enemigo.setSkipTurns(1);
        aliado.setTurnosAturdido(1);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
