package Model.Entities.Movimientos;

import Model.Entities.Movimientos.Creados.Movimiento;

public class MovimientoFactory {


    public static Movimiento crearMovimientoDesdeNombre(String nombre) {
        try {
            String ruta = "Model.Entities.Movimientos.Creados." + nombre;
            Class<?> clazz = Class.forName(ruta);
            return (Movimiento) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            System.err.println("No se pudo instanciar el movimiento: " + nombre);
            return new MovimientoGenerico(nombre);
        }
    }



}

