package com.Game.Videojuegos.Infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static Connection con;


    public static Connection getCon() {

        try {
            con= DriverManager.getConnection("jdbc:mysql://futbol-database.c0lchhsfw5fs.us-west-2.rds.amazonaws.com/GameBD" ,"admin","servidor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;

    }
}
