package Model.Entities.Movimientos.Creados;

// Pertenece a AnalisisSintactico

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class ValidarArbol extends Movimiento {

    public ValidarArbol() {
        super("ValidarArbol", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Buff de defensa
        efectoService.aplicarBuffDef(aliado, 20);

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
