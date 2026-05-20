package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;

public class IteracionConstante extends Movimiento {


    //Pertenece a FORLOOP
    public IteracionConstante() {
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
