package hola;

public class Usuario {
    private String nombre;
    private String password;
    private int nivel;
    private int ataque;
    private int defensa;
    private int resistencia;

    public Usuario(String nombre, String contraseña, int nivel, int ataque, int defensa, int resitencia){
        this.nombre = nombre;
        this.password = contraseña;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.resistencia = resitencia;
    }
    public Usuario(String nombre, String contraseña){
        this.nombre = nombre;
        this.password = contraseña;
    }

    public String getNombre(){
        return nombre;
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
