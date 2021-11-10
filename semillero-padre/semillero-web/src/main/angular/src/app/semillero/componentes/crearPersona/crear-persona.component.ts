import { Component, OnInit } from '@angular/core';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';

@Component({
  selector: 'crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  private nombreInstructor : string = "Pepito";

  public listaComics : Array<ComicDTO>;

  public urlImagen : string;

  constructor() { }

  ngOnInit() {
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";
    this.listaComics = new Array<ComicDTO>();
    this.nombreInstructor = "Diego Alvarez";
    let edadInstructor : number = 33;

    if ( edadInstructor < 33 ) {
      let resultadoCalculo = 12;
      let resultado = edadInstructor + resultadoCalculo;
    }
    let concat = "";
    for (let index = 0; index < this.nombreInstructor.length; index++) {
      let element = this.nombreInstructor[index];
      concat += "" + element;
      
    }
    this.nombreInstructor = this.obtenerNombre();

  }

  public simularCrearComic() : void {
    let comic3 = new ComicDTO();
    let comic1 : any = {
      id : 1,
      nombre : "Superman",
      tematica : "AVENTURAS",
      precio : 300
    }

    let comic2 : any = {
      id : 2,
      nombre : "Dr. Strange",
      tematica : "AVENTURAS",
      precio : 500
    }

    comic3.id = 3;
    comic3.nombre = "Champulin colorado";
    comic3.precio = 200;
    comic3.tematicaEnum = "COMEDIA";


    this.listaComics.push(comic1);
    this.listaComics.push(comic2);
    this.listaComics.push(comic3);

    this.listaComics.forEach(comic => {
      console.log("Comic con nombre: " + comic.nombre + " con precio de: " + comic.precio);
    });
  }

  public obtenerNombre() : string {
    this.nombreInstructor = "Shakira";
    let nombreInstructor = "Juanes";
    let apellidoInstructor = "Barrera";
    return nombreInstructor + apellidoInstructor;
  }

}
