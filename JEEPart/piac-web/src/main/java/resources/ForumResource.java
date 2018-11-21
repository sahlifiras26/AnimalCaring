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

import entites.Forum;
import iservices.ForumServiceLocal;

@RequestScoped
@Path(value = "forums")
public class ForumResource {
	@Inject
	ForumServiceLocal metier;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createforum(Forum f) {
		f.setNbDiscussions(0);
		metier.addForum(f);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Path(value = "showall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showforums() {

		return Response.status(200).entity(metier.getAllForums()).build();
	

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getForumbyid(@PathParam(value = "id") int id) {
		Forum f = metier.getForum(id);
		if (f != null)
			return Response.ok(f).build();
	    return Response.status(404).build();

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteForum(@PathParam(value = "id") int id) {
		metier.deleteForum(metier.getForum(id));
		return Response.status(200).build();

	}

	@Path("/{id}")
	@PUT
	public Response updateForum(@PathParam(value = "id") int id, Forum f) {
		f.setIdForum(id);
		metier.updateForum(f);
		return Response.ok().build();
	}

}
