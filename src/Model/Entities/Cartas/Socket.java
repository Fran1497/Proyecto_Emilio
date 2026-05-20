package Model.Entities.Cartas;

// Mov1: Conexion   Mov2: Desconexion
// Pertenece a Socket

import Model.Entities.Movimientos.Creados.*;
import Model.Entities.TipoCarta;
import Model.Entities.Rareza;

public class Socket extends Carta {

    public Socket() {
        super("Socket", 85, 50, 12, 35, TipoCarta.RED, Rareza.RARA);
        this.movimientos[0] = new Conexion();
        this.movimientos[1] = new Desconexion();
    }
}

