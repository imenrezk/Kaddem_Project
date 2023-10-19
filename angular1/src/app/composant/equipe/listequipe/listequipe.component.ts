import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { equipe } from 'src/app/module/equipe';
import { ServiceEquipeService } from '../Service/service-equipe.service';

@Component({
  selector: 'app-listequipe',
  templateUrl: './listequipe.component.html',
  styleUrls: ['./listequipe.component.css']
})
export class ListequipeComponent implements OnInit {
  public equipes!:any[];  
  equipe:any = new equipe(); 
  title ='pagination';
  page: number=1;
count: number=0;
tableSize: number = 5; 
tableSizes: any = [5, 10, 15, 20]; 
name ="Equipes"

EquipeById : any ={
  idEquipe:"",
  nomEquipe:"",
  niveau :"",
  nbmax : "",
  mail :""
}


iEquipe! : number 

  constructor(private service:ServiceEquipeService,private router: Router) { }

  public getEquipes():void{
    this.service.getEquipes().subscribe(
      (response:any[])=>{
        this.equipes=response;
        console.log(response);
      },
        (error:HttpErrorResponse)=>
        {
          alert(error.message);
        }
      );
    
    
  }
  onTableDataChange (equipe: any){
    this.page=equipe;
    this.getEquipes();
   }
   

  ngOnInit(): void {
    this.getEquipes();
  }

  Delete(equipe:equipe){
    this.service.deleteEquipe(equipe)
    .subscribe(data=>{
      this.equipes=this.equipes.filter(p=>p!==equipe);
      alert("Equipe supprimée...");
    })
  }
  Editar(equipe:equipe):void{
    localStorage.setItem("idEquipe",equipe.idEquipe.toString());
    this.router.navigate(["equipe/modifierequipe"]);
  }
  
  tri(){
    this.service.tri()
    .subscribe(data => {
      this.equipes = data;
    });
    this.router.navigate(["equipe/listequipe"]);
   }
  
    
    
    ajouter(){
      
      this.router.navigate(['equipe/ajouterequipe']);
    }

    getEquipebyId (){
      this.service.getEquipeId(this.iEquipe).subscribe(
        (data:any)=>{
          this.EquipeById=data;
          console.log("ok");
          console.log(this.EquipeById)

        },
        (error)=>{
          console.log("non")
          console.log(error)

        }
      )
    }

}



