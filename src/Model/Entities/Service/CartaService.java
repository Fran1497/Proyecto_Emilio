package Model.Entities.Service;


import Model.Entities.Cartas.Carta;
import Model.Entities.Rareza;
import Model.Persistence.Impl.DAO;
import Model.Persistence.Impl.DAOImpl;

import java.util.ArrayList;
import java.util.List;

public class CartaService {
    private DAO dao = new DAOImpl();

    public boolean guardarNuevaCarta(Carta carta) {
        // --- REGLAS DE NEGOCIO (Lógica del juego) ---

        // 1. Validar que la carta tenga movimientos asignados
        if (carta.getMovimientos() == null || carta.getMovimientos().length < 2) {
            System.out.println("Error: Una carta debe tener al menos 2 movimientos.");
            return false;
        }

        // 2. Validar que los stats no sean absurdos (ejemplo: balanceo)
        if (carta.getHpBase() <= 0 || carta.getAtkBase() > 500) {
            System.out.println("Error: Stats de carta fuera de rango permitido.");
            return false;
        }

        // 3. Si pasa las reglas, llamamos al DAO
        int resultado = dao.insertarCartas(carta);

        return resultado > 0; // Si se insertó al menos 1 fila, es exitoso
    }

    public Carta buscarPorId(int id) {
        if (id <= 0) return null;
        return dao.obtenerCartaPorId(id);
    }

    public List<Carta> buscarPorRareza(String rareza) {
        try {
            Rareza.valueOf(rareza.toUpperCase());
            return dao.obtenerCartasPorRareza(rareza);
        } catch (IllegalArgumentException e) {
            System.out.println("Esa rareza no existe en el juego.");
            return new ArrayList<>();
        }
    }

    public List<Carta> buscarPorMazo(int idMazo) {
        return dao.obtenerCartasDeMazo(idMazo);
    }
}
