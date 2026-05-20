// Pertenece a Deadlock
package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class Interbloqueo extends Movimiento {

    public Interbloqueo() {
        super("Interbloqueo", 8); // daño base moderado
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Antes: skipTurns
        aliado.setTurnosAturdido(1);
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
