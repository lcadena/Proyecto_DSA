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
            String query = "INSERT INTO objetos VALUES (?,?,?)";
            try {
                ps = ConnBBDD.conn.prepareStatement(query);
                ps.setInt(1, o.getIdObjeto());
                ps.setString(2, o.getNombreObjeto());
                ps.setInt(3, o.getValor());
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
    public Objeto consultarObjeto(String nombreObjeto) throws SQLException{
        Objeto o = new Objeto();
        String query = "SELECT * FROM objetos WHERE nombreObjeto='" + nombreObjeto + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()){
            o.setIdObjeto(rs.getInt("idObjeto"));
            o.setNombre(rs.getString("nombreObjeto"));
            o.setValor(rs.getInt("valor"));
            System.out.println("Objeto " + o.getNombreObjeto() + " con valor " + o.getValor());
        }
        rs.close();
        stm.close();
        return o;

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
    ////Metodo SELECT
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

    public void insertarObjInventario (Usuario u, Objeto o) throws SQLException {
        String query = "INSERT INTO inventario VALUES (?,?)";
        try {
            PreparedStatement ps = ConnBBDD.conn.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, o.getNombreObjeto());
            ps.executeUpdate();
            ps.close();
            System.out.println("Se ha añadido al usuario " + u.getNombre() + " el objeto " + o.getNombreObjeto());
            // nullpointer
        } catch (SQLException e){
            System.out.println("Error en el registro");
            e.printStackTrace();
        }

    }

    //metodo DELETE
    public boolean eliminarObjeto(Objeto o){
        boolean eliminarO = false;
        Statement stm = null;
        Connection conn;
        try {
            String query = "DELETE FROM objetos WHERE nombreObjeto='" + o.getNombreObjeto() + "' AND valor='" + o.getValor() + "'";
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

    //no funciona
    public List<Objeto> listarInventarioUsuario(Usuario u) throws SQLException {
        String query = "SELECT objeto FROM inventario WHERE NombreUsuario='" + u.getNombre() + "'";
        Statement stm = ConnBBDD.conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        List<Objeto> objetos = new ArrayList<Objeto>();
        try {

            if (rs.next()) {
                System.out.println(objetos);
                objetos.add(consultarObjeto(rs.getString("objeto")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stm.close();
            rs.close();
            return objetos;
        }
    }

}
