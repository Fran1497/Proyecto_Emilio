package Model.Entities.Movimientos.Creados;

// Pertenece a DO-WHILE

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class RepeticionForzada extends Movimiento {

    public RepeticionForzada() {
        super("RepeticionForzada", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.3, this.getDanio());

        // Antes: aliado.setSkipTurns(1);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}


