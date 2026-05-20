package Model.Entities.Movimientos.Creados;

import Model.Entities.Cartas.Carta;

public class Throw extends Movimiento {


    //Pertenece a TRYCATCH
    public Throw() {
        super("Throw", 0);
    }

    @Override
    public void usar(Carta aliado, Carta enemigo) {
        System.out.println("Ejecutando Trow");
        combateService.aplicarUltimodanio(enemigo);
        System.out.println("Ultimo danio recibido: " + enemigo.getUltimoDanio());
        System.out.println("Ultimo hp: " + enemigo.getHpActual());
    }

}
