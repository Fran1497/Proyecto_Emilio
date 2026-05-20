package Model.Entities.Movimientos.Creados;

// Pertenece a AnalisisLexico

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class Tokenizar extends Movimiento {

    public Tokenizar() {
        super("Tokenizar", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Buff de velocidad
        efectoService.aplicarBuffSpd(aliado, 15);

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
