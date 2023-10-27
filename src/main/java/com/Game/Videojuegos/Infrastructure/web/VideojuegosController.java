package com.Game.Videojuegos.Infrastructure.web;


import com.Game.Videojuegos.Application.VideojuegosCaseUses;
import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Infrastructure.data.VideojuegoRepoMysql;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideojuegosController {

     VideojuegosCaseUses videojuegosCaseUses;

    public VideojuegosController() {
        this.videojuegosCaseUses = new VideojuegosCaseUses(new VideojuegoRepoMysql());
    }

    @GetMapping("/videojuegos")
    public List<Videojuego> list (){
        List<Videojuego> videojuegoList = this.videojuegosCaseUses.getAll();
        return videojuegoList;
    }

    @GetMapping("/videojuegos/{nombre}")
    public Videojuego videojuego (@PathVariable String nombre){
        Videojuego videojuego = this.videojuegosCaseUses.getVideojuegoFromNombre(nombre);
        return videojuego;
    }

    @PostMapping("/videojuegos")
    public void agregarVideojuego(@RequestParam String nombre, @RequestParam String categoria, @RequestParam int precio){

        Videojuego videojuego = new Videojuego(nombre,categoria,precio);

        this.videojuegosCaseUses.addVideojuego(videojuego);

    }

    @PutMapping("/videojuegos/{nombre}")
    public void actualizarPrecio(@PathVariable String nombre, @RequestParam int precio){
        Videojuego videojuego1 = this.videojuegosCaseUses.getVideojuegoFromNombre(nombre);
        this.videojuegosCaseUses.actualizarPrecio(videojuego1,precio);
    }

    @DeleteMapping("/videojuegos/{nombre}")
    public void eliminarVideojuego(@PathVariable String nombre){
        this.videojuegosCaseUses.deleteVideojuego(nombre);
    }



}
