package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaLengthNombreComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.consultarComicTamanioNombreComicDTO;
import com.hbt.semillero.entidad.Comic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	public EntityManager em;
	private ComicDTO compraComic = new ComicDTO();

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) consultaNativa.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}

		return consultaNombrePrecioDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
	}

	@Override
	public ResultadoDTO actualizarComic(Long idComic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoDTO eliminarComic(Long idComic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComicDTO> consultarComics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}
	
	
	/**
	 * 
	 * 
	 * @param comic a buscar
	 * @param cantidad a comprar
	 * @return comicDTO resultado de la compra exitosa o fallida
	 */
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO comprarComic(ComicDTO comic, Long cantidad) {
		
		compraComic = comic;
		String estado;
		//variable de referencia instanciada a objeto local
		
		
		try {
			if((compraComic.getEstadoEnum())=="INACTIVO") {
				throw new Exception("El comic seleccionado no cuenta con stock en bodega");
			}
			// excepcion cuando no hay comics en bodega
			try {
				if(cantidad>compraComic.getCantidad()) {
					throw new Exception("La cantidad existente del comic es:  "+compraComic.getCantidad()+", y supera la ingresada");
					//validacion de cantidad disponible vs cantidad solicitada
				}
				compraComic.setCantidad((compraComic.getCantidad()-cantidad));
				Long cantidadComics=compraComic.getCantidad();
				if(cantidadComics==0L) {
					compraComic.setEstadoEnum("INACTIVO");
					//@Diego Peñuela, sigo sin entender como enviar un enum como parametro a una funcion
					LocalDate fecha = LocalDate.now(); 
					compraComic.setFechaVenta(fecha);
					//solo se usa cuando se vende la totalidad de los comics
					
					}
			}
				catch (Exception e) {
					compraComic.setExitoso(false);
					compraComic.setMensajeEjecucion("Se ha presentado un error tecnico correspondiente a la cantidad de comics disponibles");
					//error cuando se intenta comprar mas comics de los que hay en bodega
					}
				
				}
				catch (Exception e) {
					compraComic.setExitoso(false);
					compraComic.setMensajeEjecucion("Se ha presentado un error tecnico correspondiente a la disponibilidad de los comics");
					//error cuando se intenta comprar comics con estado inactivo
					
				}
			compraComic.setMensajeEjecucion("La compra del comic nombreComic fue exitosa");
			return compraComic;
			
					
	}
}


	
	