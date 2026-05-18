package Model.Entities;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnos;
    private Jugador turnoActual;
    private int tamanioMazos;


    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnos = turnos;
        this.turnoActual = jugador1;
    }

    //Metodos
    public void iniciar() {

    }

    public void finalizarTurno() {
        turnos++;
    }

    //Getters and Setters
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(Jugador turnoActual) {
        this.turnoActual = turnoActual;
    }

    public int getTamanioMazos() {
        return tamanioMazos;
    }

    public void setTamanioMazos(int tamanioMazos) {
        this.tamanioMazos = tamanioMazos;
    }
}
