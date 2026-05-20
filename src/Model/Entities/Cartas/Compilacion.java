package Model.Entities.Cartas;

// Mov1: Compilar   Mov2: GenerarBytecode
// Pertenece a Compilacion

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Compilacion extends Carta {

    public Compilacion() {
        super("Compilacion", 90, 45, 12, 35, TipoCarta.COMPILADOR, Rareza.COMUN);
        this.movimientos[0] = new Compilar();
        this.movimientos[1] = new GenerarBytecode();
    }
}

