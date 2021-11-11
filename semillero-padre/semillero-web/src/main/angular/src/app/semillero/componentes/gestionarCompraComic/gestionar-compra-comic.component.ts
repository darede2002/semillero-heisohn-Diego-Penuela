import { Component, OnInit } from '@angular/core';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';

/**
 * @description Componente encargado de gestionar la logica para gestionar compras de comics
 * @author diego Peñuela
 * @see SEMILLERO 2021
 */
@Component({
  selector: 'gestionar-compra-comic',
  templateUrl: './gestionar-compra-comic.component.html'
})
export class GestionarComicComponent implements OnInit {

  public comicDTO : ComicDTO;

  public comicDTOInfo : ComicDTO;

  public nombre : string;

  public listaComics : Array<ComicDTO>;
  
  public mostrarItem : boolean;

  constructor() { }

  ngOnInit() {
    this.mostrarItem = false;
    this.comicDTO = new ComicDTO();
    this.listaComics = new Array<ComicDTO>();
  }

  public crearComic() : void {
    this.listaComics.push(this.comicDTO);
    this.comicDTO = new ComicDTO();
    //this.limpiarDatosComic(this.comicDTO);
  }

  private limpiarDatosComic( comicDTO : ComicDTO) : void {
    comicDTO.nombre = null;
    comicDTO.coleccion = null;
    comicDTO.color = null;
    comicDTO.editorial = null;
    comicDTO.id = null;
    comicDTO.tematicaEnum = null;
    comicDTO.precio = null;
    comicDTO.numeroPaginas = null;
    comicDTO.autores = null;
  }

  public imprimirInfoComic(posicion : number) : void {
    this.mostrarItem = true;
    this.comicDTOInfo = this.listaComics[posicion];
  }

  public comprarComic(posicion : number) : void {
    this.mostrarItem = true;
    this.comicDTOInfo = this.listaComics[posicion];
    gestionarCompraComic(this.comicDTO);


  }

  public gestionarCompraComic(comicDTO : ComicDTO) : void {
    
  }

  public cerrar() : void {
    this.mostrarItem = false;
  }

}
