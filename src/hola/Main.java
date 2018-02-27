package hola;



import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import hola.Mundo;

public class Main {

    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    Mundo mundo = new Mundo();


    public  static void main(String[] args) throws IOException {

        int op = -1;


        System.out.println("0 - Salir");
        System.out.println("1 - Crear Usuario");
        System.out.println("2 - Eliminar Usuario");
        System.out.println("Elija una opción");


        switch (op){
            case 0://salir del programa
            break;

            case 1:
                nuevo();



            break;

            case 2:


            break;
        }
    }

     public void nuevo() throws IOException {

        System.out.println("Escriba un nombre de usuario");
        String nombre = lector.readLine();

        System.out.println("Contraseña");
        String contraseña = lector.readLine();


        Usuario user1 = new Usuario(nombre, contraseña);
        ///Llamar a la funcion crear usuario de Mundo
         mundo.crearUsuario(user1);


    }
}
