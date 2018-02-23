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
    public boolean crearUsuario(String nombre){
        encontrado=0;
        for(int i=0; i<listaUsuarios.length;i++){
            if(listaUsuarios.Nombre==nombre){
            encontrado=1;
                Usuario.Nombre = nombre;
            }
        }
        return false;
    }
}
