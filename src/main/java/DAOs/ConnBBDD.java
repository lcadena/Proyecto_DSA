package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnBBDD {
    public static Connection conectar() {
        Connection conn = null;
        String user = "root";
        String password = "mysql123456";
        String url = "http://localhost:3306/";
        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url);
            if (conn != null){
                System.out.println("Conectado");
            }
        } catch (Exception e){
            System.out.println("No se ha podido conectar con el server");
            e.printStackTrace();
        }
        return conn;
    }
}
