package Model.Entities.Service;


import Model.Entities.Cartas.Carta;
import Model.Entities.Jugador;
import Model.Persistence.Impl.DAOImpl;
import View.Config;

import java.util.ArrayList;
import java.util.List;

public class SobreService {

    public List<Carta> comprarSobres(String rareza, Jugador jugador){
        Config config = new Config();
        DAOImpl miDao = new DAOImpl();
        List<Carta> cartas = new ArrayList<>();
        switch (rareza) {
            case "COMUN":
                if (jugador.getMonedas() >= config.getPreciosobresC()){
                    cartas = miDao.abrirSobreComun(config.getCantidadDeCartasSobre());
                }
                break;
            case "RARO":
                if (jugador.getMonedas() >= config.getPreciosobresR()){
                    cartas = miDao.abrirSobreRaro(config.getCantidadDeCartasSobre());
                }
                break;
            case "EPICO":
                if (jugador.getMonedas() >= config.getPreciosobresE()){
                    cartas = miDao.abrirSobreEpico(config.getCantidadDeCartasSobre());
                }
                break;
            case "LEGENDARIO":
                if (jugador.getMonedas() >= config.getPreciosobresL()){
                    cartas = miDao.abrirSobreLegendario(config.getCantidadDeCartasSobre());
                }
                break;
            default:
                System.out.println("Rareza desconocida");
                break;
        }
        return cartas;
    }
}
