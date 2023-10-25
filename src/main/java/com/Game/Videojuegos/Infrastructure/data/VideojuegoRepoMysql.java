package com.Game.Videojuegos.Infrastructure.data;

import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Domain.VideojuegosRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public void addVideojuego() {

    }

    @Override
    public void actualizarPrecio() {

    }

    @Override
    public void deleteVideojuego() {

    }
}
