package Model.Entities.Cartas;

// Mov1: Inicializar   Mov2: ConstruccionRapida
// Pertenece a Constructor

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Constructor extends Carta {

    public Constructor() {
        super("Constructor", 90, 35, 12, 25, TipoCarta.OBJETO, Rareza.COMUN);
        this.movimientos[0] = new Inicializar();
        this.movimientos[1] = new ConstruccionRapida();
    }
}

