package hola;

import java.util.LinkedList;

public class Usuario {
    private String nombre;
    private String password;
    private int nivel;
    private int ataque;
    private int defensa;
    private int resistencia;
    LinkedList<Objeto> miInventario = new LinkedList<Objeto>();

    /*public Usuario(String nombre, String contraseña, int nivel, int ataque, int defensa, int resitencia){
        this.nombre = nombre;
        this.password = contraseña;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.resistencia = resitencia;
    }*/
    public Usuario(String nombre, String contraseña){
        this.nombre = nombre;
        this.password = contraseña;
    }

     public String getNombre(){
        return nombre;
     }
     public Objeto getObjeto(String nombreob) {
         int i = 0;
         boolean a = false;
         Objeto e = new Objeto();
         while (i <= miInventario.size() && a == false) {

             e = miInventario.get(i);
             if (nombreob.equals(e.getNombre())) {
                 a =true;
             } else i++;


         }
         if (a == false)
             e =null;

         return e;
     }

     public String getPassword() {
        return password;
     }

     public int getNivel() {
        return nivel;
     }

     public int getAtaque() {
        return ataque;
     }

     public int getDefensa() {
        return defensa;
     }

    public int getResistencia() {
        return resistencia;
    }
}
