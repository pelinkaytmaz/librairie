export class Commande {
    constructor(
      public commande_id: number,
      public client_id: number,
      public date_commande: string,
      public montant_total: number,
      public statut: string
    ) {}
  }
  