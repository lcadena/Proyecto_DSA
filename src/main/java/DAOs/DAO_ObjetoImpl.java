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


    /////metodo SELECT
    public Objeto consultarObjeto(int id) throws SQLException{
        String query = "SELECT * FROM objetos WHERE nombreObjeto='" + id + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        System.out.println("Aqui llego también");
        Objeto o = new Objeto();
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
        while (rs.next()){

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
        String query = "SELECT nombreObjeto FROM objetos WHERE idUsuario='" + u.getIdUsuario() + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        Objeto o = null;
        System.out.println("Aqui llego 2");
        ResultSet rs = stm.executeQuery(query);
            if (rs.next()){
                o = consultarObjeto(rs.getInt("idObjeto"));
                System.out.println("El usuario: " + u.getNombre() + " tiene el objeto " + o.getNombreObjeto());
            }
            if (idOb != o.getIdObjeto()){
                o = null;
            }
            stm.close();
            rs.close();
            return o;
    }


    public List<Objeto> listarInventarioUsuario(Usuario u) throws SQLException {
        Statement stm = ConnBBDD.conn.createStatement();
        String query = "SELECT objetos.idObjeto,objetos.idUsuario,objetos.nombreObjeto,objetos.urlObjeto,objetos.descripcion FROM objetos INNER JOIN usuarios on objetos.idUsuario = usuarios.idUsuario WHERE usuarios.nombreUsuario='" + u.getNombre() + "'";
        List<Objeto> objetos = new ArrayList<Objeto>();
        ResultSet rs = stm.executeQuery(query);

        try {

                while (rs.next()) {
                    Objeto o = new Objeto();
                    o.setIdObjeto(rs.getInt("idObjeto"));
                    o.setIdUsuario(rs.getInt("idUsuario"));
                    o.setNombreObjeto(rs.getString("nombreObjeto"));
                    o.setUrlObjeto(rs.getString("urlObjeto"));
                    o.setDescripcion(rs.getString("descripcion"));
                    objetos.add(o);
                    //System.out.println(objetos);
                    System.out.println(o.getNombreObjeto());
                }

            //System.out.println(objetos);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("El usuario no tiene objetos");
            //System.out.println("El usuario no tiene objetos");

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
