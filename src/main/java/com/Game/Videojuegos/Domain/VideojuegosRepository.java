package com.Game.Videojuegos.Domain;

import java.util.List;

public interface VideojuegosRepository {

    public List<Videojuego> getAll();

    public Videojuego getVideojuegoFromName(String nombre);

    public void addVideojuego(Videojuego videojuego);

    public void actualizarPrecio(Videojuego videojuego, int precio);

    public void deleteVideojuego(String nombre);

}
