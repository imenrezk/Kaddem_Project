import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { departement } from 'src/app/module/departement';

@Injectable({
  providedIn: 'root'
})
export class ServicedepartementService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8083/Departementt/departement';
  Url1='http://localhost:8083/Departementt/tridepartement';
  Url2='http://localhost:8083/Departementt/retrieveDEpartementeBynom';
  getdepartement(){
    return this.http.get<departement[]>(this.Url);
  }
  createDepartement(departement:departement){
    return this.http.post<departement>(this.Url,departement);
  }
  getDepartementId(idDepart:number){
    return this.http.get<departement>(this.Url+"/"+idDepart);
  }
  updateDepartement(departement:departement){
    return this.http.put<departement>(this.Url,departement);
  }
  deleteDepartement(departement:departement){
    return this.http.delete<departement>(this.Url+"/"+departement.idDepart);
  }
  public tri(){
    return this.http.get<departement[]>(this.Url1)
  }

  public retrieveDepartementBynom(nomDepartement:String){
    return this.http.get<departement[]>(this.Url2+"/"+nomDepartement);
  }
}
