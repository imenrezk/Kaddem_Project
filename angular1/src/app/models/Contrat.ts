export class Contrat {
    id!: number;
    dateDebut!: Date;
    dateFin!: Date;
    specialite!: string;
    archive!: boolean;
    montant!: number;
  
    constructor() {}
  
    public setContrat(
      dateDebut: Date,
      dateFin: Date,
      specialite: string,
      archive: boolean,
      montant: number,
      id?: number
    ) {
      this.dateDebut = dateDebut;
      this.dateFin = dateFin;
      this.specialite = specialite;
      this.archive = archive;
      this.montant = montant;
      if (id) {
        this.id = id;
      }
    }
  }
  