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
            return Response.status(201).entity(r).build();
        } else {
            r = false;
            return Response.status(409).entity(r).build();
        }
    }

    @POST
    @Path("/inicio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inicioSesion (LogIn login) throws SQLException {
        boolean r = mundo.daoInicioSesionUsuario(login);
        if(r){
            return Response.status(201).entity(r).build();
        } else {
            r = false;
            return Response.status(409).entity(r).build();
        }
    }
    @POST
    @Path("/newObj")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjeto (Objeto objeto) throws SQLException {
        boolean r = mundo.daoAñadirObjeto(objeto);
        if(r){
            return Response.status(201).entity(r).build();
        } else {
            r = false;
            return Response.status(409).entity(r).build();
        }
    }

    @POST
    @Path("/updatePwd")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePasswordUser (Usuario u) throws SQLException{
        boolean r = mundo.daoUpdatePasswordUsuario(u.getNombre(), u.getContraseña());
        if (r){
            return Response.status(201).entity(r).build();
        } else {
            r = false;
            return Response.status(409).entity(r).build();
        }
    }
    @POST
    @Path("/eliminarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarUsuario (String nombreUsuario) throws SQLException{
        Usuario u = this.mundo.daoConsultarUsuario(nombreUsuario);
        System.out.println(u);

        if (u == null){
            return Response.status(409).entity("Usuario no registrado").build();
        } else {
            boolean r = mundo.daoEliminarUsuario(u);
            if (r){
                return Response.status(201).entity("Usuario eliminado correctamente").build();
            } else {
                return Response.status(201).entity("Error al eliminar").build();
            }
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
        if (u == null) {
            return Response.status(409).entity(u).build();
        } else {
            return Response.status(201).entity(u).build();
        }

    }

    @GET
    @Path("/infoUser/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoUser(@PathParam("nombre") String nombre) throws SQLException {
        Usuario u = mundo.daoInfoUserconEcenario(nombre);
        if (u == null) {
            return Response.status(409).entity(u).build();
        } else {
            System.out.println(u.getIdUsuario());
            int id = u.getIdUsuario();
            String name = u.getNombre();

             Usuario v = new Usuario(id, name);
                return Response.status(201).entity(v.getIdUsuario()).build();
        }

    }

    @GET
    @Path("/consultarObjeto/{idObj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetoiD(@PathParam("idObj") int idObj) throws SQLException{
        return Response.status(201).entity(mundo.daoConsultarObjeto(idObj)).build();
    }

    @GET
    @Path("/consultarObjetoporNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjeto(@PathParam("nombre") String nombre) throws SQLException{
        return Response.status(201).entity(mundo.daoConsultarObjetoporNom(nombre)).build();
    }

    @GET
    @Path("/listar/{nombreU}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Objeto> getInventario(@PathParam("nombreU") String nombreU) throws SQLException {
        return mundo.daoConsultarObjetosUsuario(nombreU);
    }

}
