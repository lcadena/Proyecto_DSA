package DAOs;

import Proyecto.LogIn;
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
        LogIn log = new LogIn("Liz", "222");
        Usuario u = new Usuario(23,"Tomas","2323",3,2,"bosque");
        Objeto obj = new Objeto(4, 9,"Lanza","/web/images","dkdkmkefnken");
        //usuario.registroUsuario(u);

        try {
            //objeto.insertarObjInventario(u, obj);
            //m.lista();
            //m.daoRegistroUsuario(u);
            m.posicionyEscenariodeUsuario("Tomas");
            //m.daoEliminarUsuario(u);
            //m.daoConsultarUsuario("Liz");
            //m.daoInicioSesionUsuario(log);
            //m.daoValidarUsuario("Liz", "222");
            //m.daoUpdatePasswordUsuario("Liz", "355");
            //m.daoAñadirObjeto(obj);
            //m.daoElegirObjeto("Catana");
            //m.daoEliminarObjeto(obj);
            //m.daoUpdateValorObjeto("Espada", 400);
            //m.daoEliminarObjetoInventario(u, obj);
            //m.listaObjetosdeUsuario("Liz");
            //m.daoConsultarObjetosUsuario(u.getNombre());
            //m.daoConsultarObjetosUsuario("Pablo");
            //m.daoAñadirObjetoaUsuario(2, "Laura");
            //m.daoConsultarObjetosUsuario("Liz");
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
