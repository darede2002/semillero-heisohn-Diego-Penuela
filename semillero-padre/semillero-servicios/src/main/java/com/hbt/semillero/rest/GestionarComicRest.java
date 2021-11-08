package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.consultarComicTamanioNombreComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

@Path("/gestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;

	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	public consultarComicTamanioNombreComicDTO consultarComicTamanioNombre(@QueryParam("lengthComic")Short lengthComic) {
		return this.gestionarComicLocal.consultarComicTamanioNombre(lengthComic);
	}
	
	
	
}


