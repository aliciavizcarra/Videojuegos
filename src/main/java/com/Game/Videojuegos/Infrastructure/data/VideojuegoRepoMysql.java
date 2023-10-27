package com.Game.Videojuegos.Infrastructure.data;

import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Domain.VideojuegosRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoRepoMysql implements VideojuegosRepository {

    public Connection conexionDB = ConexionDB.getCon();

    @Override
    public List<Videojuego> getAll() {
        List <Videojuego> videojuegoList = new ArrayList<>();
        String consulta = "SELECT * FROM videojuegos";

        try {
            Statement stm = conexionDB.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while (rs.next()){
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int precio = rs.getInt("precio");

                videojuegoList.add(new Videojuego(nombre,categoria,precio));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return videojuegoList;
    }

    @Override
    public Videojuego getVideojuegoFromName(String nombre) {

        Videojuego videojuego = null;

        String consulta = "SELECT * FROM videojuegos WHERE nombre LIKE '" + nombre + "'";

        try {
            Statement stm = conexionDB.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while (rs.next()){
                String nombreVideojuego = rs.getString("nombre");
                String categoria =rs.getString("categoria");
                int precio = rs.getInt("precio");

                videojuego = new Videojuego(nombreVideojuego,categoria,precio);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return videojuego;

    }

    @Override
    public void addVideojuego(Videojuego videojuego) {

        String consulta = "INSERT INTO videojuegos (`nombre`, `categoria`, `precio`) VALUES (?, ?, ?)";


        try (PreparedStatement preparedStatement = conexionDB.prepareStatement(consulta)){
            preparedStatement.setString(1,videojuego.getNombre());
            preparedStatement.setString(2,videojuego.getCategoria());
            preparedStatement.setInt(3,videojuego.getPrecio());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarPrecio(Videojuego videojuego, int precio) {

    String consulta = "UPDATE videojuegos SET precio=" + precio + " WHERE nombre LIKE '" + videojuego.getNombre() + "'";

        try {
            Statement stm = conexionDB.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteVideojuego(String nombre){

        String consulta = "DELETE FROM videojuegos WHERE nombre LIKE '"+ nombre + "'";

        try {
            Statement stm = conexionDB.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
