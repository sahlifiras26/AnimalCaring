package resources;

import java.util.Date;

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

import entites.Discussion;
import iservices.DiscussionServiceLocal;
import iservices.ForumServiceLocal;

@RequestScoped
@Path(value = "discussions")
public class DiscussionResource {
	@Inject
	DiscussionServiceLocal metier;
	@Inject
	ForumServiceLocal metierforum;

	@Path("/{id}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatediscussion(Discussion discussion,@PathParam(value = "id") int id) {
        Date sysdate=new Date();
        discussion.setCreatedAt(sysdate);
        discussion.setNbResponds(0);
        discussion.setForum(metierforum.getForum(id));
		metier.addDiscussion(discussion);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Path(value = "showall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showdiscussions() {

		return Response.status(200).entity(metier.getAllDiscussions()).build();
	

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDiscussion(@PathParam(value = "id") int id) {
		Discussion d = metier.getDiscussion(id);
		if (d != null)
			return Response.ok(d).build();
	    return Response.status(404).build();

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDiscussion(@PathParam(value = "id") int id) {
		metier.deleteDiscussion(metier.getDiscussion(id));
		return Response.status(200).build();

	}

	@Path("/{id}")
	@PUT
	public Response updateDiscussion(@PathParam(value = "id") int id, Discussion d) {
		d.setIdDiscussion(id);
		metier.updateDiscussion(d);
		return Response.ok().build();
	}

}
