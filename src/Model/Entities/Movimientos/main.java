package Model.Entities.Movimientos;

import Model.Entities.Cartas.Carta;
import Model.Entities.Cartas.FORLoop;
import Model.Entities.Cartas.TryCatch;
import Model.Persistence.Impl.DAOImpl;

public class main {
    public static void main(String[] args) {
        DAOImpl dao = new DAOImpl();
        Carta forloop = new FORLoop(); //Contiene OverFlow y Iteracion Constante
        Carta trycatch = new TryCatch(); //Contiene throw y capturar error
        System.out.println();
        forloop.usarAtaque(0,trycatch);
        forloop.usarAtaque(0,trycatch);
    }
}
