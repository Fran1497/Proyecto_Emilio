package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class OverFlow extends Movimiento {

    public OverFlow() {
        super("OverFlow",10);
    }


    @Override
    public void usar(Carta aliado, Carta enemigo) {
        System.out.println("Ejecutando overflow");
        int mulplicador = 1;
        if (enemigo.getTipoE() == TipoCarta.EXCEPCION){
            int multiplicador = 2;
        }
        combateService.aplicardanio(aliado,enemigo,mulplicador,this.getDanio());
    }
}

