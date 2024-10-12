import { Component, OnInit } from '@angular/core';
import { Commande } from '../../models/commande.model';
import { CommandeService } from '../../services/commande.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-commande-form',
  templateUrl: './commande-form.component.html',
  styleUrls: ['./commande-form.component.css'],
})
export class CommandeFormComponent implements OnInit {
  commande: Commande = new Commande(0, 0, '', 0, ''); // Initialisation d'une commande vide
  isEditMode: boolean = false;

  constructor(
    private commandeService: CommandeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.commandeService.getCommandeById(+id).subscribe((data) => {
        this.commande = data;
      });
    }
  }

  onSubmit(): void {
    if (this.isEditMode) {
      this.commandeService.modifierCommande(this.commande).subscribe(() => {
        this.router.navigate(['/commandes']);
      });
    } else {
      this.commandeService.ajouterCommande(this.commande).subscribe(() => {
        this.router.navigate(['/commandes']);
      });
    }
  }
}
