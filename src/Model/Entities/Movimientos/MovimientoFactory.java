package Model.Entities.Movimientos;

public class MovimientoFactory {


    public static Movimiento crearMovimientoDesdeNombre(String nombre) {
        try {
            String ruta = "Model.Entities.Movimientos." + nombre;
            Class<?> clazz = Class.forName(ruta);
            return (Movimiento) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            System.err.println("No se pudo instanciar el movimiento: " + nombre);
            return new MovimientoGenerico(nombre);
        }
    }


}

