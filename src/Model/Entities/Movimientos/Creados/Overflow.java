package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;
import Model.Entities.TipoCarta;

public class Overflow extends Movimiento {


    //Pertenece a FORLOOP
    public Overflow() {
        super("Overflow",10);
    }


    @Override
    public void usar(Carta aliado, Carta enemigo) {
        System.out.println("Ejecutando overflow");
        int mulplicador = 1;
        if (enemigo.getTipoE() == TipoCarta.EXCEPCION){
            int multiplicador = 2;
        }
        combateService.aplicardanio(aliado,enemigo,mulplicador,this.getDanio());
        System.out.println("Ultimo danio recibido: " + enemigo.getUltimoDanio());
        System.out.println("Ultimo hp: " + enemigo.getHpActual());
    }
}

