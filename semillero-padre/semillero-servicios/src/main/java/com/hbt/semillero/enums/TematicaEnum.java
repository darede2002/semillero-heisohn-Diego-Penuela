package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Clase que determina la enumeroacion para los tipos de tematicas aceptados por la clase Comic
 * <b>Caso de Uso:<b> sEMILLERO 2021
 * @author Diego
 * @version
 */
public enum TematicaEnum {
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica."),
	HISTORICO("enum.tematica."),
	HORROR("enum.tematica."),
	HUMORISTICO("enum.tematica."),
	;
	
	private String descripcion;
	
	TematicaEnum(String descripcion){
		this.descripcion = descripcion;
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de retornar el atributo descripcion
	 * @return descripcion asociado a la clase
	 * @author Diego
	 * 
	 * @return
	 */
	public String getDEscripcion() {
		return descripcion;
	}

}
