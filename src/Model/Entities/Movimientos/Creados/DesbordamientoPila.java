package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionInfinita

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class DesbordamientoPila extends Movimiento {

    public DesbordamientoPila() {
        super("DesbordamientoPila", 6); // daño leve
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.8, this.getDanio());

        // Antes: aliado.setSkipTurns(1);
        aliado.setTurnosAturdido(1);

        return danioReal;
    }
}
