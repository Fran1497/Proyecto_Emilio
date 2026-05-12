package Model.Entities;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoActual;

    public Partida(Jugador jugador1, Jugador jugador2, int turnoActual) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = turnoActual;
    }

    public void iniciar(){
        
    }
    
    public void finalizarTurno(){
        
    }
    
    public void verificarGanador(){
        
    }
    
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

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }
}
