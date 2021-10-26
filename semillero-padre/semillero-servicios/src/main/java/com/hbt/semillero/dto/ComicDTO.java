package com.hbt.semillero.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hbt.semillero.enums.TematicaEnum;

public class ComicDTO {
	
	
	private static final Long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String editorial;
	private TematicaEnum tematicaEnum;
	private String colecion;
	private Integer numeroPaginas;
	private BigDecimal precio;
	private String autores;
	private Boolean color;
	private LocalDate fechaVenta;
	private String estado;
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
	public String getColecion() {
		return colecion;
	}
	public void setColecion(String colecion) {
		this.colecion = colecion;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
