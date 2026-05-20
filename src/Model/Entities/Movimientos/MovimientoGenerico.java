package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;
import Model.Entities.Movimientos.Creados.Movimiento;

public class MovimientoGenerico extends Movimiento {

    public MovimientoGenerico(String nombre) {
        super(nombre, 0);
    }

    @Override
    public int usar(Carta aliado, Carta enemigo) {
        // Movimiento genérico: no hace daño ni efectos
        return 0;
    }
}
