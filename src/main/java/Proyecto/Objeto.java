package Proyecto;

public class Objeto {

    public int idObjeto;

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    private String nombreObjeto;
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
        this.nombreObjeto = nombre;
        this.valor = valor;
    }
    public Objeto(int idObjeto,String nombreObjeto, int valor){
        this.idObjeto = idObjeto;
        this.nombreObjeto = nombreObjeto;
        this.valor = valor;
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

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }


}
