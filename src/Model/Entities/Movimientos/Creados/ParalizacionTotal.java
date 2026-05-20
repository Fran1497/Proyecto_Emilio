package Model.Entities.Movimientos.Creados;

// Pertenece a Deadlock

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import java.util.Random;

public class ParalizacionTotal extends Movimiento {

    private final Random rd = new Random();

    public ParalizacionTotal() {
        super("ParalizacionTotal", 4); // daño leve
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Daño real EXACTO como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Stun fijo al enemigo
        enemigo.setTurnosAturdido(2);

        // 30% de self-stun
        if (rd.nextDouble() <= 0.30) {
            aliado.setTurnosAturdido(1);
        }

        return danioReal;
    }
}
