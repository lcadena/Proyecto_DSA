package DAOs;

import Proyecto.Objeto;
import Proyecto.Usuario;

import java.util.List;

public interface DAO_Objeto {
    public boolean insertarObjeto(Objeto o);
    public void insertarObjInventario (Usuario u, Objeto o);
    public boolean eliminarObjeto(Objeto o);
    public boolean elegirObjeto(String nombre);
    public List<Objeto> listarInventarioUsuario(Usuario u);

}
