import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { universite } from 'src/app/module/universite';

@Injectable({
  providedIn: 'root'
})
export class ServiceuniversiteService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8083/Universite/universite';
  Url1='http://localhost:8083/Universite/triUni';
Url2='http://localhost:8083/Universite/retrieveUniversiteBynom';
  getUniversite(){
    return this.http.get<universite[]>(this.Url);
  }
  createUniversite(universite:universite){
    return this.http.post<universite>(this.Url,universite);
  }
  getUniversiteId(idUniv:number){
    return this.http.get<universite>(this.Url+"/"+idUniv);
  }
  updateUniversite(universite:universite){
    return this.http.put<universite>(this.Url,universite);
  }
  deleteUniversite(universite:universite){
    return this.http.delete<universite>(this.Url+"/"+universite.idUniv);
  }
  public tri(){
    return this.http.get<universite[]>(this.Url1)
  }

  public retrieveUniversiteBynom(nomUniv:String){
    return this.http.get<universite[]>(this.Url2+"/"+nomUniv);
  }

  

}