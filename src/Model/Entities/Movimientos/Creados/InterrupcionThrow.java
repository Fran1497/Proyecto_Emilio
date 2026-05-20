package Model.Entities.Movimientos.Creados;

// Pertenece a ThrowKeyword

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class InterrupcionThrow extends Movimiento {

    public InterrupcionThrow() {
        super("InterrupcionThrow", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.5, this.getDanio());

        // Antes: enemigo.setSkipTurn(true);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
