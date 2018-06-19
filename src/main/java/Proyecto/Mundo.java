package Proyecto;

import DAOs.ConnBBDD;
import DAOs.DAO_ObjetoImpl;
import DAOs.DAO_UsuarioImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mundo {

    ///creamos la lista usuarios
    public  HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    public List<Escenario> listaEscenarios = new ArrayList<>();
    //instanciamos los usuarios y objetos del DAO
    DAO_UsuarioImpl usuario = new DAO_UsuarioImpl();
    DAO_ObjetoImpl objeto = new DAO_ObjetoImpl();
    ConnBBDD conn = new ConnBBDD();
    public Mundo() throws SQLException {

    }
    //loguear un usuario - devuelve true si esta en BBDD
    public boolean daoValidarUsuario(String nombre, String contraseña)throws SQLException{
        conn.conectar();
        boolean r = usuario.autentificarUsuario(nombre, contraseña);
        conn.desconectar();
        return r;
    }
    public boolean daoInicioSesionUsuario(LogIn login)throws SQLException{
        conn.conectar();
        boolean r = usuario.autentificarUsuario(login.getNombre(), login.getPassword());
        conn.desconectar();
        return r;
    }
    //Si no esta en BBDD registra tu usuario
    public boolean daoRegistroUsuario(Usuario u) throws SQLException{
        conn.conectar();
        boolean r = usuario.registroUsuario(u);
        conn.desconectar();
        return r;
    }
    //Elimina usaurios por el nombre
    public boolean daoEliminarUsuario(Usuario u) throws SQLException{
        conn.conectar();
        boolean r = usuario.eliminarUsuario(u);
        conn.desconectar();
        return r;
    }
    //Cosulta si el usuario esta en la BBDD
    public Usuario daoConsultarUsuario(String nombre)throws SQLException{
        Usuario u;
        conn.conectar();
        u = usuario.consultarUsuario(nombre);
        conn.desconectar();
        System.out.println(u);

        return u;
    }
    public Usuario daoInfoUserconEcenario(String nombre)throws SQLException{
        Usuario u;
        conn.conectar();
        u = usuario.infoUserconEscenario(nombre);
        conn.desconectar();
        System.out.println(u);

        return u;
    }
    //Elimina usaurios por el nombre
    public boolean daoUpdatePasswordUsuario(String nombre, String contraseña) throws SQLException{
        conn.conectar();
        boolean r = usuario.updatePassword(nombre,contraseña);
        conn.desconectar();
        return r;
    }

    public boolean daoAñadirObjeto(Objeto o) throws SQLException{
        conn.conectar();
        boolean r = objeto.añadirObjeto(o);
        conn.desconectar();
        return r;
    }

    public List<Objeto> listaObjetosdeUsuario(String nombre) throws SQLException{
        Usuario u = daoConsultarUsuario(nombre);
        conn.conectar();
        List<Objeto> objetos = objeto.listarInventarioUsuario(u);
        conn.desconectar();
        return objetos;
    }

    public Objeto daoConsultarObjeto(int id)throws SQLException{
        Objeto o;
        conn.conectar();
        o = objeto.consultarObjeto(id);
        conn.desconectar();
        return o;
    }

    public Objeto daoConsultarObjetoNom(String nombre)throws SQLException{
        Objeto o;
        conn.conectar();
        o = objeto.consultarObjetoNom(nombre);
        conn.desconectar();
        return o;
    }
    public boolean daoElegirObjeto(String nombre) throws SQLException{
        conn.conectar();
        boolean r = objeto.elegirObjeto(nombre);
        conn.desconectar();
        return r;
    }

    public boolean daoEliminarObjeto(Objeto o) throws SQLException{
        conn.conectar();
        boolean r = objeto.eliminarObjeto(o);
        conn.desconectar();
        return r;
    }

    public List<Objeto> daoConsultarObjetosUsuario(String nombre) throws SQLException{
        Usuario u = daoConsultarUsuario(nombre);
        conn.conectar();
        List<Objeto> inventariodeUsuario = objeto.listarInventarioUsuario(u);
        System.out.println("llego1");
        conn.desconectar();
        return inventariodeUsuario;
    }

    public Usuario posicionyEscenariodeUsuario (String nombreUsuario) throws SQLException {
        conn.conectar();
        Usuario u = usuario.infoUserconEscenario(nombreUsuario);
        conn.desconectar();
        return u;
    }

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




/*    public int eliminarObjeto(Usuario e,String nombreobj){

        int y =9;
        Objeto f = new Objeto();
        f = e.getObjeto(nombreobj);
        if (f == null)
            y=-1;
        else {
        e.miInventario.remove(f);
            y =0;}

            return y;
    }*/
/*    ///funcion anadir objeto a usuario
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

    }*/
}
