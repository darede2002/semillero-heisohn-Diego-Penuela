package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.consultarComicTamanioNombreComicDTO;

public interface IGestionarCompraComicLocal {
	
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	public ResultadoDTO actualizarComic(Long idComic);
	
	//public ResultadoDTO eliminarComic(Long idComic);
	
	public List<ComicDTO> consultarComics();
	
	public consultarComicTamanioNombreComicDTO consultarComicTamanioNombre(Short lengthCadena);
	
	

}
