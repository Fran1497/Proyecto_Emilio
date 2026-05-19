package Model.Entities.Service;

import Model.Entities.Cartas.Carta;

import java.util.List;
import java.util.Scanner;

import Model.Entities.mazos;
import Model.Persistence.Impl.DAOImpl;
import View.Config;

public class MazosService {
    private static Config config = new Config();
    private static final int tamaniomazo =config.getTamaniomazo();


    public List<Carta> mostrarMazos(int IdMazo){
        DAOImpl miDao = new DAOImpl();
        Scanner sc = new Scanner(System.in);
        List<Carta> cartas;

        miDao.listarMazos();
        cartas = miDao.obtenerCartasDeMazo(IdMazo);

        return cartas;
    }


    public boolean actualizarMazo(mazos Mazo){
        DAOImpl miDao = new DAOImpl();
        if (Mazo.getCartas().size() == tamaniomazo){
            miDao.insertarMazo(Mazo);
            return true;
        }else{
            return false;
        }
    }
}
