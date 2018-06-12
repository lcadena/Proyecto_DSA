package Proyecto;

public class Objeto {
    private int idObjeto;
    private String urlObjeto;
    private String nombreObjeto;
    private String descripcion;


    public  Objeto(){

    }
    public Objeto(String nombre, int valor){
        this.nombreObjeto = nombre;

    }
    public Objeto(int idObjeto,String nombreObjeto, String urlObjeto, String descripcion){
        this.idObjeto = idObjeto;
        this.nombreObjeto = nombreObjeto;
        this.urlObjeto = urlObjeto;
        this.descripcion = descripcion;
    }


    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getUrlObjeto() {
        return urlObjeto;
    }

    public void setUrlObjeto(String urlObjeto) {
        this.urlObjeto = urlObjeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

}
