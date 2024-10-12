import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommandeListComponent } from './components/commande-list/commande-list.component';
import { CommandeFormComponent } from './components/commande-form/commande-form.component';

const routes: Routes = [
  { path: '', component: CommandeListComponent },
  { path: 'add', component: CommandeFormComponent },
  { path: 'edit/:id', component: CommandeFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
