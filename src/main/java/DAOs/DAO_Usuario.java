package DAOs;

import Proyecto.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface DAO_Usuario {
    public boolean loguinUsuario(String nombre, String password) throws SQLException;
    public boolean registroUsuario(Usuario u);
    public List<Usuario> listaUsuarios(String nombre, String password);
    public boolean autentificarUsuario(String nombre, String password);
    public boolean eliminarUsuario(Usuario u);

}
