package hola;

import hola.Usuario;
import hola.Objeto;
import java.util.Map;
import java.util.HashMap;

public class Mundo {

<<<<<<< HEAD
    public Mundo() {

    }
    ///creaamos la lista usuarios


    public  HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();

    public boolean crearUsuario(Usuario u) {

        listaUsuarios.put(u.getNombre(), u);

        return true;
=======
   // boolean añadirUsuario(Usuario dos) {
       // listaUsuarios.put("adios",dos);
        //parametro del main usuario

        
    //}
    public boolean crearUsuario(String nombre){
        int encontrado=0;

        for(int i=0; i<listaUsuarios.length;i++){
            if(listaUsuarios.Nombre==nombre){
            encontrado=1;
                Usuario.Nombre = nombre;
            }
        }
        return false;
>>>>>>> origin/master
    }
}
