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

    public void ponerCarta(int slot,Carta carta){
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



    public void aplicardanio(Carta aliada,Carta enemiga,double multiplicador){
        enemiga.setHpActual((int) (enemiga.getHpActual() - aliada.getAtkActual() * multiplicador));
    }

    boolean ValidarKO(Carta carta){
        if (carta.getHpActual() <= 0){
            return true;
        }
        return false;
    }

}
