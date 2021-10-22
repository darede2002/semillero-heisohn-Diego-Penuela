import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit {
  
  public urlImagen : string;
  
  constructor(private router : Router, private activatedRoute: ActivatedRoute) {
    console.log("entro al constructor del componente bienvenida");
  }

  ngOnInit(): void {
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";
    let data = this.activatedRoute.snapshot.params;
    
    console.log("Parametros recibidos " + data);
    
  }

  public ejecucionEventoClick( parametroEvento : any, numero : number ) : void {
    alert("Hola: " + parametroEvento + ' ' + numero);
    
  }

}