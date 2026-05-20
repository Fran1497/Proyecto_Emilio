package Model.Entities.Movimientos.Creados;

// Pertenece a RecursionSimple

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class PasoBase extends Movimiento {

    public PasoBase() {
        super("PasoBase", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Aplica el buff de DEF
        efectoService.aplicarBuffDef(aliado, 10);

        // Calcula daño real (aunque sea 0, sigue tu patrón)
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
