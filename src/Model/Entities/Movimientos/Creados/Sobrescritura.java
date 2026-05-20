package Model.Entities.Movimientos.Creados;

// Pertenece a Polimorfismo

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;

public class Sobrescritura extends Movimiento {

    public Sobrescritura() {
        super("Sobrescritura", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();

        // Limpia los buffs del enemigo
        enemigo.clearBuffs();

        // Daño real siguiendo tu patrón
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        return danioReal;
    }
}
