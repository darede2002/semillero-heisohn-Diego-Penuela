/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * 
 * @author DIEGO FERNANDO
 *
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {
	
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
	
	@PersistenceContext
	private EntityManager em;


	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String obtenerUnComic() {
		//BasicConfigurator.configure();
		Comic comic = null;
		try {
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 24;
			comic = em.find(Comic.class, 24L);
			
			//Consults en JPQL para obtener un comic con el id 24 pero quemado haciendo uso del metodo getSingleResult
			String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = 24 ";
			Query queryUnComic = em.createQuery(consultaUnComic);
			comic = (Comic) queryUnComic.getSingleResult();
			
			//Consulta en JPQL para obtener un comic con el id 24 haciendo uso del metodo getSingleResult y setParameter
			String consultaUnComicConParametro = " SELECT c FROM Comic c WHERE c.id = :idComic "
					+ " AND c.estadoEnum = :estadoComic "
					+ " ORDER BY c.nombre DESC ";
			Query queryUnComicConParametro = em.createQuery(consultaUnComicConParametro);
			queryUnComicConParametro.setParameter("idComic", 24L);
			queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO);
			comic = (Comic) queryUnComicConParametro.getSingleResult();
			
			//Consulta todos los comis existentes SELECT * FROM COMIC
			String findAllComic = " SELECT cm FROM Comic cm ";
			Query queryFindAllComic = em.createQuery(findAllComic);
			List<Comic> listaComics = queryFindAllComic.getResultList();
			
			// BLOQUE PARA GENERACION DE EXCEPCIONES
//			String consultaUnComicConException = " SELECT c FROM Comic c WHERE c.id = :idComic "
//					+ " AND c.estadoEnum = :estadoComic "
//					+ " ORDER BY c.nombre DESC ";
//			Query queryUnComicConException = em.createQuery(consultaUnComicConException);
//			queryUnComicConException.setParameter("idComic", 99L);
//			queryUnComicConException.setParameter("estadoComic", EstadoEnum.ACTIVO);
//			comic = (Comic) queryUnComicConException.getSingleResult();
			
//			String consultaUnComicConException2 = " SELECT c FROM Comic c WHERE c.estadoEnum = :estadoComic"
//					+ " AND c.estadoEnum = :estadoComic "
//					+ " ORDER BY c.nombre DESC ";
//			Query queryUnComicConException2 = em.createQuery(consultaUnComicConException2);
//			queryUnComicConException2.setParameter("estadoComic", EstadoEnum.ACTIVO);
//			comic = (Comic) queryUnComicConException2.getSingleResult();
			
			//Creacion del comic superman
			Comic comicSuperman = new Comic();
			comicSuperman.setNombre("Superman");
			comicSuperman.setEditorial("DC2");
			comicSuperman.setColeccion("MARVEL");
			comicSuperman.setNumeroPaginas(100);
			comicSuperman.setPrecio(new BigDecimal(300));
			comicSuperman.setCantidad(3);
			
			em.persist(comicSuperman);
			
			comicSuperman = this.consultarComicPorNombre("Superman");
			
			comicSuperman.setPrecio(new BigDecimal(600));
			comicSuperman.setCantidad(9);
			em.merge(comicSuperman);
			
			// Actualizar y eliminar mediante un identificador
			String actualizarComic = " UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id = :idComic";
			Query queryActualizar = em.createQuery(actualizarComic);
			queryActualizar.setParameter("estado", EstadoEnum.ACTIVO);
			queryActualizar.setParameter("idComic", 32L);
			queryActualizar.executeUpdate();
			
			String eliminarComic = " DELETE FROM Comic WHERE id = :idComic";
			Query queryEliminar = em.createQuery(eliminarComic);
			queryEliminar.setParameter("idComic", 32L);
			queryEliminar.executeUpdate();
			
			
			List<Long> idsComics = new ArrayList<>();
			idsComics.add(32L);
			idsComics.add(26L);
			idsComics.add(25L);
			idsComics.add(99L);
			String actualizarComicVarios = "UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id IN (:listIdComics)";
			Query queryActualizarVarios = em.createQuery(actualizarComicVarios);
			queryActualizarVarios.setParameter("estado", EstadoEnum.ACTIVO);
			queryActualizarVarios.setParameter("listIdComics", idsComics);
			queryActualizarVarios.executeUpdate();
			
			String eliminarComicVarios = " DELETE FROM Comic WHERE id = :idComic";
			Query queryEliminarVarios = em.createQuery(eliminarComicVarios);
			queryEliminarVarios.setParameter("idComic", 32L);
			queryEliminarVarios.executeUpdate();
			
			String consulta = "SELECT SCNOMBRE, SCPRECIO FROM COMIC WHERE SCID = :idComic";
			Query consultaNativa = em.createNativeQuery(consulta);
			consultaNativa.setParameter("idComic", 41L);
			Object[] data = (Object[]) consultaNativa.getSingleResult();
			String nombre = (String) data[0];
			BigDecimal precio = (BigDecimal) data[1];
			
//			
//			comicSuperman = this.consultarComicPorNombre(comicSuperman);
//			
//			em.remove(comicSuperman);
//			comicSuperman = this.consultarComicPorNombre(comicSuperman);
			
		} catch (NonUniqueResultException nur) {
			log.info("EXISTE MAS DE UN REGISTRO " + nur.getMessage());			
		} catch (NoResultException nre) {
			log.info("NO SE HAN ENCONTRADO REGISTROS CON EL ID " + 99L + nre.getMessage());
		} catch (Exception e) {
			log.info("SE HA PRESENTADO UN ERROR TECNICO " + e.getMessage());
			return e.getMessage();
		}
		
		return comic.toString();
	}

	private Comic consultarComicPorNombre(String nombreComic) {
		String consultaUnComicSuperman = " SELECT c FROM Comic c WHERE c.nombre = :nombreComic ";
		Query querySuperman = em.createQuery(consultaUnComicSuperman);
		querySuperman.setParameter("nombreComic", nombreComic);
		Comic comicSuperman = (Comic) querySuperman.getSingleResult();
		return comicSuperman;
	}
}
