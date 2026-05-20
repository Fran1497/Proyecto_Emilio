package Model.Entities.Movimientos.Creados;

// Pertenece a ThrowKeyword

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class Throw extends Movimiento {

    public Throw() {
        super("Throw", 12);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.5, this.getDanio());

        // Antes: enemigo.setSkipTurn(true);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
