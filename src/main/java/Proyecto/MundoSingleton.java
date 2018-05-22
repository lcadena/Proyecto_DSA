package Proyecto;

public class MundoSingleton {
    private static MundoSingleton instance;

    //private List<Track> tracks;
    private  Mundo mundo;
    private MundoSingleton() {
        mundo = new Mundo();
    }

    public Mundo getMundo() {
        return mundo;
    }

    public static MundoSingleton getInstance(){
        if (instance==null) instance = new MundoSingleton();
        return instance;
    }
}
