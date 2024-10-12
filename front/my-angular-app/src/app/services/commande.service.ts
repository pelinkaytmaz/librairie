import { Injectable } from '@angular/core'; // Ajoute ceci si ce n'est pas déjà présent
import { HttpClient } from '@angular/common/http'; // Assurez-vous également que ceci est présent
import { Observable } from 'rxjs'; // Assurez-vous que c'est également présent
import { Commande } from '../models/commande.model'; // L'import de ton modèle

@Injectable({
  providedIn: 'root',
})
export class CommandeService {
  private apiUrl = 'http://localhost:8080/api/commandes'; // URL vers l'API backend

  constructor(private http: HttpClient) {}

  // Récupérer toutes les commandes
  getCommandes(): Observable<Commande[]> {
    return this.http.get<Commande[]>(this.apiUrl);
  }

  // Ajouter une commande
  ajouterCommande(commande: Commande): Observable<Commande> {
    return this.http.post<Commande>(this.apiUrl, commande);
  }

  // Modifier une commande
  modifierCommande(commande: Commande): Observable<Commande> {
    return this.http.put<Commande>(`${this.apiUrl}/${commande.commande_id}`, commande);
  }

  // Supprimer une commande
  supprimerCommande(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // Récupérer une commande par ID
  getCommandeById(id: number): Observable<Commande> {
    return this.http.get<Commande>(`${this.apiUrl}/${id}`);
  }
}
