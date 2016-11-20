package pl.mcymerys.best.rest;

import pl.mcymerys.best.model.ResultDTO;
import pl.mcymerys.best.service.ResultService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("author")
public class RESTService {

	@EJB
	ResultService resultService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResultDTO> get() {
		return resultService.getResultJson();
	}
}
