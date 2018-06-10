package Proyecto;

import java.sql.SQLException;

public class MundoSingleton {
    private static MundoSingleton instance;

    //private List<Track> tracks;
    private  Mundo mundo;
    private MundoSingleton() throws SQLException {
        mundo = new Mundo();
    }

    public Mundo getMundo() {
        return mundo;
    }

    public static MundoSingleton getInstance() throws SQLException {
        if (instance==null) instance = new MundoSingleton();
        return instance;
    }
}
