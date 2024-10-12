import { Component, OnInit } from '@angular/core';
import { Commande } from '../../models/commande.model';
import { CommandeService } from '../../services/commande.service';

@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.css'],
})
export class CommandeListComponent implements OnInit {
  commandes: Commande[] = [];

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.commandeService.getCommandes().subscribe((data) => {
      this.commandes = data;
    });
  }

  supprimerCommande(id: number): void {
    this.commandeService.supprimerCommande(id).subscribe(() => {
      this.commandes = this.commandes.filter((commande) => commande.commande_id !== id);
    });
  }
}
