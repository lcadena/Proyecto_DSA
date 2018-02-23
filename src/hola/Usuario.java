package hola;

public class Usuario {
    public String Nombre;
    public String Password;
    public int Nivel;
    public int Ataque;
    public int Defensa;
    public int Resistencia;

    public Usuario(String nombre, String contraseña, int nivel, int ataque, int defensa, int resitencia){

        System.out.println("Datos hola.Usuario");
        this.Nombre = nombre;
        this.Password = contraseña;
        this.Nivel = nivel;
        this.Ataque = ataque;
        this.Defensa = defensa;
        this.Resistencia = resitencia;
    }
     public String getNombre(){
        return Nombre;
     }

}
