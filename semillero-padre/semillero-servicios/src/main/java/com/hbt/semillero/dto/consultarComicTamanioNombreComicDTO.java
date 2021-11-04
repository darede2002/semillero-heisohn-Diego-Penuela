package com.hbt.semillero.dto;

public class consultarComicTamanioNombreComicDTO extends ResultadoDTO {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short lengthComic;
	private String nombre;
	
	public consultarComicTamanioNombreComicDTO() {
		//constructor vacio
	}
	
	public consultarComicTamanioNombreComicDTO(Short lengthComic) {
		this.setTamanio(lengthComic);
		
	}

	/**
	 * @return the lengthComic
	 */
	public Short getTamanio() {
		return lengthComic;
	}

	/**
	 * @param tamanio the lengthComic to set
	 */
	public void setTamanio(Short lengthComic) {
		this.lengthComic = lengthComic;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
