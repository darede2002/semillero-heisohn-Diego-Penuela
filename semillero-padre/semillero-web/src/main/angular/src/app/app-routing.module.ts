import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
