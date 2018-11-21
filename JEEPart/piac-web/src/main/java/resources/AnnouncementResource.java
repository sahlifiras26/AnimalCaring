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

import entites.Announcement;
import iservices.IAnnouncementService;
import service.AnnouncementService;

@RequestScoped
@Path(value = "Announcement")
public class AnnouncementResource {
	@Inject
	IAnnouncementService ac = new AnnouncementService();
	
	@GET
	@Path(value = "showAnn")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAnnouncements() {

	return Response.status(200).entity(ac.getAnnouncements()).build();
	// return Response.status(Status.ACCEPTED);

	}
	@GET
	@Path(value = "showAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAnnouncementsNotConfirmed() {

	return Response.status(200).entity(ac.getAnnouncementsNotConfirmed()).build();
	// return Response.status(Status.ACCEPTED);

	}
	@GET
	@Path(value = "showByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAnnouncementsByDate() {

	return Response.status(200).entity(ac.getAnnouncementsByDate()).build();
	// return Response.status(Status.ACCEPTED);

	}
	@GET
	@Path(value = "showSortByCateg")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAnnouncementsSortedByCategory() {

	return Response.status(200).entity(ac.ShowAnnouncementByIdCategory()).build();
	// return Response.status(Status.ACCEPTED);

	}
	
	@Path("/title/{title}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementbytitle(@PathParam(value = "title") String title) {
		return Response.status(200).entity(ac.ShowAnnouncementByTitle(title)).build();

	}
	@Path("/category/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementbyCategory(@PathParam(value = "name") String name) {
		return Response.status(200).entity(ac.ShowAnnouncementByCategory(name)).build();

	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementbyid(@PathParam(value = "id") int id) {
		Announcement a = ac.ShowAnnouncement(id);
		if (a != null)
			return Response.ok(a).build();
		else
			return Response.status(404).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAnnouncement(Announcement a) {

		ac.AddAnnouncement(a);
		return Response.status(Status.CREATED).build();

	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam(value="id") int id){
		 ac.DeleteAnnouncement(ac.ShowAnnouncement(id));
		 
		
	 return Response.status(200).build();
		 
	}
	
	@Path("/{id}")
	@PUT
	public Response updateAnnouncementById(@PathParam(value="id") int id
			 ,Announcement a){
		
		
		a.setConfirmed(true);
		a.setDeleted(false);
		 ac.EditAnnouncement(a);
			 return Response.ok().build();		 
	}
	@Path("/reject/{id}")
	@PUT
	public Response RejectAnnouncementById(@PathParam(value="id") int id
			 ,Announcement a){
		
		a.setConfirmed(false);
		a.setDeleted(true);
		 ac.EditAnnouncement(a);
			 return Response.ok().build();		 
	}
	@Path("/delete/{id}")
	@PUT
	public Response DeleteAnnouncementById(@PathParam(value="id") int id
			 ,Announcement a){
		
		a.setConfirmed(true);
		a.setDeleted(true);
		 ac.EditAnnouncement(a);
			 return Response.ok().build();		 
	}
}
