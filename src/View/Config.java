package View;

public class Config {
    public static final int WindowSizeX = 800;
    public static final int WindowSizeY = 500;
    private int tamaniomazo = 6;
    private int preciosobresC = 10;
    private int preciosobresR = 20;
    private int preciosobresE = 30;
    private int preciosobresL = 40;
    private int cantidadDeCartasSobre = 5;

    public int getTamaniomazo(){
        return tamaniomazo;
    }

    public void setTamaniomazo(int tamaniomazo) {
        this.tamaniomazo = tamaniomazo;
    }

    public int getPreciosobresC() {
        return preciosobresC;
    }

    public void setPreciosobresC(int preciosobresC) {
        this.preciosobresC = preciosobresC;
    }

    public int getPreciosobresR() {
        return preciosobresR;
    }

    public void setPreciosobresR(int preciosobresR) {
        this.preciosobresR = preciosobresR;
    }

    public int getPreciosobresE() {
        return preciosobresE;
    }

    public void setPreciosobresE(int preciosobresE) {
        this.preciosobresE = preciosobresE;
    }

    public int getPreciosobresL() {
        return preciosobresL;
    }

    public void setPreciosobresL(int preciosobresL) {
        this.preciosobresL = preciosobresL;
    }

    public int getCantidadDeCartasSobre() {
        return cantidadDeCartasSobre;
    }

    public void setCantidadDeCartasSobre(int cantidadDeCartasSobre) {
        this.cantidadDeCartasSobre = cantidadDeCartasSobre;
    }
}
