package resources;

import java.sql.Date;
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
import entites.Donation;
import iservices.IDonationService;
import service.DonationService;

@RequestScoped
@Path(value = "donation")
public class DonationResource {	
	@Inject
	IDonationService ds = new DonationService();

	@GET
	@Path(value = "showall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showDonations() {
		return Response.status(200).entity(ds.getDonations()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDontion(Donation donation) {

		ds.AddDonation(donation);
		return Response.status(Status.CREATED).build();

	}
		
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonationById(@PathParam(value = "id") int id) {
		Donation donation = ds.ShowDonation(id);
		if (donation != null)
			return Response.ok(donation).build();
		else
			return Response.status(404).build();

	}

	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam(value = "id") int id) {
		ds.DeletDonation(ds.ShowDonation(id));
		return Response.status(200).build();
	}
		
	@Path("/{id}")
	@PUT
	public Response updateDonationById(@PathParam(value = "id") int id, Donation donation) {
		ds.EditDonation(donation);
		return Response.ok().build();
	}
	
	@Path("/gifts")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getGifts() {
		
		return Response.status(200).entity(ds.giftStatistic()).build();		
	}
	
	@Path("/demands")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDemands() {
		return Response.status(200).entity(ds.demandStatistic()).build();		
	
	}
			
		@Path("/fundRasings")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public Response getFundRasings() {
			return Response.status(200).entity(ds.fundRaisingStatistic()).build();		
		}		
	
		@GET
		@Path("search/{tag}/{type}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchDonationByNameAndType(@PathParam(value = "tag") String tag,@PathParam(value = "type") String type) {
			return Response.status(200).entity(ds.searchDonation(tag, type)).build();
		}

		
		@GET
		@Path("searchByDate/{date}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchDonationByDate(@PathParam(value = "date") String date) {
			return Response.status(200).entity(ds.serachDonationByDate(Date.valueOf(date))).build();
		}		
				
		@GET
		@Path("donationStatistic/{year}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getDonation(@PathParam(value = "year") String year) {
			return Response.status(200).entity(ds.donationStatisticByYear(year)).build();
		}		
		
		
		
		
		
}
