package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class IteraciónConstante extends Movimiento {

    public IteraciónConstante() {
        super("IteracionConstante",10);
    }

    @Override
    public void usar(Carta aliado, Carta enemigo) {
        //Defines el codigo
        System.out.println("Ejecutando iteracion");
        efectoService.aplicarDebuffDef(enemigo,20);
        combateService.aplicardanio(aliado,enemigo,1,this.getDanio());
    }
}
