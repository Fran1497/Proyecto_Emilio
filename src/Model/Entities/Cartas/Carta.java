package Model.Entities.Cartas;

import Model.Entities.Movimientos.Creados.Movimiento;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

import java.util.Arrays;

public abstract class Carta {

    private String nombre;
    private int id;
    private TipoCarta tipo;
    private Rareza rareza;
    private String asset;

    //Stats Base
    private int hpBase;
    private int atkBase;
    private int defBase;
    private int spdBase;

    //Stats Actuales

    private int hpActual;
    private int atkActual;
    private int defActual;
    private int spdActual;

    //Movimientos
    public Movimiento[] movimientos;


    private int ultimoDanio;


    public Carta(String nombre, int hp, int atk, int def, int spd,TipoCarta tipo,Rareza rareza) {
        this.nombre = nombre;
        this.hpBase = hp;
        this.atkBase = atk;
        this.defBase = def;
        this.spdBase = spd;


        // al iniciar combate
        this.atkActual = atk;
        this.defActual = def;
        this.spdActual = spd;
        this.hpActual = hp;

        this.movimientos = new Movimiento[2];

        this.rareza = rareza;
        this.tipo = tipo;

        this.asset = asset; //Aqui tendra que venir la ruta de donde esta el asset de la carta

        restaurarStats();
    }
    public void restaurarStats() {
        setHpActual(hpBase);
        atkActual = atkBase;
        defActual = defBase;
        spdActual = spdBase;
    }
    //Metodos

    //Hace que la carta pueda usar un movimiento sobre otra carta
    public boolean usarAtaque(int slot,Carta enemigo){
        if (slot >= 0 && slot < movimientos.length){
            this.movimientos[slot].usar(this, enemigo); //Usa la logica que tenga el movimiento
            return true;
        }else{
            return false;
        }
    }

    //<------Getters and Setters----->
    public boolean estaVivo() {
        return hpActual > 0;
    }

    public void setHpActual(int hpActual) {
        // mínimo 0
        if (hpActual < 0) {
            this.hpActual = 0;
        }

        // máximo hpBase
        else if (hpActual > hpBase) {
            this.hpActual = hpBase;
        }

        else {
            this.hpActual = hpActual;
        }
    }

    public int getUltimoDanio() {
        return ultimoDanio;
    }

    public void setUltimoDanio(int ultimoDanio) {
        this.ultimoDanio = ultimoDanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo.toString();
    }
    public TipoCarta getTipoE(){
        return tipo;
    }

    public void setTipo(TipoCarta tipo) {
        this.tipo = tipo;
    }

    public String getRareza() {
        return rareza.toString();
    }

    public void setRareza(Rareza rareza) {
        this.rareza = rareza;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public int getAtkBase() {
        return atkBase;
    }

    public void setAtkBase(int atkBase) {
        this.atkBase = atkBase;
    }

    public int getDefBase() {
        return defBase;
    }

    public void setDefBase(int defBase) {
        this.defBase = defBase;
    }

    public int getSpdBase() {
        return spdBase;
    }

    public void setSpdBase(int spdBase) {
        this.spdBase = spdBase;
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

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", tipo=" + tipo +
                ", rareza=" + rareza +
                ", asset='" + asset + '\'' +
                ", hpBase=" + hpBase +
                ", atkBase=" + atkBase +
                ", defBase=" + defBase +
                ", spdBase=" + spdBase +
                ", hpActual=" + hpActual +
                ", atkActual=" + atkActual +
                ", defActual=" + defActual +
                ", spdActual=" + spdActual +
                ", movimientos=" + Arrays.toString(movimientos) +
                '}';
    }


    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public int getHpActual() {
        return hpActual;
    }
}
