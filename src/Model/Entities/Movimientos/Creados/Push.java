package Model.Entities.Movimientos.Creados;

// Pertenece a Stack

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class Push extends Movimiento {

    public Push() {
        super("Push", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Buffs
        efectoService.aplicarBuffAtk(aliado, 10);
        efectoService.aplicarBuffDef(aliado, 10);

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
