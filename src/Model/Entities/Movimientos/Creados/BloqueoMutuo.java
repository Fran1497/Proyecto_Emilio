package Model.Entities.Movimientos.Creados;

// Pertenece a Synchronized

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class BloqueoMutuo extends Movimiento {

    public BloqueoMutuo() {
        super("BloqueoMutuo", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        double multiplicador = 1.0;

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        // Antes: aliado.setSkipTurns(1); enemigo.setSkipTurns(1);
        aliado.setTurnosAturdido(1);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
