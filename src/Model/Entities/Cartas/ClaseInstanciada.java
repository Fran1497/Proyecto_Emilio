package Model.Entities.Cartas;

// Mov1: CrearInstancia   Mov2: CopiarAtributos
// Pertenece a ClaseInstanciada

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class ClaseInstanciada extends Carta {

    public ClaseInstanciada() {
        super("ClaseInstanciada", 85, 40, 12, 30, TipoCarta.OBJETO, Rareza.COMUN);
        this.movimientos[0] = new CrearInstancia();
        this.movimientos[1] = new CopiarAtributos();
    }
}

