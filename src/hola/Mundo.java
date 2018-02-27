package hola;

import hola.Usuario;
import hola.Objeto;
import java.util.Map;
import java.util.HashMap;

public class Mundo {

    public Mundo() {

    }
    ///creaamos la lista usuarios


    public  HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();

    public boolean crearUsuario(Usuario u) {

        listaUsuarios.put(u.getNombre(), u);

        return true;
    }
}
