package Model.Entities;

import Model.Entities.Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private Mazo mazo;
    List<Carta> mano;

    public Jugador(String nombre, Mazo mazo, List<Carta> mano) {
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new ArrayList<>();
    }

    public void robarCarta(){
        
    }
    
    public void jugarCarta(){
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }
}
