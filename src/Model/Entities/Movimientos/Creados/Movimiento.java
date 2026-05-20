package Model.Entities.Movimientos.Creados;


import Model.Entities.Cartas.Carta;
import Model.Entities.Service.CombateService;
import Model.Entities.Service.EfectoService;

public abstract class Movimiento {
    private String nombre;
    private int danio;
    protected static final CombateService combateService = new CombateService();

    EfectoService efectoService = new EfectoService();


    public Movimiento(String nombre,int danio) {
        this.nombre = nombre;
        this.danio = danio; // ← ESTA LÍNEA ES LA QUE FALTABA
    }




    public abstract int usar(Carta aliado, Carta enemigo);

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
