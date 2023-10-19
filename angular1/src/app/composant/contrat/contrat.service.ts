import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contrat } from 'src/app/models/Contrat';

@Injectable({
  providedIn: 'root',
})
export class ContratService {
  private url = 'http://localhost:8083/contrat';
  private url1='http://localhost:8083/contrat/add';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Contrat[]> {
    return this.httpClient.get<Contrat[]>(this.url + '/getAll');
  }

  public delete(id: number) {
    return this.httpClient.delete(this.url + '/delete/' + id);
  }

  public insert(contrat: Contrat): Observable<Contrat> {
    return this.httpClient.post<Contrat>(this.url + '/add', contrat);
  }

  public update(contrat: Contrat) {
    return this.httpClient.put<Contrat>(this.url + '/update', contrat);
  }

  public getChiffreAffaireEntreDeuxDate(
    startDate: Date,
    endDate: Date,
    contrats: Contrat[]
  ) {
    return contrats
      .filter((contrat) => {
        return (
          new Date(contrat.dateDebut) <= endDate &&
          new Date(contrat.dateFin) >= startDate
        );
      })
      .reduce((a, contrat) => {
        let montant = 0;

        let start = contrat.dateDebut;
        let end = contrat.dateFin;

        if (new Date(contrat.dateDebut) < startDate) start = startDate;

        if (new Date(contrat.dateFin) > endDate) end = endDate;

        const diffInMonths = this.getDiffDatesInMonths(start, end);
        montant = diffInMonths * this.getTarifReglement(contrat);
        console.log(
          diffInMonths + '*' + this.getTarifReglement(contrat) + '=' + montant
        );

        return a + montant;
      }, 0);
  }

  public getDiffDatesInMonths(start: Date, end: Date): number {
    const diffYear =
      new Date(end).getFullYear() - new Date(start).getFullYear();
    return (
      diffYear * 12 + new Date(end).getMonth() - new Date(start).getMonth() + 1
    );
  }

  public getTarifReglement(contrat: Contrat): number {
    let tarif = 0;

    switch (contrat.specialite) {
      case 'IA': {
        tarif = 300;
        break;
      }
      case 'RESEAUX': {
        tarif = 350;
        break;
      }
      case 'CLOUD': {
        tarif = 400;
        break;
      }
      case 'SECURITE': {
        tarif = 450;
        break;
      }
      default: {
        tarif = 0;
        break;
      }
    }
    return tarif;
  }
}
