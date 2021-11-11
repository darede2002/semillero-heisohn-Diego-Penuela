package com.hbt.semillero.dto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaLengthNombreComicDTO extends ResultadoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> comicsSuperanTamanio;
	private List<String> comicsNoSuperanTamanio;
	
	public ConsultaLengthNombreComicDTO() {
		this.comicsNoSuperanTamanio = new ArrayList<>();
		this.comicsSuperanTamanio = new ArrayList<>();
	}
	
	public List<String> getComicsSuperanTamanio() {
		return comicsSuperanTamanio;
	}
	public void setComicsSuperanTamanio(List<String> comicsSuperanTamanio) {
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}
	public List<String> getComicsNoSuperanTamanio() {
		return comicsNoSuperanTamanio;
	}
	public void setComicsNoSuperanTamanio(List<String> comicsNoSuperanTamanio) {
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
	}
	
}
