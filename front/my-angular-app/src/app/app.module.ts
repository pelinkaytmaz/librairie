import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app/components';
import { CommandeFormComponent } from './components/commande-form/commande-form.component';
import { CommandeListComponent } from './components/commande-list/commande-list.component';
import { CommandeService } from './services/commande.service';

@NgModule({
  declarations: [
    AppComponent,
    CommandeFormComponent,
    CommandeListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [CommandeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

