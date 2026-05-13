package Model.Entities;

import Model.Entities.Cartas.Carta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mazos {

    private int id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private List<Carta> cartas;

    public mazos() {
        this.cartas = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
    }

    public mazos(int id, String nombre, LocalDateTime fechaCreacion, List<Carta> cartas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.cartas = new ArrayList<>(cartas);
    }

    // Añadir carta al mazo
    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    // Barajar el mazo
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Sacar la primera carta del mazo
    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public int size() {
        return cartas.size();
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", cartas=" + cartas +
                '}';
    }
}
