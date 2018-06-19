package DAOs;

import Proyecto.Usuario;

import java.sql.*;

public class DAO_UsuarioImpl{

    public DAO_UsuarioImpl() {
    }

    /*     public boolean loguinUsuario(String nombreUsuario, String contraseña) throws SQLException {
            boolean loguin = false;
            Usuario u = new Usuario(nombreUsuario, contraseña);
            u.setPassword(contraseña);
            if (u.getNombre().equals(nombreUsuario) && u.getPassword().equals(contraseña)) {
                System.out.println("Usuario existente");
                return true;

            }
            return false;
        }

        /////metodo INSERT
       public boolean registroUsuario(Usuario u) throws SQLException {
            boolean registro = false;
            Connection conn;
            PreparedStatement ps = null;
            String query = "INSERT INTO usuarios VALUES (?,?,?)";
            try {
                ps = ConnBBDD.conn.prepareStatement(query);
                ps.setInt(1, u.getIdUsuario());
                ps.setString(2, u.getNombre());
                ps.setString(3, u.getPassword());
                ps.executeUpdate();
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
        }*/
    //Metodos INSERT
    public boolean registroUsuario(Usuario u) throws SQLException {
        boolean registro = false;
        if (usuarioenBBDD(u)){
            return registro;
        } else {
            Connection conn;
            PreparedStatement ps = null;
            //String query = "INSERT INTO usuarios VALUES (?,?,MD5(?))";
            String query = "INSERT INTO usuarios VALUES (?,?,?,?,?,?)";
            try {
                ps = ConnBBDD.conn.prepareStatement(query);
                ps.setInt(1, u.getIdUsuario());
                ps.setString(2, u.getNombre());
                ps.setString(3, u.getPassword());
                ps.setInt(4, u.getPosX());
                ps.setInt(5, u.getPosY());
                ps.setString(6, u.getNombreEscenario());
                ps.executeUpdate();
                System.out.println("Usuario " + u.getNombre() + " registrado correctamente");
                // nullpointer
                registro = true;

            } catch (SQLException e) {
                System.out.println("Error en el registro");
                e.printStackTrace();
            } finally {
                try {
                    ps.close();
                    // release connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return registro;
    }

    /////metodo SELECT
    public Usuario consultarUsuario(String nombre) throws SQLException{
        Connection conn;
        Usuario u = new Usuario();
        String query = "SELECT * FROM usuarios WHERE nombreUsuario='" + nombre + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            //u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombreUsuario"));
            u.setPassword(rs.getString("contraseña"));
            System.out.println("Usuario: " + u.getNombre() + " con contraseña: " + u.getPassword() );
        }
        rs.close();
        stm.close();
        return u;

    }
    //funcion que devuelve info de usuario
    public Usuario infoUserconEscenario(String nombreUsuario) throws SQLException{
       Usuario u = new Usuario() ;
       String query = "SELECT * FROM usuarios WHERE nombreUsuario='" + nombreUsuario + "'";
       Statement statement = ConnBBDD.conn.createStatement();
       ResultSet rs = statement.executeQuery(query);
       if (rs.next()) {
           u.setIdUsuario(rs.getInt("idUsuario"));
           u.setNombre(rs.getString("nombreUsuario"));
           u.setPassword(rs.getString("contraseña"));
           u.setPosX(rs.getInt("posX"));
           u.setPosY(rs.getInt("posY"));
           u.setNombreEscenario(rs.getString("nombreEscenario"));
           System.out.println("Usuario " + nombreUsuario + " en la posición " + u.getPosX() + " " + u.getPosY() + " en el escenario " + u.getNombreEscenario());
       } else {
           System.out.println("Usuario inexistente");
       }
       rs.close();
       statement.close();
       return u;
    }

    public boolean usuarioenBBDD(Usuario u) throws SQLException{
        boolean consulta = false;
        String query = "SELECT * FROM usuarios WHERE nombreUsuario='" + u.getNombre() + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            consulta = true;
            System.out.println("Usuario " + u.getNombre() + " ya esta registrado, inicie sesion para acceder");
        }
        rs.close();
        stm.close();
        return consulta;
    }

    public boolean autentificarUsuario(String nombre, String contraseña) throws SQLException {
        boolean autentificar = false;
        Statement stm = null;
        ResultSet rs = null;
            try {
                stm = ConnBBDD.conn.createStatement();
                String query = "SELECT * FROM usuarios WHERE nombreUsuario='" + nombre + "' AND contraseña='" + contraseña + "'";
                rs = stm.executeQuery(query);
                if (rs.next()) {
                    autentificar = true;
                    System.out.println("Bienvenido");
                } else {
                    System.out.println("Usuario  no encontrado, registrese");
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
            finally {
                try {
                    rs.close();
                    stm.close();
                    // release connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(autentificar);
        return autentificar;

    }

    //metodo DELETE
    public boolean eliminarUsuario(Usuario u){
        boolean eliminar = false;
        Statement stm = null;
        Connection conn;
        String query = "DELETE FROM usuarios WHERE nombreUsuario='" + u.getNombre() + "'";
        try {
            stm = ConnBBDD.conn.createStatement();
            stm.execute(query);
            eliminar = true;
            System.out.println("Usuario eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error eliminando user");
            e.printStackTrace();
        }
        return eliminar;
    }

    //metodo UPDATE
    public boolean updatePassword(String nombreUsuario, String contraseña) throws SQLException {
        Statement stm = ConnBBDD.conn.createStatement();
        boolean updateP = false;
        try {
            String query = "UPDATE usuarios SET contraseña='" + contraseña + "' where nombreUsuario='" + nombreUsuario + "'";
            stm.execute(query);
            updateP = true;
            System.out.println("Contraseña modificada correctamente");
        } catch (SQLException e) {
            System.out.println("Error modificando contraseña");
            e.printStackTrace();
        }
        return updateP;
    }

}
