package Model.Entities.Movimientos.Creados;

// Pertenece a Interfaz

import Model.Entities.Cartas.Carta;

public class ImplementarMetodo extends Movimiento {

    public ImplementarMetodo() {
        super("ImplementarMetodo", 10);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {

        efectoService.aplicarBuffAtk(aliado, 20);

        return 0;
    }

}
