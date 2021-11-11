package com.hbt.semillero.ejb;

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
import com.hbt.semillero.entidad.Comic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class GestionarCompraComicBean implements IGestionarComicLocal{
	
	@PersistenceContext
	public EntityManager em;

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
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaLengthNombreComicDTO consultarComicTamanioNombre(Short lengthCadena) {
		String consulta = "SELECT c.nombre "
						+ " FROM Comic c";
		ConsultaLengthNombreComicDTO consultaLengthNombreComicDTO = new ConsultaLengthNombreComicDTO();
		try {
			if(lengthCadena > 200) {
				throw new Exception("La longitud máxima permitida es de 200 caracteres");
			}
			Query consultaQuery = em.createQuery(consulta);
			List<String> nombresComics = consultaQuery.getResultList();
			for (String nombre : nombresComics) {
				if(nombre.length() >= lengthCadena) {
					consultaLengthNombreComicDTO.getComicsSuperanTamanio().add(nombre);
				} else {
					consultaLengthNombreComicDTO.getComicsNoSuperanTamanio().add(nombre);
				}
			}
			consultaLengthNombreComicDTO.setExitoso(true);
			consultaLengthNombreComicDTO.setMensajeEjecucion("Comics procesados exitosamente");	
		} catch (Exception e) {
			consultaLengthNombreComicDTO.setExitoso(false);
			consultaLengthNombreComicDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar los comics");
		}

		return consultaLengthNombreComicDTO;
	}

}
