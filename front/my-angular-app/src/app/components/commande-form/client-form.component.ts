import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../services/client.service';
import { Client } from '../../models/client.model';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {
  client: Client = {
    nom: '',
    prenom: '',
    email: '',
    telephone: '',
    motDePasse: '',
    adresse: ''
  };

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {}

  // Ajouter ou Modifier un client
  onSubmit() {
    if (this.client.id) {
      this.clientService.modifierClient(this.client).subscribe(() => {
        console.log('Client modifié avec succès !');
      });
    } else {
      this.clientService.ajouterClient(this.client).subscribe(() => {
        console.log('Client ajouté avec succès !');
      });
    }
  }
}
