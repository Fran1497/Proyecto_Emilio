package Model.Entities.Movimientos.Creados;

// Pertenece a Puntero

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class Referenciar extends Movimiento {

    public Referenciar() {
        super("Referenciar", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Buff de ataque
        efectoService.aplicarBuffAtk(aliado, 10);

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
