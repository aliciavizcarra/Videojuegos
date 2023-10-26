package com.Game.Videojuegos.Application;

import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Domain.VideojuegosRepository;

import java.util.ArrayList;
import java.util.List;

public class VideojuegosCaseUses {

    private VideojuegosRepository videojuegosRepository;


    public VideojuegosCaseUses(VideojuegosRepository videojuegosRepository) {
        this.videojuegosRepository = videojuegosRepository;
    }

    public List<Videojuego> getAll(){
        List <Videojuego> list = this.videojuegosRepository.getAll();
        return list;
    }

    public Videojuego getVideojuegoFromNombre(String nombre){
        return this.videojuegosRepository.getVideojuegoFromName(nombre);
    }

    public void addVideojuego(Videojuego videojuego){
        this.videojuegosRepository.addVideojuego(videojuego);
    }

    public void actualizarPrecio(Videojuego videojuego, int precio){
        this.videojuegosRepository.actualizarPrecio(videojuego,precio);
    }

    public void deleteVideojuego(String nombre){
        this.videojuegosRepository.deleteVideojuego(nombre);
    }





}
