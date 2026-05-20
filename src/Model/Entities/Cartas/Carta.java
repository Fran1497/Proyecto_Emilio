package Model.Entities.Cartas;

import Model.Entities.Movimientos.Creados.Movimiento;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;

import java.util.Arrays;

public abstract class Carta {

    // ============================
    //      ESTADOS TEMPORALES
    // ============================

    // Aturdimiento por turnos (nuevo sistema)
    private int turnosAturdido = 0;

    // Evasión temporal (0–100%)
    private int evasion = 0;

    // Reducción de daño temporal (0–100%)
    private int damageReduction = 0;


    // ============================
    //      DATOS DE LA CARTA
    // ============================

    private String nombre;
    private int id;
    private TipoCarta tipo;
    private Rareza rareza;
    private String asset;

    // Stats base
    private int hpBase;
    private int atkBase;
    private int defBase;
    private int spdBase;

    // Stats actuales
    private int hpActual;
    private int atkActual;
    private int defActual;
    private int spdActual;

    // Movimientos
    public Movimiento[] movimientos;

    // Último daño recibido
    private int ultimoDanio;


    // ============================
    //      CONSTRUCTOR
    // ============================

    public Carta(String nombre, int hp, int atk, int def, int spd, TipoCarta tipo, Rareza rareza) {
        this.nombre = nombre;
        this.hpBase = hp;
        this.atkBase = atk;
        this.defBase = def;
        this.spdBase = spd;

        this.atkActual = atk;
        this.defActual = def;
        this.spdActual = spd;
        this.hpActual = hp;

        this.movimientos = new Movimiento[2];

        this.rareza = rareza;
        this.tipo = tipo;

        restaurarStats();
    }


    // ============================
    //      RESTAURAR ESTADOS
    // ============================

    public void restaurarStats() {
        setHpActual(hpBase);
        atkActual = atkBase;
        defActual = defBase;
        spdActual = spdBase;

        clearBuffs();
        limpiarEfectosTemporales();
    }

    public void clearBuffs() {
        this.atkActual = this.atkBase;
        this.defActual = this.defBase;
        this.spdActual = this.spdBase;
    }

    // 🔥 AHORA SOLO SE USA EL NUEVO SISTEMA DE ATURDIMIENTO
    public void limpiarEfectosTemporales() {

        // Evasión dura 1 turno
        this.evasion = 0;

        // Reducción de daño dura 1 turno
        this.damageReduction = 0;

        // Aturdimiento por turnos
        if (this.turnosAturdido > 0) {
            this.turnosAturdido--;
        }
    }


    // ============================
    //      BUFFS ESPECIALES
    // ============================

    public void copyRandomBuffFrom(Carta enemigo) {

        java.util.List<String> buffs = new java.util.ArrayList<>();

        if (enemigo.getAtkActual() > enemigo.getAtkBase()) buffs.add("ATK");
        if (enemigo.getDefActual() > enemigo.getDefBase()) buffs.add("DEF");
        if (enemigo.getSpdActual() > enemigo.getSpdBase()) buffs.add("SPD");

        if (buffs.isEmpty()) return;

        java.util.Random rd = new java.util.Random();
        String buffElegido = buffs.get(rd.nextInt(buffs.size()));

        switch (buffElegido) {
            case "ATK":
                this.setAtkActual(this.getAtkActual() + (int)(this.getAtkBase() * 0.10));
                break;

            case "DEF":
                this.setDefActual(this.getDefActual() + (int)(this.getDefBase() * 0.10));
                break;

            case "SPD":
                this.setSpdActual(this.getSpdActual() + (int)(this.getSpdBase() * 0.10));
                break;
        }
    }


    // ============================
    //      ATAQUES
    // ============================

    public boolean usarAtaque(int slot, Carta enemigo) {
        if (slot >= 0 && slot < movimientos.length) {
            this.movimientos[slot].usar(this, enemigo);
            return true;
        }
        return false;
    }


    // ============================
    //      GETTERS / SETTERS
    // ============================

    public boolean estaVivo() {
        return hpActual > 0;
    }

    public void setHpActual(int hpActual) {
        if (hpActual < 0) this.hpActual = 0;
        else if (hpActual > hpBase) this.hpActual = hpBase;
        else this.hpActual = hpActual;
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

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public TipoCarta getTipoE() {
        return tipo;
    }

    public String getRareza() {
        return rareza.toString();
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

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getHpActual() {
        return hpActual;
    }

    // 🔥 NUEVO SISTEMA DE ATURDIMIENTO
    public int getTurnosAturdido() {
        return turnosAturdido;
    }

    public void setTurnosAturdido(int turnosAturdido) {
        this.turnosAturdido = turnosAturdido;
    }

    public void setEvasion(int evasion) {
        if (evasion < 0) evasion = 0;
        if (evasion > 100) evasion = 100;
        this.evasion = evasion;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setDamageReduction(int damageReduction) {
        if (damageReduction < 0) damageReduction = 0;
        if (damageReduction > 100) damageReduction = 100;
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
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
}
