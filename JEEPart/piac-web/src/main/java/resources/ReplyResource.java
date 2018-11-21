package resources;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import entites.Respond;
import iservices.ReplyServiceLocal;

@RequestScoped
@Path(value = "replies")
public class ReplyResource {
	@Inject
	ReplyServiceLocal metier;
	
	@Path("/{id}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createreply(Respond reply,@PathParam(value = "id") int id) {
		metier.addRespond(reply);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Path(value = "showall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showreplies() {

		return Response.status(200).entity(metier.getAllResponds()).build();
	

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReply(@PathParam(value = "id") int id) {
		Respond r = metier.getRespond(id);
		if (r != null)
			return Response.ok(r).build();
	    return Response.status(404).build();

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReply(@PathParam(value = "id") int id) {
		metier.deleteRespond(metier.getRespond(id));
	    return Response.status(200).build();

	}

	@Path("/{id}")
	@PUT
	public Response updateReply(@PathParam(value = "id") int id, Respond r) {
		r.setIdRespond(id);;
		metier.updateRespond(r);
		return Response.ok().build();
	}

}
