import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { equipe } from 'src/app/module/equipe';

@Injectable({
  providedIn: 'root'
})
export class ServiceEquipeService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8083/Equipe/equipe';
  Url1='http://localhost:8083/Equipe/triequipe';
  
  getEquipes(){
    return this.http.get<equipe[]>(this.Url);
  }
  createEquipe(equipe:equipe){
    return this.http.post<equipe>(this.Url,equipe);
  }
  getEquipeId(idEquipe:number){
    return this.http.get<equipe>(this.Url+"/"+idEquipe);
  }
  updateEquipe(equipe:equipe){
    return this.http.put<equipe>(this.Url,equipe);
  }
  deleteEquipe(equipe:equipe){
    return this.http.delete<equipe>(this.Url+"/"+equipe.idEquipe);
  }
  public tri(){
    return this.http.get<equipe[]>(this.Url1)
  }
  public getIdEquipe (id:any){
    return this.http.get(this.Url+id)
  }
}