package Model.Entities;

import Model.Entities.Cartas.Carta;

import java.util.List;

public class Jugador {

    private static int tamaMazo = 6;

    private String nombre;
    private int monedas;
    private Carta[] mazo; //Las cartas disponibles en el mazo
    private Carta[] mano; //Las cartas que puede jugar


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new Carta[tamaMazo];
        this.mano = new Carta[2];
        this.monedas = 100;
    }

    //Metodos
    public boolean jugarCarta(int slotmano,int slotmazo) {
        if ((slotmano >= 0 && slotmano < mano.length) && (slotmazo >= 0 && slotmazo < mazo.length)) {
            Carta jugada = mazo[slotmazo];
            mano[slotmano] = jugada;
            return true;
        }
        return false;
    }

    public void añadirMonedas(int cantidad){
        monedas += cantidad;
    }
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

    public Carta[] getMazo() {
        return mazo;
    }

    public void setMazo(Carta[] mazo) {
        this.mazo = mazo;
    }

    public Carta[] getMano() {
        return mano;
    }

    public void setMano(Carta[] mano) {
        this.mano = mano;
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
