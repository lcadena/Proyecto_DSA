package DAOs;

import Proyecto.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_UsuarioImpl implements DAO_Usuario {

    public boolean loguinUsuario(String nombre, String password) throws SQLException {
        boolean loguin = false;
        Usuario u = new Usuario(nombre, password);
        if (u.getNombre().equals(nombre)) {
            System.out.println("El usuario ya existe");
            loguin = true;
        }
        return false;
    }
    /////metodo INSERT
    public boolean registroUsuario(Usuario u){
        boolean registro = false;
        Connection conn = ConnBBDD.conectar();
        PreparedStatement ps = null;
        String query = "INSERT INTO usuario VALUES (?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPassword());
            // nullpointer
            registro = true;

        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
                // release connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registro;
    }

    /////metodo SELECT
    public List<Usuario> listaUsuarios(String nombre, String password){
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        String query = "SELECT * FROM usuario WHERE username='" + nombre + "' AND password='" + password + "'";
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                Usuario u = new Usuario(nombre, password);
                u.setNombre(rs.getString("nombre"));
                u.setPassword(rs.getString("password"));
                usuarios.add(u);
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean autentificarUsuario(String nombre, String password){
        boolean autentificar = false;
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        String query = "SELECT * FROM usuario WHERE username='" + nombre + "' AND password='" + password + "'";
        try {
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                autentificar = true;
            }
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }
        return autentificar;
    }
    //metodo DELETE
    public boolean eliminarUsuario(Usuario u){
        boolean eliminar = false;
        Statement stm = null;
        Connection conn = null;
        String query = "DELETE FROM Usuario WHERE username='" + u + "'";
        try {
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            stm.execute(query);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error eliminando user");
            e.printStackTrace();
        }
        return eliminar;
    }

}
