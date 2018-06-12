package REST;

import Proyecto.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Path("/json")
public class JSONService {

    protected Mundo mundo;

    public JSONService() throws SQLException {
        mundo = MundoSingleton.getInstance().getMundo();
        Usuario user1 = new Usuario("admin","admin");

        mundo.crearUsuario(user1);
        Objeto a1 = new Objeto(1,"libro","C:\\Users\\Arnau\\Desktop\\UNI\\DSA programas\\Proyecto2\\web\\Image\\1451079572633_1.png","Este objeto permite leerlo");
        user1.miInventario.add(a1);
        Objeto a2 = new Objeto(2,"gafas","C:\\Users\\Arnau\\Desktop\\UNI\\DSA programas\\Proyecto2\\web\\Image\\1451079572633_1.png","Este objeto permite leer");
        user1.miInventario.add(a2);
        if(mundo.listaUsuarios == null) {


        }
    }

    @Path("/basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }


//    @POST
//    @Path("/new")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newUsuario (Usuario u) throws SQLException {
//        boolean r = mundo.daoRegistroUsuario(u);
//        if(r){
//            return Response.status(201).entity("Registro correcto").build();
//        } else {
//            r = false;
//            return Response.status(209).entity("Usuario existente").build();
//        }
//    }



    @POST
    @Path("/inicio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inicioSesion (Proyecto.Login login) throws SQLException {
        System.out.println(login.getNombre() + login.getPassword());
        boolean r = mundo.daoInicioSesionUsuario(login);
        if(r){
            return Response.status(201).entity("Loguin correcto").build();
        } else {
            r = false;
            return Response.status(209).entity("Error al loguearse, registrese").build();
        }
    }
    @GET
    @Path("/listaObjetosUsuario/{nombreusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Objeto> getListaObjetosUsuario(@PathParam("nombreusuario") String usuario) throws SQLException{
        Usuario a ;
        System.out.println("aqui estamos");
        System.out.println(usuario);


        a = this.mundo.listaUsuarios.get(usuario);

        return a.miInventario;
    }
    @GET
    @Path("/obj/{user}/{obj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Objeto getObj(@PathParam("user") String usuario,@PathParam("obj") String objeto) {
        Usuario u = mundo.listaUsuarios.get(usuario);
        System.out.println("aqui estamos2");
        if (u == null) {
            return null;
            //return Response.status(409).entity("User already exists").build();
        } else {
            return u.getObjeto(objeto);
        }
    }
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Login login) {

        return Response.status(201).entity("User  added ").build();
    }

    @GET
    @Path("/Usuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("nombre") String nombre) throws SQLException {
        Usuario u = mundo.daoConsultarUsuario(nombre);
        return Response.status(201).entity(u).build();
    }

    @GET
    @Path("/Objeto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjeto(@PathParam("nombre") String nombre) throws SQLException{
      Objeto obj =  mundo.daoConsultarObjeto(nombre);
       return Response.status(201).entity(obj).build();
    }


}
