package Model.Entities.Cartas;

// Mov1: Parsear   Mov2: ValidarArbol
// Pertenece a AnalisisSintactico

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class AnalisisSintactico extends Carta {

    public AnalisisSintactico() {
        super("AnalisisSintactico", 95, 50, 12, 30, TipoCarta.COMPILADOR, Rareza.EPICA);
        this.movimientos[0] = new Parsear();
        this.movimientos[1] = new ValidarArbol();
    }
}

