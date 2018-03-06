package hola;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    private static Mundo mundo = new Mundo();

    public  static void main(String[] args) throws IOException {

        int op = -1;
        int ret = 0;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
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

                case 5://case para añadir objeto a usuario
                    consultarObjetos();
                    lector.readLine();
                    break;
                case 6://consultar objetos de usuario
                    consultarObjetosdeUsuario();
                    lector.readLine();
                    break;

                case 7:
                    transferirobjetos();
                    lector.readLine();
                    break;

                case 8:
                    eliminarObjeto();
                    break;

            }
        }
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

    public static void eliminarObjeto() throws IOException {

    }









  /////////////// transferirobjetos solo la he empezado no esta bien :(

        public static void transferirobjetos() throws IOException {

            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));



            int res = consultarObjetosdeUsuario();
            System.out.println(res);
            if (res == 0) {

                System.out.println("El usuario  tiene el objeto que deesea transferir :(");

                System.out.println("Escriba el nombre del segundo usuario");
                String nombreusuario2 = lector.readLine();
                Usuario usertemp2 = mundo.consultarUsuario(nombreusuario2);
                //ustertemp1eliminar


                System.out.println("Escriba el objeto que quiere transferir");
                BufferedReader lector1 = new BufferedReader(new InputStreamReader(System.in));
                String nombreObjeto = lector.readLine();
                int valorobjeto = 3;
                Objeto miobjeto = new Objeto(nombreObjeto, valorobjeto);
                //mundo.añadirObjeto(usertemp2,miobjeto);
                //LinkedList<Objeto> Inventario = new LinkedList<Objeto>();

                // Inventario = mundo.consultarObjetos(usertemp);



            }
            if (res == -1)

            {
                System.out.println("El usuario no tiene el objeto que deesea transferir :(");
            }



        }

        public void PrintearEscenario(Escenario e){

        }






        }




