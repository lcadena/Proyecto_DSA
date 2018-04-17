package hola;


import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hola.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/*public class Main {

    private static Mundo mundo = new Mundo();

    public  static void main(String[] args) throws IOException {


        Escenario es = new Escenario();
        int op = -1;
        int ret = 0;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        //LinkedList<Objeto> Inventario = new LinkedList<Objeto>();
        ///////////An: problema con el return en consultar//

        while (ret == 0){
        System.out.println("0 - Salir");
        System.out.println("1 - Crear Usuario");
        System.out.println("2 - Eliminar Usuario");
        System.out.println("3 - Consultar Usuario");
        System.out.println("4 - Añadir Objeto a Usuario");
        System.out.println("5 - Consultar Inventario");
        System.out.println("6 - Consultar Objeto");
        System.out.println("7 - Transferir objeto");
        System.out.println("8 - Eliminar Objeto");
        System.out.println("9 - Crear Escenario ");
        System.out.println("10 - Mostrar escenario");
        System.out.println("11 - Guardar escenario en fichero JSON");
        System.out.println("12 - Cargar escenario de fichero JSON");
        System.out.println("Elija una opción");
        op = Integer.parseInt(lector.readLine());


            switch (op) {
                case 0://salir del programa
                    ret = 1;

                    break;

                case 1://case para crear usuario
                    nuevoUsuario();
                    lector.readLine();
                    break;

                case 2://case para eliminar usuario
                    deleteUsuario();
                    lector.readLine();
                    break;

                case 3://case para consultar usuario
                    saberUsuario();
                    lector.readLine();
                    break;

                case 4://case para añadir objeto a usuario
                    añadirObjeto();
                    lector.readLine();
                    break;

                case 5://consultar inventario
                    consultarObjetos();
                    lector.readLine();
                    break;
                case 6://consultar objetos de usuario
                    consultarObjetosdeUsuario();
                    lector.readLine();
                    break;

                case 7:
                    transferirObjetos();
                    lector.readLine();
                    break;

                case 8:
                    eliminarObjeto();
                    lector.readLine();
                    break;
                case 9:
                    es = crearEscenario();
                    lector.readLine();
                    break;
                case 10:
                    printearEscenario(es);
                    lector.readLine();
                    break;
                case 11:///escenario con JSON
                    guardarescenarioenficheroJSON(es);
                    lector.readLine();
                    break;
                case 12:///escenario con JSON
                    es = leerescenariodeficheroJSON();
                    lector.readLine();
                    break;


            }
        }
    }

    public static void guardarescenarioenficheroJSON(Escenario c){
        JSONEscenario obj = new JSONEscenario();
        obj.run(c);

    }
    public static Escenario leerescenariodeficheroJSON(){
        JSONEscenario obj = new JSONEscenario();
        Escenario b = new Escenario();
        b = obj.run2();
        return b;
    }
     public static void nuevoUsuario() throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre de usuario");
        String nombre = lector.readLine();

        System.out.println("Escriba una Contrasena");
        String contraseña = lector.readLine();


        Usuario user1 = new Usuario(nombre, contraseña);
        ///Llamar a la funcion crear usuario de Mundo
        boolean correcto = mundo.crearUsuario(user1);
         if(correcto == true){
            System.out.println("Usuario creadao correctamente");
         } else {
             System.out.println("Usuario ya existente");
         }
     }

    public static void deleteUsuario() throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario que quiere eliminar");
        String nombre1 = lector.readLine();

        ///Llamar a la funcion eliminarUsuario de Mundo
        mundo.eliminarUsuario(nombre1);
        if(mundo.eliminarUsuario(nombre1)){
            System.out.println("Usuario eliminado correctamente");
        } else {
            System.out.println("Error al eiminar usuario");
        }
    }
    public static void saberUsuario() throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario a consultar");
        String nombre1 = lector.readLine();

        Usuario usertemp = mundo.consultarUsuario(nombre1);
        System.out.println("La contraseña del usuario" + nombre1 + "es:" + usertemp.getPassword());
    }

    public static void transferirObjetos() throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba el nombre del usuario origen");
        String nombreusuario1 = lector.readLine();
        Usuario usertemp1 = mundo.consultarUsuario(nombreusuario1);

        System.out.println("Escriba el nombre del objeto");
        String nombreobjeto = lector.readLine();
        LinkedList<Objeto> Inventario = new LinkedList<Objeto>();
        Inventario = mundo.consultarObjetos(usertemp1);
        Objeto e = new Objeto(nombreobjeto);
        //e = Inventario;

        System.out.println("Escriba el nombre del usuario destino");
        String nombreusuario2 = lector.readLine();
        Usuario usertemp2 = mundo.consultarUsuario(nombreusuario2);
        mundo.tranferirObjetosentreUsuarios(usertemp1,usertemp2,e);



        /**int res = consultarObjetosdeUsuario();
        System.out.println(res);
        if (res == 0) {

            int valorobjeto = 3;
            Objeto miobjeto = new Objeto(nombreObjeto, valorobjeto);
            //mundo.añadirObjeto(usertemp2,miobjeto);
            //LinkedList<Objeto> Inventario = new LinkedList<Objeto>();

            // Inventario = mundo.consultarObjetos(usertemp);

        }
        if (res == -1)
        {
            System.out.println("El usuario no tiene el objeto que deesea transferir :(");
        }**/
   /* }

    public static void añadirObjeto() throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario");
        String nombreusuario = lector.readLine();

        System.out.println("Escriba el nombre del objeto");
        String nombreobjeto = lector.readLine();

        System.out.println("Escriba el valor del objeto");
        int valorobjeto = Integer.parseInt(lector.readLine());

        Objeto miobjeto = new Objeto(nombreobjeto, valorobjeto);

        Usuario usertemp = mundo.consultarUsuario(nombreusuario);

        mundo.añadirObjeto(usertemp,miobjeto);

    }

    public static void consultarObjetos() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario");
        String nombreusuario = lector.readLine();
        Usuario usertemp = mundo.consultarUsuario(nombreusuario);

        LinkedList<Objeto> Inventario = new LinkedList<Objeto>();

        Inventario = mundo.consultarObjetos(usertemp);


            for (Objeto objetos : Inventario) {
                System.out.println("Nombre objeto:"+ objetos.getNombre() + "valor objeto:" + objetos.getValor() );
            }
    }

    public static int consultarObjetosdeUsuario() throws IOException {
        int f = 8;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario");
        String nombreusuario = lector.readLine();
        Usuario usertemp = mundo.consultarUsuario(nombreusuario);

        System.out.println("Escriba el nombre del objeto");
        String nombreobjeto = lector.readLine();
        LinkedList<Objeto> Inventario = new LinkedList<Objeto>();
        Inventario = mundo.consultarObjetos(usertemp);
        boolean a = false;
        for (Objeto objetos : Inventario) {
            if (nombreobjeto.equals(objetos.getNombre()) && a == false) {

                System.out.println("Nombre objeto: " + objetos.getNombre() + " valor objeto: " + objetos.getValor());
                a = true;
                f = 0;
                            }

            if (a == false) {
                System.out.println("No esta el objeto");
                f = -1;
            }

        }

            return f; //nose yo..


    }

///////////////Eliminar objeto:

    public static int  eliminarObjeto() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba un nombre del usuario");
        String nombreusuario = lector.readLine();
        Usuario usertemp = mundo.consultarUsuario(nombreusuario);

        System.out.println("Escriba el nombre del objeto");
        String nombreobjeto = lector.readLine();

        LinkedList<Objeto> Inventario = new LinkedList<Objeto>();

        Inventario = mundo.consultarObjetos(usertemp);


        int a=mundo.eliminarObjeto(usertemp, nombreobjeto);

        if (a==0)
            System.out.println("se ha eliminado el objeto");
        else if ( a==-1)
            System.out.println("No existia el objeto");


        return  a;
    }



        public static void printearEscenario(Escenario esce){

        int ancho= esce.getAncho();
        int alto = esce.getAlto();

            for(int j=0;j<alto;j++) {

                for (int i = 0; i < ancho; i++) {
                    System.out.print(esce.celdas[i][j].getTipo());
                }
                System.out.println("");
            }


        }


        public static Escenario crearEscenario()throws IOException {



            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba un nombre de escenario");
            String nombreEscenario = lector.readLine();

            System.out.println("Escriba el ancho del escenario");
            int ancho = Integer.parseInt(lector.readLine());

            System.out.println("Escriba el alto del escenario");
            int alto = Integer.parseInt(lector.readLine());

            Escenario esc = new Escenario(nombreEscenario,ancho,alto);
            return esc;
        }


}

*/
/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages("hola");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");


        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        System.in.read();
        server.stop();
    }
}



