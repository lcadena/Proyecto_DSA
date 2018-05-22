package Proyecto;

import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class Mundo {

    public Mundo() {

    }
    ///creamos la lista usuarios
    public  HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    public List<Escenario> listaEscenarios = new ArrayList<>();

    //Funcion Crear Usuario
    public void crearEscenario(Escenario a) {


            listaEscenarios.add (a);


    }
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

    public Escenario consultarEscenario(String nombre){
        int i = 0;
        boolean a = false;
        while (a == false){
            if (nombre.equals(nombre)){
                a = true;
            }
            else
                i++;

        }

        return listaEscenarios.get(i);// si no encuentra el nombre retorna un null
    }




    public int eliminarObjeto(Usuario e,String nombreobj){

        int y =9;
        Objeto f = new Objeto();
        f = e.getObjeto(nombreobj);
        if (f == null)
            y=-1;
        else {
        e.miInventario.remove(f);
            y =0;}

            return y;
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
    //Transferiri objetos
    public void tranferirObjetosentreUsuarios(Usuario u, Usuario e, Objeto o){
        u.miInventario.remove(o);
        e.miInventario.add(o);

    }
}
