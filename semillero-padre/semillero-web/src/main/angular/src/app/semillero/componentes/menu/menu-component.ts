import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * @description Componente encargado de gestionar los enrutamientos del menu
 * @author Diego Alvarez <dalvarez@heinsohn.com>
 * @see CU1098 Gestionar comic
 * @see Semillero 2021
 */
@Component({
  selector: 'home-page',
  templateUrl: './menu-component.html',
})
export class MenuComponent implements OnInit {

  /**
   * Constructor del componente MenuComponent
   * @param router es el encargado de manejar el enrutamiento
   */
  constructor(private router: Router) {

  }

  /**
   * Evento angular que se ejecuta al iniciar el componente
   */
  ngOnInit(): void {

  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public navegarGestionarComic(): void {
    this.router.navigate(['gestionar-comic']);
  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public navegarHome(): void {
    this.router.navigate(['bienvenida']);
  }

  public navegarGestionarCompra(): void {
    //WIP
  }
}