package Proyecto;

public class Objeto{

    private String nombre;
    private String tipo;
    private String descripcion;
    private int valor;
    private int coste;
   /* public Objeto(String nombre, String tipo, String descripcion, int valor, int coste){
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Descripcion = descripcion;
        this.Valor = valor;
        this.Coste = coste;
    }*/

   public  Objeto(){

   }
    public Objeto(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    public Objeto(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        valor = valor;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        coste = coste;
    }

}
