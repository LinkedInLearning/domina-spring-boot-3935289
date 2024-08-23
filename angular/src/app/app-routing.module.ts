import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MostradorComponent } from './mostrador/mostrador.component';
import { AnyadirComponent } from './anyadir/anyadir.component';

const routes: Routes = [
  { path: '', redirectTo: '/mostrador', pathMatch: 'full' },
  { path: 'mostrador', component: MostradorComponent },
  { path: 'anyadir', component: AnyadirComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
