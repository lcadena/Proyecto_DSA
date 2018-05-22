package Proyecto;

public class Escenario {

    public int ancho;
    public int alto;
    public String nombre;
    public Celda[][] celdas;


    public Escenario(){

    }

    public Escenario(String nombre, int ancho, int alto) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.alto = alto;
        celdas = new Celda[ancho][alto];
        for(int i=0;i<ancho;i++)
            for(int j=0;j<alto;j++) {
                celdas[i][j] = new Celda();
            }
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
