package DAOs;

import Proyecto.*;

public class DAO_EscenarioImpl extends Escenario {

    /*public Escenario getWorld(int id) {
        return null;
    }

    public void addEscena(int id, Escenario escenario) {

    }

    public void updateEscena (int id, Escenario escenario) {

    }*/

    public Celda[][] crearMapa(){
        for (int x=0;x<this.getAncho();x++){
            for (int y=0;y<this.getAlto();y++){
                celdas[x][y]=new Celda();
            }
        }
        return celdas;
    }
}
