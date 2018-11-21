package resources;

import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.Event;
import entites.EventInterrested;
import entites.EventInterrestedId;
import entites.EventParticipation;
import iservices.IEventService;
import iservices.IInterestedEvent;
import service.EventService;
import service.InterestedEvent;

@RequestScoped
@Path(value = "interst")
public class EventInterestedResource {
	@Inject
	IInterestedEvent ev = new InterestedEvent();
	@Inject
	IEventService es = new EventService();
	Event e;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createinterest(EventInterrested ei) {
		e = new Event();
		e = es.ShowEvent(ei.getEvent().getIdEvent());
		e.setNbInterrested(es.ShowEvent(ei.getEvent().getIdEvent()).getNbInterrested() + 1);
		ei.setEvent(e);
		// ev.getEvent().setNbParticipated(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipated()
		// + 1);
		ei.setDatecreated(new Date(System.currentTimeMillis()));
		ev.AddInterested(ei);
		es.EditEvent(e);

		return Response.status(Status.CREATED).build();
	}

	@Path("/{iduser}/{idevent}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInterestedId(@PathParam(value = "iduser") int iduser, @PathParam(value = "idevent") int idevent

	) {
		EventInterrestedId e = new EventInterrestedId();

		EventInterrested r = ev.ShowInterest(idevent, idevent);
		if (r != null)
			return Response.ok(r).build();
		else
			return Response.status(404).build();

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Deleteinterest(EventInterrested ei) {
		e = new Event();
		e = es.ShowEvent(ei.getEvent().getIdEvent());
		e.setNbInterrested(es.ShowEvent(ei.getEvent().getIdEvent()).getNbInterrested() - 1);
		ei.setEvent(e);
		// ev.getEvent().setNbParticipated(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipated()
		// + 1);

		ev.DeletInterested(ei);
		es.EditEvent(e);

		return Response.status(Status.CREATED).build();
	}

}
