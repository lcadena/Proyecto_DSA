package Proyecto;

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private int posX;
    private int posY;
    private String nombreEscenario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }



    /*public Usuario(String nombre, String contraseña, int nivel, int ataque, int defensa, int resitencia){
            this.nombre = nombre;
            this.password = contraseña;
            this.nivel = nivel;
            this.ataque = ataque;
            this.defensa = defensa;
            this.resistencia = resitencia;
        }*/
    public Usuario(){

    }
    public Usuario(int idUsuario, String nombreUsuario){

    }
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, int posX, int posY, String nombreEscenario){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.posX = posX;
        this.posY = posY;
        this.nombreEscenario = nombreEscenario;
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseña){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

     public String getNombre(){
        return nombreUsuario;
     }
     /*public Objeto getObjeto(String nombreob) {
         int i = 0;
         boolean a = false;
         Objeto e = new Objeto();
         while (i <= miInventario.size() && a == false) {

             e = miInventario.get(i);
             if (nombreob.equals(e.getNombreObjeto())) {
                 a =true;
             } else i++;


         }
         if (a == false)
             e =null;

         return e;
     }*/



}
