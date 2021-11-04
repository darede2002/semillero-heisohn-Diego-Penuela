package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;


/**
 * 
 * <b>Descripción:<b> Clase que determina el mapeo de la tabla COMIC de la BD DB_SEMILLERO
 * <b>Caso de Uso:<b> 
 * @author Diego
 * @version
 */

@Entity
@Table(name="COMIC")
public class Comic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID =1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ:COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	@Column(name="SCID")
	private Long id;
	
	@Column(name = "SCNOMBRE")
	private String nombre;
	
	@Column(name = "SCEDITORIAL")
	private String editorial;
	
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	private TematicaEnum tematicaEnum;
	
	@Column(name = "SCCOLECCION")
	private String coleccion;
	
	@Column(name = "SCNUMEROPAGINAS")
	private Integer numeroPaginas;
	
	@Column(name = "SCPRECIO")
	private BigDecimal precio;
	
	@Column(name = "SCAUTORES")
	private String autores;
	
	@Column(name = "SCCOLOR")
	private Boolean color;
	
	@Column(name = "SCFECHAVENTA")
	private LocalDate fechaVenta;
	
	@Column(name = "SCESTADO")
	private EstadoEnum estadoEnum;
	
	@Column(name = "SCCANTIDAD")
	private Integer cantidad;
	
	
	
	/**
	 * constructor de la clase vacio
	 */
	
	public Comic() {
		//constructor vacío
	}
	
	
	/**
	 * constructor de la clase parametrizado
	 */
	
	public Comic(String nombre, String editorial, String coleccion, Integer numeroPaginas, Integer precio, String autores, Boolean color, Integer cantidad) {
		this.nombre= nombre;
		this.editorial=editorial;
		this.coleccion=coleccion;
		this.numeroPaginas=numeroPaginas;
		this.precio=new BigDecimal (precio);
		this.autores=autores;
		this.color=color;
		this.cantidad=cantidad;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematicaEnum
	 * @return El tematicaEnum asociado a la clase
	 */
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematicaEnum
	 * @param tematicaEnum El nuevo tematicaEnum a modificar.
	 */
	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estadoEnum 
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum=estadoEnum;
		
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\nID: ");
        sb.append(id);
        sb.append("\nNombre del comic: ");
        sb.append(nombre);
        sb.append("\nEditorial: ");
        sb.append(editorial);
        sb.append("\nTemática: ");
        sb.append(tematicaEnum);
        sb.append("\nColección: ");
        sb.append(coleccion);
        sb.append("\nPáginas: ");
        sb.append(numeroPaginas);
        sb.append("\n:Precio ");
        sb.append(precio);
        sb.append("\nAutores: ");
        sb.append(autores);
        sb.append("\nA color: ");
        sb.append(color);
        sb.append("\nCantidad disponible: ");
        sb.append(cantidad);
        sb.append("\nEstado: ");
        sb.append(estadoEnum);
        
        return sb.toString();
	}


	
	
	
	
	
	
}
