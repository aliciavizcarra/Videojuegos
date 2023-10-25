package com.Game.Videojuegos.Infrastructure.web;


import com.Game.Videojuegos.Application.VideojuegosCaseUses;
import com.Game.Videojuegos.Domain.Videojuego;
import com.Game.Videojuegos.Infrastructure.data.VideojuegoRepoMysql;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideojuegosController {

    VideojuegosCaseUses videojuegosCaseUses;

    public VideojuegosController(){
        this.videojuegosCaseUses = new VideojuegosCaseUses(new VideojuegoRepoMysql());
    }


    @GetMapping("/videojuegos")
    public List<Videojuego> list (){
        List<Videojuego> videojuegoList = this.videojuegosCaseUses.getAll();
        return videojuegoList;
    }



}
