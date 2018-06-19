package Proyecto;

public class Usuario {

    int idUsuario;
    private String nombre;
    private String password;
    private int nivel;
    private int ataque;
    private int defensa;
    private int resistencia;
    private int posX;
    private int posY;
    private String nombreEscenario;
    //public LinkedList<Objeto> miInventario = new LinkedList<Objeto>();

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
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, int posX, int posY, String nombreEscenario){
        this.idUsuario = idUsuario;
        this.nombre = nombreUsuario;
        this.password = contraseña;
        this.posX = posX;
        this.posY = posY;
        this.nombreEscenario = nombreEscenario;
    }

    public Usuario(String nombreUsuario, String contraseña){
        //this.idUsuario = idUsuario;
        this.nombre = nombreUsuario;
        this.password = contraseña;
    }

     public String getNombre(){
        return nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /*public void setMiInventario(LinkedList<Objeto> miInventario) {
        this.miInventario = miInventario;
    }*/

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    //public LinkedList<Objeto> getMiInventario();

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

}
