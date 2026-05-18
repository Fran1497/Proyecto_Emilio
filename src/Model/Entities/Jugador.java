package Model.Entities;

import Model.Entities.Cartas.Carta;

import java.util.List;

public class Jugador {

    private static int tamaMazo = 6;

    private String nombre;
    private int monedas;
    private mazos mazo; //Las cartas disponibles en el mazo
    private Carta[] mano; //Las cartas que puede jugar
    boolean esJugador1;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new mazos();
        this.mano = new Carta[2];
        this.monedas = 100;
    }

    //Metodos
    public void sacarCartas() {
        mano[0] = mazo.getCartas().get(0);
        mano[1] = mazo.getCartas().get(1);
    }

    //Añade monedas al jugado
    public void añadirMonedas(int cantidad) {
        monedas += cantidad;
    }

    //Saca una carta del mazo a la mano principal
    public boolean jugarCarta(int slotmano, int slotmazo, Partida p) {
        if (comprobarSlots(slotmano, slotmazo, p)) {
            Carta temporal = mano[slotmano];
            mano[slotmano] = mazo.getCartas().get(slotmazo);
            mazo.getCartas().set(slotmazo, temporal);
            return true;
        }
        return false;
    }

    //Comprobamos si el jugador pueda usar ese slot
    public boolean comprobarSlots(int slotmano, int slotmazo, Partida p) {
        return ((slotmano >= 0 && slotmano < mano.length) && (slotmazo >= 0 && slotmazo < p.getTamanioMazos()));
    }

    //Hace que el jugado eliga la carta de su mano
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getTamaMazo() {
        return tamaMazo;
    }

    public static void setTamaMazo(int tamaMazo) {
        Jugador.tamaMazo = tamaMazo;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public mazos getMazo() {
        return mazo;
    }

    public void setMazo(mazos mazo) {
        this.mazo = mazo;
    }

    public Carta[] getMano() {
        return mano;
    }

    public void setMano(Carta[] mano) {
        this.mano = mano;
    }

    public boolean isEsJugador1() {
        return esJugador1;
    }

    public void setEsJugador1(boolean esJugador1) {
        this.esJugador1 = esJugador1;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", mazo='" + mazo + '\'' +
                ", mano=" + mano +
                '}';
    }
}
