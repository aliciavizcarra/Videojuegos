package com.Game.Videojuegos.Application;

import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Infrastructure.data.VideojuegoRepoMysql;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideojuegosCaseUsesTest {

    private VideojuegosCaseUses videojuegosCaseUses;

    public VideojuegosCaseUsesTest() {
        this.videojuegosCaseUses = new VideojuegosCaseUses(new VideojuegoRepoMysql());
    }

    @Test
    void getAll() {
        List<Videojuego> list = this.videojuegosCaseUses.getAll();
        assertEquals(5,list.size());
    }

    @Test
    void getVideojuegoFromNombre() {
       Videojuego videojuego = this.videojuegosCaseUses.getVideojuegoFromNombre("Starfield");
       assertEquals("Starfield",videojuego.getNombre());
        assertEquals("Acción",videojuego.getCategoria());
        assertEquals(45,videojuego.getPrecio());
    }

    @Test
    void addVideojuego() {
        Videojuego videojuego = new Videojuego("Starfield", "Accion", 45);
        this.videojuegosCaseUses.addVideojuego(videojuego);
        List<Videojuego> list = this.videojuegosCaseUses.getAll();
        assertEquals(5,list.size());
    }

    @Test
    void actualizarPrecio() {
        Videojuego videojuego = this.videojuegosCaseUses.getVideojuegoFromNombre("Valorant");
        int precio = 89;
        this.videojuegosCaseUses.actualizarPrecio(videojuego,precio);
        assertEquals(89,videojuego.getPrecio());
        //al ejecutar el test, tengo que actualizar la bd para que me funcione
    }

    @Test
    void deleteVideojuego(){
        List<Videojuego> list = this.videojuegosCaseUses.getAll();
        this.videojuegosCaseUses.deleteVideojuego("Valorant");
        assertEquals(4,list.size());
    }
}