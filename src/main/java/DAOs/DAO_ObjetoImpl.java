package DAOs;

import Proyecto.Objeto;
import Proyecto.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_ObjetoImpl implements DAO_Objeto{

    /////metodo INSERT
    public boolean insertarObjeto(Objeto o){
        boolean insertar = false;
        Connection conn = ConnBBDD.conectar();
        PreparedStatement ps = null;
        String query = "INSERT INTO objetos VALUES (?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, o.getNombre());
            ps.setInt(2, o.getValor());
            // nullpointer
            insertar = true;

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
        return insertar;
    }

    public void insertarObjInventario (Usuario u, Objeto o){
        Connection conn = ConnBBDD.conectar();
        String query = "INSERT INTO miInventario VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, o.getNombre());
            ps.close();
            // nullpointer
        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }
    }

    //metodo DELETE
    public boolean eliminarObjeto(Objeto o){
        boolean eliminar = false;
        Statement stm = null;
        Connection conn = null;
        try {
            String query = "DELETE FROM objetos WHERE nombre='" + o.getNombre() + "'";
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            stm.execute(query);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error eliminando user");
            e.printStackTrace();
        }
        finally {
            try {
                stm.close();
                // release connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eliminar;
    }

    ////Metodo SELECT
    public boolean elegirObjeto(String nombre){
        boolean elegir = false;
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        String query = "SELECT * FROM objetos WHERE nombre='" + nombre + "'";
        try {
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                elegir = true;
            }
            rs.close();
            stm.close();

        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }
        return elegir;
    }

    public List<Objeto> listarInventarioUsuario(Usuario u){
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        String query = "SELECT objeto FROM miInventario WHERE usuario='" + u.getNombre() + "'";
        List<Objeto> objetos = new ArrayList<Objeto>();
        try {
            conn = ConnBBDD.conectar();
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                //objetos.add(elegirObjeto(rs.getString("nombre")));
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stm.close();
                rs.close();

                // release connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return objetos;
    }

}
