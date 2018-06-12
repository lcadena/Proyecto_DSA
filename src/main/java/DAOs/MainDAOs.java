package DAOs;

import Proyecto.Mundo;
import Proyecto.Objeto;
import Proyecto.Usuario;

import java.sql.SQLException;


public class MainDAOs {
    public static void main(String[] args) throws SQLException {
        ConnBBDD conn = new ConnBBDD();
        DAO_UsuarioImpl usuario = new DAO_UsuarioImpl();
        DAO_ObjetoImpl objeto = new DAO_ObjetoImpl();
        Mundo m = new Mundo();
        Usuario u = new Usuario("Laura", "sss");
        Objeto obj = new Objeto(1,"Espada","jjjj","hola");
        //usuario.registroUsuario(u);

        try {
            //m.lista();
            //m.daoRegistroUsuario(u);
            //m.daoEliminarUsuario(u);
            //m.daoConsultarUsuario("Liz");
            //m.daoValidarUsuario("Liz", "123");
            //m.daoUpdatePasswordUsuario("Liz", "222");
            m.daoAñadirObjeto(obj);
            //m.daoElegirObjeto("Catana");
            //m.daoEliminarObjeto(obj);
            //m.daoUpdateValorObjeto("Espada", 400);
            //m.daoEliminarObjetoInventario(u, obj);
            //m.daoConsultarObjetosUsuario(u.getNombre());
        } catch (SQLException e){
            e.printStackTrace();
        }
        //usuario.eliminarUsuario(new Usuario("Maria","123"));
        //usuario.consultarUsuario("Pepa");
        //usuario.loguinUsuario("Pepa", "123");
        /*DAO_Objeto objeto = new DAO_ObjetoImpl();
        objeto.insertarObjeto(new Objeto("Espada", 100));
        Usuario user = new Usuario("Pablo", "1111");
        Objeto obj = new Objeto("Casco",200);
        objeto.insertarObjInventario(user, obj);*/

    }
}
