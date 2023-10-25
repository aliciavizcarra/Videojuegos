package com.Game.Videojuegos.Domain;

import java.util.List;

public interface VideojuegosRepository {

    public List<Videojuego> getAll();

    public Videojuego getVideojuegoFromName(String nombre);

    public void addVideojuego();

    public void actualizarPrecio();

    public void deleteVideojuego();

}
