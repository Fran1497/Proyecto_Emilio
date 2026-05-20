package Model.Entities.Movimientos.Creados;

// Pertenece a GarbageCollector

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class Recolectar extends Movimiento {

    public Recolectar() {
        super("Recolectar", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Buff de velocidad
        efectoService.aplicarBuffSpd(aliado, 20);

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
