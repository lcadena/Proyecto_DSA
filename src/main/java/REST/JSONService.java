package REST;

import Proyecto.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;

@Path("/json")
public class JSONService {

    protected Mundo mundo;

    public JSONService() {
        mundo = MundoSingleton.getInstance().getMundo();

        if(mundo.listaUsuarios == null) {

            Usuario user1 = new Usuario("admin","admin");

            mundo.crearUsuario(user1);


        }
    }

    @GET
    @Path("/Usuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("nombre") String nombre) {

        return mundo.consultarUsuario(nombre);
    }
    @GET
    @Path("/Objetos/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedList getObjetos(@PathParam("nombre") String nombre) {
      Usuario us =  mundo.listaUsuarios.get(nombre);
       return mundo.consultarObjetos(us);
    }

    @GET
    @Path("/Escenario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Escenario getEscenario(@PathParam("nombre") String nombre) {

        return mundo.consultarEscenario(nombre);
    }



    @POST
    @Path("/Usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Usuario usuario) {
        mundo.crearUsuario(usuario);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("User added in position "+mundo.listaUsuarios.size()).build();
    }
    @POST
    @Path("/Objeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjeto(Usuario usuario, Objeto objeto) {
        mundo.añadirObjeto(usuario,objeto);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Objeto añadido en el inventario "+usuario.miInventario.size()).build();
    }
    @POST
    @Path("/Escenario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newEscenario(Escenario escenario) {
        mundo.crearEscenario(escenario);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Objeto añadido en el inventario "+mundo.listaEscenarios.size()).build();
    }




}