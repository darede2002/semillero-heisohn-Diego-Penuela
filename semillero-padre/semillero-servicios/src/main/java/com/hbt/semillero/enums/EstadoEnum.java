/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina el estado del comic
 * <b>Caso de Uso:<b> semillero 2021
 * @author Diego
 * @version 
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo"),
	;
	
	
	
	private String descripcion;
	
	EstadoEnum(String descripcion){
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
