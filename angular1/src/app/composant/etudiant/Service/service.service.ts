import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { departement } from 'src/app/module/departement';
import { etudiant } from 'src/app/module/etudiant';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8083/Etudiant/etudiant';
  Url2='http://localhost:8083/Etudiant/getetudiantbydepartement';
  Url1='http://localhost:8083/Departementt/departement';
  url4='http://localhost:8083/Etudiant/trietudiant'
  Url3='http://localhost:8083/Etudiant/retrieveEtudiantByoption';
  url5='http://localhost:8083/Etudiant/nbretudiantpardepartementtt';
  getEtudiant(){
    return this.http.get<etudiant[]>(this.Url);
  }
  getDepartement(){
    return this.http.get<departement[]>(this.Url1);
  }
  createEtudiant(etudiant:etudiant){
    return this.http.post<etudiant>(this.Url,etudiant);
  }
  getEtudiantId(idEtudiant:number){
    return this.http.get<etudiant>(this.Url+"/"+idEtudiant);
  }
  updateEtudiant(etudiant:etudiant){
    return this.http.put<etudiant>(this.Url,etudiant);
  }
  deleteEtudiant(etudiant:etudiant){
    return this.http.delete<etudiant>(this.Url+"/"+etudiant.idEtudiant);
  }
  public findAllByOption(option: String){
    return this.http.get<etudiant[]>(this.Url3+"/"+option);
  }

  public findAllByDepartement(idDepart:number){
    return this.http.get<etudiant[]>(this.Url2+"/"+idDepart);
  }

  public tri(){
    return this.http.get<etudiant[]>(this.url4)
  }
  public NbrEtudiant(idDepart:number){
    return this.http.get<number>(this.url5+"/"+idDepart)
  }
}