// Pertenece a NullPointerException
package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public class Crash extends Movimiento {

    public Crash() {
        super("Crash", 10); // daño base medio
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        CombateService combateService = new CombateService();
        EfectoService efectoService = new EfectoService();

        // Calcula el daño real EXACTAMENTE como tú lo haces
        int danioReal = combateService.aplicardanio(aliado, enemigo, 1.0, this.getDanio());

        // Aplica el stun
        enemigo.setTurnosAturdido(1);



        return danioReal;
    }
}
