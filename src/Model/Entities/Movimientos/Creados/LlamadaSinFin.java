package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionInfinita

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class LlamadaSinFin extends Movimiento {

    public LlamadaSinFin() {
        super("LlamadaSinFin", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real EXACTO como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: aliado.setSkipTurns(1);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}
