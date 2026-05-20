package Model.Entities.Movimientos.Creados;

// Pertenece a Constructor

import Model.Entities.Cartas.Carta;

public class ConstruccionRapida extends Movimiento {

    public ConstruccionRapida() {
        super("ConstruccionRapida", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffSpd(aliado, 20);

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }

}

