package Model.Entities.Service;

import Model.Entities.Cartas.Carta;

public class EfectoService {

    //Buffs
    public void aplicarBuffAtk(Carta carta, int buff) {
        carta.setAtkActual(carta.getAtkActual() + carta.getAtkActual() * buff);
    }

    public void aplicarBuffDef(Carta carta, int buff) {
        carta.setDefActual(carta.getDefActual() + carta.getDefActual() * buff);
    }

    public void aplicarBuffSpd(Carta carta, int buff) {
        carta.setSpdActual(carta.getSpdActual() + carta.getSpdActual() * buff);
    }

    //Debuff
    public void aplicarDebuffBuffAtk(Carta carta, int buff) {
        carta.setAtkActual(carta.getAtkActual() - carta.getAtkActual() * buff);
    }

    public void aplicarDebuffDef(Carta carta, int buff) {
        carta.setDefActual(carta.getDefActual() - carta.getDefActual() * buff/100);
    }


    public void aplicarDebuffSpd(Carta carta, int buff) {
        carta.setSpdActual(carta.getSpdActual() - carta.getSpdActual() * buff);
    }
}
