package Model.Entities;

import Model.Entities.Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    List<Carta> cartas;

    public Mazo(List<Carta> cartas) {
        this.cartas = new ArrayList<>();
    }

    public void barajar(){

    }

    public void sacarCarta(){

    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}

