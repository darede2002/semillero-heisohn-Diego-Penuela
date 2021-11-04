package com.hbt.semillero.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.enums.EstadoEnum;

//import javax.persistence.Column;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;

import com.hbt.semillero.enums.TematicaEnum;

public class ComicDTO extends ResultadoDTO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final Long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String editorial;
	private TematicaEnum tematicaEnum;
	private String coleccion;
	private Integer numeroPaginas;
	private BigDecimal precio;
	private String autores;
	private Boolean color;
	private LocalDate fechaVenta;
	private EstadoEnum estadoEnum;
	private Integer cantidad;
	public Long getId() {
		return id;
	
		
		
	
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}
	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public Boolean getColor() {
		return color;
	}
	public void setColor(Boolean color) {
		this.color = color;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}
	public void setEstadoEnum(EstadoEnum estado) {
		this.estadoEnum = estado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the serialversionuid
	 */
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

}
