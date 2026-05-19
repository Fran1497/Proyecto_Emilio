package Model.Entities.Service;

import Model.Entities.Cartas.Carta;
import Model.Entities.Casilla;
import Model.Entities.Jugador;
import Model.Entities.Tablero;

import java.util.Random;

public class CombateService {
    Tablero tablero = new Tablero();
    Random rd = new Random();


    public void ejectuarAtaque(int slotmov,Casilla casilla,boolean esJugador1){
        casilla.getCarta().usarAtaque(slotmov,tablero.obtenerEnemigoEnFrente(esJugador1,casilla));
    }

    public void ponerCarta(int slot,int slotmazo,Jugador jugador){
        if (jugador.isEsJugador1()){
            tablero.getCasillasJ1()[slot].setCarta(jugador.getMazo().getCartas().get(slotmazo));
        }else{
            tablero.getCasillasJ2()[slot].setCarta(jugador.getMazo().getCartas().get(slotmazo));
        }
    }

    public void asignarJugador1(Jugador jugadorA,Jugador jugadorB){
        int numero = rd.nextInt(10);
        if (numero >= 5){
            jugadorA.setEsJugador1(true);
            jugadorB.setEsJugador1(false);
        }else{
            jugadorB.setEsJugador1(true);
            jugadorA.setEsJugador1(false);
        }
    }

    public void aplicardanio(Carta aliada,Carta enemiga,double multiplicador,int danio){
        enemiga.setHpActual((int)((enemiga.getHpActual() + (double) enemiga.getDefActual() / 2) - (aliada.getAtkActual() + danio) * multiplicador));
        enemiga.setUltimoDanio((int)((enemiga.getHpActual() + (double) enemiga.getDefActual() / 2) - (aliada.getAtkActual() + danio) * multiplicador));
    }
    public void aplicarUltimodanio(Carta enemiga){
        enemiga.setHpActual(enemiga.getHpActual() - enemiga.getUltimoDanio());
    }
    public Carta atacarprimero(Carta aliada,Carta enemiga){
        if (aliada.getSpdActual() > enemiga.getSpdActual()){
            return aliada;
        }
        if (aliada.getSpdActual() < enemiga.getSpdActual()){
            return enemiga;
        }else{
            int numero = rd.nextInt();
            if (numero >= 5){
                return aliada;
            }else{
                return enemiga;
            }
        }
    }

    boolean ValidarKO(Carta carta){
        if (carta.getHpActual() <= 0){
            return true;
        }
        return false;
    }

}
