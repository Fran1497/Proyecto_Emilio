package Model.Persistence.Impl;

import Model.Entities.Cartas.Carta;
import Model.Entities.Rareza;
import Model.Entities.TipoCarta;
import Model.Entities.mazos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOImpl implements DAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/Database_Dual";
    private static final String usuario = "postgres";
    private static final String password = "root";

    public Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, usuario, password);
            System.out.println("Conexión exitosa a PostgreSQL.");
        } catch (SQLException ex) {
            System.err.println("Error al conectar con la base de datos:");
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }


    @Override
    public int insertarCartas(Carta car) {

        int filas = 0;

        try (Connection conexion = getConexion()) {

            String sql = "INSERT INTO Dual.cartas (nombre, tipo, rareza, asset, hp_base, atk_base, def_base, spd_base) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, car.getNombre());
            ps.setString(2, car.getTipo());      // Enum → String
            ps.setString(3, car.getRareza());    // Enum → String
            ps.setString(4, car.getAsset());
            ps.setInt(5, car.getHpBase());
            ps.setInt(6, car.getAtkBase());
            ps.setInt(7, car.getDefBase());
            ps.setInt(8, car.getSpdBase());

            filas = ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filas;
    }

    @Override
    public List<Carta> mostrarCartasT() {
        List<Carta> lista = new ArrayList<>();

        try (Connection conexion = getConexion()) {

            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Dual.cartas;");

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String rareza = rs.getString("rareza");
                String asset = rs.getString("asset");
                int hp = rs.getInt("hp_base");
                int atk = rs.getInt("atk_base");
                int def = rs.getInt("def_base");
                int spd = rs.getInt("spd_base");

                // Crear una carta concreta usando clase anónima
                Carta car = new Carta(nombre, hp, atk, def, spd,
                        TipoCarta.valueOf(tipo),
                        Rareza.valueOf(rareza),
                        asset) {};

                car.setId(id);

                lista.add(car);
            }

            rs.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public List<mazos> listarMazos() {

        List<mazos> lista = new ArrayList<>();

        String sql = "SELECT id, nombre, fecha_creacion FROM dual.mazos";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                LocalDateTime fecha = rs.getTimestamp("fecha_creacion").toLocalDateTime();

                mazos m = new mazos(id, nombre, fecha, new ArrayList<>());
                lista.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public List<Carta> obtenerCartasDeMazo(int idMazo) {

        List<Carta> cartas = new ArrayList<>();

        String sql =
                "SELECT Carta.id, Carta.nombre, Carta.tipo, Carta.rareza, Carta.asset, " +
                        "Carta.hp_base, Carta.atk_base, Carta.def_base, Carta.spd_base " +
                        "FROM dual.Carta " +
                        "JOIN dual.mazo_cartas ON Carta.id = mazo_cartas.id_carta " +
                        "WHERE mazo_cartas.id_mazo = ?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idMazo);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Carta carta = new Carta(
                            rs.getString("nombre"),
                            rs.getInt("hp_base"),
                            rs.getInt("atk_base"),
                            rs.getInt("def_base"),
                            rs.getInt("spd_base"),
                            TipoCarta.valueOf(rs.getString("tipo")),
                            Rareza.valueOf(rs.getString("rareza")),
                            rs.getString("asset")
                    ) {};

                    carta.setId(rs.getInt("id"));

                    cartas.add(carta);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cartas;
    }
    @Override
    public int insertarCartaEnMazo(int idMazo, int idCarta) {

        int filas = 0;

        String sql = "INSERT INTO dual.mazo_cartas (id_mazo, id_carta) VALUES (?, ?)";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idMazo);
            ps.setInt(2, idCarta);

            filas = ps.executeUpdate();

        } catch (SQLException ex) {

            // Si intenta meter una carta duplicada en el mismo mazo
            if (ex.getSQLState().equals("23505")) {
                System.out.println("La carta ya está en este mazo.");
            } else {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return filas;
    }
    @Override
    public int insertarMazo(mazos m) {

        int idGenerado = -1;

        String sql = "INSERT INTO dual.mazos (nombre) VALUES (?) RETURNING id";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idGenerado = rs.getInt("id");
                    m.setId(idGenerado); // opcional, pero útil
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idGenerado;
    }









}