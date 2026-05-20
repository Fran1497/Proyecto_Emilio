package Model.Entities.Cartas;

// Mov1: Sobrecarga   Mov2: Sobrescritura
// Pertenece a Polimorfismo

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Polimorfismo extends Carta {

    public Polimorfismo() {
        super("Polimorfismo", 85, 45, 10, 45, TipoCarta.OBJETO, Rareza.EPICA);
        this.movimientos[0] = new Sobrecarga();
        this.movimientos[1] = new Sobrescritura();
    }
}

