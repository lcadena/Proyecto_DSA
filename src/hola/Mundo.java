package hola;

import hola.Usuario;
import hola.Objeto;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Mundo {

    public Mundo() {

    }
    ///creamos la lista usuarios
    public  HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();

    //Funcion Crear Usuario
    public boolean crearUsuario(Usuario u) {
        if (listaUsuarios.get(u.getNombre()) != null)
            return false;
        else{
            listaUsuarios.put(u.getNombre(), u);

            return true;}
    }

    //Funcion Eliminar Usuario
    public boolean eliminarUsuario(String nombre) {
        listaUsuarios.remove(nombre);
        return true;
    }

    //Funcion Consultar Usuario
    public Usuario consultarUsuario(String nombre){
        return listaUsuarios.get(nombre);// si no encuentra el nombre retorna un null
    }

    ///funcion anadir objeto a usuario
    public void añadirObjeto(Usuario u, Objeto o){
        u.miInventario.add(o);
    }
    //Funcion Consultar lista de objetos
    public LinkedList consultarObjetos(Usuario u){
        return u.miInventario;
    }

    //Funcion Consultar lista de objetos de usuario
    public LinkedList consultarObjetosdeUsuario(Usuario u, String nombreObjeto){
        return u.miInventario;
    }
}
