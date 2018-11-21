package resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.User;
import iservices.IUserService;
import service.UserService;
import resources.Secured;


@RequestScoped
@Path(value = "user")
public class UserResource {
	@Inject
	IUserService es = new UserService(); 
	
	
	@Secured
	@Path("/signup")
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response signupuser(User us){
		 
		es.signup(us);
		return Response.status(Status.CREATED).build();
		
		
	  
 }
	@Secured
	 @Path("/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getuserbyid(@PathParam(value = "id") int id) {
			User u = es.ShowProfile(id);
			if (u != null)
				return Response.ok(u).build();
			else
				return Response.status(404).build();

		}
	 
	 @Path("/edit/{id}")
		@PUT
		public Response updateuserById(@PathParam(value = "id") int id, User us) {
			es.EditProfile(us);
			return Response.ok().build();
		}
	 @Path("/doc")
	@PUT
	 public Response doctor(User us){
		us.setIsDoctor(true);
		return Response.status(Status.CREATED).build(); 
 }
	 @Path("/fostercare")
	@PUT
	 public Response fostercare(User us){
		us.setIsFostercarer(true);
		return Response.status(Status.CREATED).build(); 
 }
	 @Path("/trainer/{id}")
	@PUT
	 public Response trainer(User us){
		us.setIsTrainer(true);
		return Response.status(Status.CREATED).build(); 
 }
	 @Path("/rep/{id}")
	@PUT
	 public Response representative(User us){
		us.setIsRepresentative(true);
		return Response.status(Status.CREATED).build(); 
 }


	 

}
