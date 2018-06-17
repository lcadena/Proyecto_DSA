package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnBBDD {
    public static Connection conn;
    public static Connection conectar(){
        String user = "root";
        String password = "Mazinger72";
        String BBDD = "juego";
        String url = "jdbc:mysql://147.83.7.204:3306/" + BBDD;
        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("Conectado");
            }
        } catch (Exception e){
            System.out.println("No se ha podido conectar con el server");
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection desconectar() throws SQLException {
        if (conn != null){
            conn.close();
        }
        return conn;
    }
}
