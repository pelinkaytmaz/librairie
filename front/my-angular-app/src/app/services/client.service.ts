import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:8080/api/clients'; // URL de ton backend

  constructor(private http: HttpClient) {}

  // Ajouter un client
  ajouterClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.apiUrl, client);
  }

  // Modifier un client
  modifierClient(client: Client): Observable<Client> {
    return this.http.put<Client>(`${this.apiUrl}/${client.id}`, client);
  }

  // Supprimer un client
  supprimerClient(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // Rechercher un client par nom
  rechercherClientParNom(nom: string): Observable<Client> {
    return this.http.get<Client>(`${this.apiUrl}/recherche?nom=${nom}`);
  }

  // Récupérer tous les clients
  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiUrl);
  }
}
