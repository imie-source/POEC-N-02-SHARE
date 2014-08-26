/**
 * 
 */
package org.imie;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ime.PersonneServiceLocal;

import personneEntity.Personne;


/**
 * @author imie
 *
 */
@Stateless
@Path("/personneWebService")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class PersonneWebService {

	@EJB
	PersonneServiceLocal personneService;
	
	@GET()
	public Response findAllPersonne(){
		List<Personne> retour =  personneService.findAllPersonne();
		return Response.ok(retour).build();
	}
	
	@POST
	public Response insertPersonne(Personne personne){
		Personne retour = personneService.insertPersonne(personne);
		return Response.ok(retour).build();
	}
	
	@DELETE()
	@Path("/{id}")
	public Response deletePersonne(@PathParam("id") Integer id){
		personneService.deletePersonne(id);
		return Response.ok().build();
		
	}
	
}
