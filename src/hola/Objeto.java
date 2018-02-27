package hola;

public class Objeto{
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public int getCoste() {
        return Coste;
    }

    public void setCoste(int coste) {
        Coste = coste;
    }

    private String Tipo;
    private String Descripcion;
    private int Valor;
    private int Coste;

    public Objeto(String nombre, String tipo, String descripcion, int valor, int coste){
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Descripcion = descripcion;
        this.Valor = valor;
        this.Coste = coste;
    }

}
