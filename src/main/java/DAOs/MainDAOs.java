package DAOs;

import Proyecto.Objeto;
import Proyecto.Usuario;

public class MainDAOs {
    public static void main(String[] args) {
        ConnBBDD conn = new ConnBBDD();
        DAO_Usuario usuario = new DAO_UsuarioImpl();
        usuario.registroUsuario(new Usuario("toni", "12345"));
        DAO_Objeto objeto = new DAO_ObjetoImpl();
        objeto.insertarObjeto(new Objeto("Espada", 100));
        Usuario user = new Usuario("Pablo", "1111");
        Objeto obj = new Objeto("Casco",200);
        objeto.insertarObjInventario(user, obj);
    }
}
