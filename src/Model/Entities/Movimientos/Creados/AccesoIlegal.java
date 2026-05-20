package Model.Entities.Movimientos.Creados;

// Pertenece a IndexOutOfBounds

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class AccesoIlegal extends Movimiento {

    public AccesoIlegal() {
        super("AccesoIlegal", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        double multiplicador = 1.2;

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, multiplicador, this.getDanio());

        // Aplica el stun (antes era skipTurn)
        enemigo.setTurnosAturdido(1);

        return danioReal;
    }
}
