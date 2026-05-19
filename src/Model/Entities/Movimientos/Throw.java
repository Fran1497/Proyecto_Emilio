package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class Throw extends Movimiento{

    public Throw() {
        super("Throw", 0);
    }

    @Override
    public void usar(Carta aliado, Carta enemigo) {
        System.out.println(enemigo.getUltimoDanio());
        combateService.aplicardanio(aliado,enemigo,1,enemigo.getUltimoDanio());
    }

}
