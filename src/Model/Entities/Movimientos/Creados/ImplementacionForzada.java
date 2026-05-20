package Model.Entities.Movimientos.Creados;

// Pertenece a ClaseAbstracta

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class ImplementacionForzada extends Movimiento {

    public ImplementacionForzada() {
        super("ImplementacionForzada", 5);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Antes: enemigo.setSkipTurns(1);
        enemigo.setTurnosAturdido(1);

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.3, this.getDanio());

        return danioReal;
    }
}
