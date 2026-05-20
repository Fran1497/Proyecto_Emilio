package Model.Entities.Movimientos.Creados;

// Pertenece a ThrowKeyword

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class LanzarError extends Movimiento {

    public LanzarError() {
        super("LanzarError", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real EXACTO como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.8, this.getDanio());

        // Antes: aliado.setSkipTurn(true);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}
