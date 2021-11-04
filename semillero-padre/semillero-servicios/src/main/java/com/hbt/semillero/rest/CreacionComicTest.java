/**
 * CreacionComicTest.java
 */
package com.hbt.semillero.rest;
import java.util.ArrayList;
import java.util.Scanner;

import com.hbt.semillero.entidad.Comic;

/**
 * <b>Descripción:<b> Clase que determina la creación de comic para las pruebas
 * <b>Caso de Uso:<b> semillero 2021
 * @author Diego
 * @version 
 */

/**
public class CreacionComicTest {
	
	
	static Scanner sc = new Scanner(System.in);
	 //Se crea un ArrayList para guardar objetos de tipo Comic.
    static ArrayList<Comic> comics = new ArrayList();
	
    // metodo main

    public static void main(String[] args) {
    	listaActivos(comics);
    	ListaInactivos(comics);
    	
    	
    }// fin del metodo main
    
    public static void listaActivos(comics) {
    	
    		
    }
			
	

}

 * pendientes código
 * construir array de prueba
 * 3.1 Antes de ejecutar las pruebas unitarias, se deben crear 10 comics, haciendo uso de set o haciendo uso de constructores. Esos 10 comics se adicionaran a una lista y algunos deberán contener el estado activo y otros el estado inactivo (la cantidad que uds quieran).
 *3.2 Crear dos métodos privados, uno para verificar los comics que se encuentran activos y otro para verificar los comics inactivos, estos deberán retornar una lista con los activos e inactivos respectivamente.
 *3.3 Para el método de comics activos, se debe filtrar los que son activos haciendo uso del enumerador para comparar el estado y el método debe retornar una lista con solo los comics activos.
 *3.4 Adicional a esto se debe crear una prueba unitaria que permita comprobar que si se están listando solo comics en estado activo, hacer uso de la Clase System.out.println para imprimir todas las propiedades del comic y poderlas visualizar en consola.
 *4. Para el método que comprueba los comics inactivos, se debe crear una excepción indicando el siguiente mensaje “Se ha detectado que de ” + tamanioListaTotal + “ comics se encontraron que ” + numeroTotalActivos + “  se encuentran activos y ” + numeroTotalInactivos + “ inactivos. Los comics inactivos son: ” + nombresComicsInacivos.
 *5. Realizar prueba unitaria para capturar el mensaje de error producido.

 * 
 */
