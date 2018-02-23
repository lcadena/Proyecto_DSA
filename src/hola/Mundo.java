package hola;

import java.util.Map;
import java.util.HashMap;

public class Mundo {
    //Usuar uno = new Usuario();
    ///creaamos la lista usuarios
    Usuario dos;
    Map<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();

    boolean añadirUsuario(Usuario dos) {
        listaUsuarios.put("adios",dos);
        //parametro del main usuario
    }
}