

package Model.Entities.Cartas;

import Model.Entities.Movimientos.Movimiento;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

public abstract class Carta {

    //Atributos base
    private int id;
    private String nombre;
    private Rareza rareza;
    private TipoCarta tipo;


    // ===== STATS BASE =====
    private final int hpBase;
    private final int atkBase;
    private final int defBase;
    private final int spdBase;

    // ===== STATS ACTUALES =====
    private int hpActual;
    private int atkActual;
    private int defActual;
    private int spdActual;

    public Movimiento[] movimientos;

    public Carta(int hp,int atk, int def, int spd,Rareza rareza,TipoCarta tipo) {

        this.atkBase = atk;
        this.defBase = def;
        this.spdBase = spd;
        this.hpBase = hp;

        // al iniciar combate
        this.atkActual = atk;
        this.defActual = def;
        this.spdActual = spd;
        this.hpActual = hp;

        this.movimientos = new Movimiento[2];

        this.rareza = rareza;
        this.tipo = tipo;
        
    }

    // ===== RESET =====
    public void restaurarStats() {
        atkActual = atkBase;
        defActual = defBase;
        spdActual = spdBase;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rareza=" + rareza +
                ", tipo=" + tipo +
                ", atkBase=" + atkBase +
                ", defBase=" + defBase +
                ", spdBase=" + spdBase +
                ", atkActual=" + atkActual +
                ", defActual=" + defActual +
                ", spdActual=" + spdActual +
                '}';
    }
    public int getHpBase(){
        return hpBase;
    }
     public int getHpAct() {
        return hpActual;
    }
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

    public Rareza getRareza() {
        return rareza;
    }

    public void setRareza(Rareza rareza) {
        this.rareza = rareza;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarta tipo) {
        this.tipo = tipo;
    }

    public int getAtkBase() {
        return atkBase;
    }

    public int getDefBase() {
        return defBase;
    }

    public int getSpdBase() {
        return spdBase;
    }

    public int getAtkActual() {
        return atkActual;
    }

    public void setAtkActual(int atkActual) {
        this.atkActual = atkActual;
    }

    public int getDefActual() {
        return defActual;
    }

    public void setDefActual(int defActual) {
        this.defActual = defActual;
    }

    public int getSpdActual() {
        return spdActual;
    }

    public void setSpdActual(int spdActual) {
        this.spdActual = spdActual;
    }
}
