package resources;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entites.TokenS;
import entites.User;
import iservices.IUserService;
import iservices.TokenServiceRemote;
import service.TokenService;
@RequestScoped
@Path(value = "secure")

public class Authentification {
	
	@EJB
	IUserService userService; 
	@EJB
	TokenServiceRemote tokenservice;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authentificate(User us) {
		String username = us.getEmail();
		if (userService.login(us) == false)
			{return Response.status(404).build();}
		 String token = issueToken(username);
		 TokenS T = new TokenS();
		
		 T.setUser( userService.findUserByMail(username));
		 T.setValue(token.substring(7).trim());
		 
		 T.setExpiration(null);

		tokenservice.save(T);
		 return Response.ok(token).header("Authorization",token).build();
		 
	}
	@GET
	@Path("/gettok")
	@Produces(MediaType.TEXT_PLAIN)
	public String gettoken(){
		
		tokenservice.getuserbytoken("lcg3cmea8oqonbb4sma0dka4p9");
		return "valide";
	}
	
    private String issueToken(String login) {
    	Random random = new SecureRandom();
    	String token = new BigInteger(130, random).toString(32);
    	return "Bearer "+ token ;
    } 
}
