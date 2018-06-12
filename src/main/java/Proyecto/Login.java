package Proyecto;

public class Login {


    private String nombre;
    private  String password;

    public Login(){

    }

    public Login(String nombre, String password){
        nombre=this.nombre;
        password=this.password;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
