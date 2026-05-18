package Model.Entities.Movimientos;


import Model.Entities.Cartas.Carta;

public abstract class Movimiento {
    private String nombre;

    public Movimiento(String nombre) {
        this.nombre = nombre;
    }

    public void usar(Carta aliado, Carta enemigo) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
