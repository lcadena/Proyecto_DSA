package REST;

import Proyecto.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Path("/json")
public class JSONService {

    protected Mundo mundo;

    public JSONService() throws SQLException {
        mundo = MundoSingleton.getInstance().getMundo();

        if(mundo.listaUsuarios == null) {

            //Usuario user1 = new Usuario("admin","admin");

            //mundo.crearUsuario(user1);


        }
    }

    @Path("/basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }


    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario (Usuario u) throws SQLException {
        boolean r = mundo.daoRegistroUsuario(u);
        if(r){
            return Response.status(201).entity("Registro correcto").build();
        } else {
            r = false;
            return Response.status(209).entity("Usuario existente").build();
        }
    }

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
/*    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Login login) {

        return Response.status(201).entity("User  added ").build();
    }*/

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
      Objeto obj =  mundo.daoConsultarObjetoNom(nombre);
       return Response.status(201).entity(obj).build();
    }


}
