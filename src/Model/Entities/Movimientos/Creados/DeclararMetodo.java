package Model.Entities.Movimientos.Creados;

// Pertenece a Interfaz

import Model.Entities.Cartas.Carta;

public class DeclararMetodo extends Movimiento {

    public DeclararMetodo() {
        super("DeclararMetodo", 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffDef(aliado, 10);

        return 0;
    }

}

