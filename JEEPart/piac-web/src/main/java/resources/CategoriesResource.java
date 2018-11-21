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

import entites.AnnouncementCategories;
import iservices.IAnnouncementCategoriesService;
import service.AnnouncementCategoriesService;

@RequestScoped
@Path(value = "Categories")
public class CategoriesResource {

	@Inject
	IAnnouncementCategoriesService ac = new AnnouncementCategoriesService();
	
	@GET
	@Path(value = "showCats")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCats() {

	return Response.status(200).entity(ac.getAnnouncementCategories()).build();
	// return Response.status(Status.ACCEPTED);

	}
	@GET
	@Path(value = "showCatAnn")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCatAnn() {

	return Response.status(200).entity(ac.getAnnouncementsCategories()).build();
	// return Response.status(Status.ACCEPTED);

	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategbyid(@PathParam(value = "id") int id) {
		AnnouncementCategories a = ac.ShowAnnouncementCategory(id);
		if (a != null)
			return Response.ok(a).build();
		else
			return Response.status(404).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCateg(AnnouncementCategories a) {

		ac.AddAnnouncementCategory(a);
		return Response.status(Status.CREATED).build();

	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam(value="id") int id){
		 ac.DeleteAnnouncementCategory(ac.ShowAnnouncementCategory(id));
		 
		
	 return Response.status(200).build();
		 
	}
	
	@Path("/{id}")
	@PUT
	public Response updateCategById(@PathParam(value="id") int id
			 ,AnnouncementCategories a){
		
		a.setName("edit");
		 ac.EditAnnouncementCategory(a);
			 return Response.ok().build();		 
	}
	
	@Path("/{id}/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouttest(@PathParam(value="id") int id , @PathParam(value="name") String name){
		AnnouncementCategories a = new AnnouncementCategories(id,name);
		ac.AddAnnouncementCategory(a);
		 return Response.status(200).build();
	}

}
