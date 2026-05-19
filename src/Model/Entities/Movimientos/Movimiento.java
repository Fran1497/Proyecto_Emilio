package Model.Entities.Movimientos;


import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public abstract class Movimiento {
    private String nombre;
    private int danio;
    CombateService combateService = new CombateService();
    EfectoService efectoService = new EfectoService();

    public Movimiento(String nombre,int danio) {
        this.nombre = nombre;
    }


    public void usar(Carta aliado,Carta enemigo) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

}
