package Model.Persistence.Impl;

import Model.Entities.Cartas.Carta;
import Model.Entities.mazos;

import java.util.List;

public interface DAO {

    int insertarCartas(Carta car);

    List<Carta> mostrarCartasT();

    List<mazos> listarMazos();

    List<Carta> obtenerCartasDeMazo(int idMazo);

    int insertarCartaEnMazo(int idMazo, int idCarta);

    int insertarMazo(mazos m);

    Carta obtenerCartaPorId(int id);

    List<Carta> obtenerCartasPorRareza(String rareza);

    List<Carta> abrirSobreComun(int cantidad);

    List<Carta> abrirSobreRaro(int cantidad);

    List<Carta> abrirSobreEpico(int cantidad);

    List<Carta> abrirSobreLegendario(int cantidad);

    
}
