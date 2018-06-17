package DAOs;

import Proyecto.Objeto;
import Proyecto.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_ObjetoImpl{
    public DAO_ObjetoImpl(){

    }

    //Metodos INSERT
    public boolean añadirObjeto(Objeto o) throws SQLException {
        boolean añadirO = false;
        if (objetoenBBDD(o)){
            return añadirO;
        } else {
            Connection conn;
            PreparedStatement ps = null;
            String query = "INSERT INTO objetos VALUES (?,?,?,?,?)";
            try {
                ps = ConnBBDD.conn.prepareStatement(query);
                ps.setInt(1, o.getIdObjeto());
                ps.setInt(2, o.getIdUsuario());
                ps.setString(3, o.getNombreObjeto());
                ps.setString(4, o.getUrlObjeto());
                ps.setString(5, o.getDescripcion());
                ps.executeUpdate();
                System.out.println("Objeto añadido correctamente");
                // nullpointer
                añadirO = true;

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
        return añadirO;
    }

    public boolean insertarObjInventario (Usuario u, Objeto o) throws SQLException {
        boolean insert = true;
        String query = "INSERT INTO inventario VALUES (?,?)";
        try {
            PreparedStatement ps = ConnBBDD.conn.prepareStatement(query);
            //ps.setInt(1, u.getIdUsuario());
            ps.setInt(1, o.getIdObjeto());
            ps.setString(2, u.getNombre());

            ps.executeUpdate();
            System.out.println("Se ha añadido al inventario del usuario " + u.getNombre() + " el objeto " + o.getNombreObjeto());
            // nullpointer
            ps.close();
        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }
        return insert;
    }

    /////metodo SELECT
    public Objeto consultarObjeto(int id) throws SQLException{
        Objeto o = new Objeto();
        String query = "SELECT * FROM objetos WHERE idObjeto='" + id + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            o.setIdObjeto(rs.getInt("idObjeto"));
            o.setIdUsuario(rs.getInt("idUsuario"));
            o.setNombreObjeto(rs.getString("nombreObjeto"));
            o.setUrlObjeto(rs.getString("urlObjeto"));
            o.setDescripcion(rs.getString("descripción"));
            System.out.println("Objeto " + o.getNombreObjeto() + " con descripción " + o.getDescripcion());
        }
        rs.close();
        stm.close();
        return o;

    }
    public Objeto consultarObjetoNom(String nombreOb) throws SQLException{
        Objeto objeto = new Objeto();
        String query = "SELECT * FROM objetos WHERE nombreObjeto='" + nombreOb + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            objeto.setIdObjeto(rs.getInt("idObjeto"));
            objeto.setIdUsuario(rs.getInt("idUsuario"));
            objeto.setNombreObjeto(rs.getString("nombreObjeto"));
            objeto.setUrlObjeto(rs.getString("urlObjeto"));
            objeto.setDescripcion(rs.getString("descripción"));
            System.out.println("Objeto " + objeto.getNombreObjeto() + " con descripción " + objeto.getDescripcion());
        }
        rs.close();
        stm.close();
        return objeto;

    }

    public boolean objetoenBBDD(Objeto o) throws SQLException{
        boolean consulta = false;
        String query = "SELECT * FROM objetos WHERE nombreObjeto='" + o.getNombreObjeto() + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            consulta = true;
            System.out.println("Objeto " + o.getNombreObjeto() + " ya esta en la BBDD");
        }
        rs.close();
        stm.close();
        return consulta;
    }

    public boolean elegirObjeto(String nombre){
        boolean elegir = false;
        ResultSet rs = null;
        String query = "SELECT * FROM objetos WHERE nombreObjeto='" + nombre + "'";
        try {
            Statement stm = ConnBBDD.conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                System.out.println("Has elegido el objeto " + nombre);
                elegir = true;
            }
            rs.close();
            stm.close();

        } catch (SQLException e){
            System.out.println("Error al elegir ");
            e.printStackTrace();
        }
        return elegir;
    }

    public Objeto dameObjetosUsuariodeInventario(Usuario u, int idOb) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String query = "SELECT idObjeto FROM inventario WHERE nombreUsuario='" + u.getNombre() + "'";
        Objeto o = null;
        try {
            rs = stm.executeQuery(query);
            o = null;
            while(rs.next()){
                o = consultarObjeto(rs.getInt("idObjeto"));
            }
            if (idOb != o.getIdObjeto()){
                o = null;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error funcion dameObjetosUsuario");
            e.printStackTrace();
        }
        return o;

    }

    //no funciona
    public List<Objeto> listarInventarioUsuario(Usuario u) throws SQLException {
        Statement stm = ConnBBDD.conn.createStatement();
        String query = "SELECT idObjeto FROM inventario WHERE nombreUsuario='" + u.getNombre() + "'";
        List<Objeto> objetos = new ArrayList<Objeto>();
        ResultSet rs = stm.executeQuery(query);
        try {
            if (rs.next()) {
                objetos.add(consultarObjeto(rs.getInt("idObjeto")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stm.close();
            rs.close();
            return objetos;
        }
    }


    //metodo DELETE
    public boolean eliminarObjeto(Objeto o){
        boolean eliminarO = false;
        Statement stm = null;
        Connection conn;
        try {
            String query = "DELETE FROM objetos WHERE nombreObjeto='" + o.getNombreObjeto() + "'";
            stm = ConnBBDD.conn.createStatement();
            stm.execute(query);
            eliminarO = true;
            System.out.println("Objeto eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error eliminando objeto");
            e.printStackTrace();
        }
        return eliminarO;
    }

    public boolean eliminarObjetoInventario(Usuario u, Objeto o){
        boolean eliminarOI = false;
        Statement stm = null;
        Connection conn;
        try {
            String query = "DELETE FROM inventario WHERE objeto='" + o.getNombreObjeto() + "'";
            stm = ConnBBDD.conn.createStatement();
            stm.execute(query);
            eliminarOI = true;
            System.out.println("Se ha eliminado el objeto " + o.getNombreObjeto() + " del usuario " + u.getNombre());
        } catch (SQLException e) {
            System.out.println("Error eliminando objeto");
            e.printStackTrace();
        }
        return eliminarOI;
    }

    //metodo UPDATE
    public boolean updateValor(String nombreObjeto, int valor){
        boolean updateV = false;
        Statement stm = null;
        try {
            stm = ConnBBDD.conn.createStatement();
            String query = "UPDATE objetos SET valor='" + valor + "' where nombreObjeto='" + nombreObjeto + "'";
            stm.execute(query);
            updateV = true;
            System.out.println("Valor del objeto " + nombreObjeto + " modificado a " + valor);
        } catch (SQLException e) {
            System.out.println("Error modificando valor");
            e.printStackTrace();
        }
        return updateV;
    }

}
