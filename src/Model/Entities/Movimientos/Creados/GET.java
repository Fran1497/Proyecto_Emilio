package Model.Entities.Movimientos.Creados;

// Pertenece a PeticionHTTP

import Model.Entities.Cartas.Carta;

public class GET extends Movimiento {

    public GET() {
        super("GET", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }

}
