import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { universite } from 'src/app/module/universite';
import{ ServiceuniversiteService } from '../Service/serviceuniversite.service'
@Component({
  selector: 'app-listuniversite',
  templateUrl: './listuniversite.component.html',
  styleUrls: ['./listuniversite.component.css']
})
export class ListuniversiteComponent implements OnInit {
  universites!: universite[];
  universite :universite=new universite();
  title ='pagination';
  page: number=1;
  count: number=0;
tableSize: number = 5; 
tableSizes: any = [5, 10, 15, 20]; 
  constructor(private service: ServiceuniversiteService,private router: Router) { }

  ngOnInit(): void {
    this.service.getUniversite()
    .subscribe(data => {
      this.universites = data;
    });
  }
  onTableDataChange (universite: any){
    this.page=universite;
    this.service.getUniversite();
   }
  Editar(universite:universite):void{
    localStorage.setItem("idUniv",universite.idUniv.toString());
    this.router.navigate(["universite/edituniversite"]);
  }


    Delete(universite:universite){
      this.service.deleteUniversite(universite)
      .subscribe(data=>{
        this.universites=this.universites.filter(p=>p!==universite);
        alert("universite supprimé...");
      })
    }
    Listar(){
      this.router.navigate(["universite/listuniversite"]);
    }
    Nuevo(){
      this.router.navigate(["universite/adduniversite"]);
      
    }
    tri(){
      this.service.tri()
      .subscribe(data => {
        this.universites = data;
      });
      this.router.navigate(["universite/listuniversite"]);
     }
     
     rechercher (nomUniv :String){
      this.service.retrieveUniversiteBynom(nomUniv).subscribe(data =>{
        this.universites=data ;
      },error=>{
        console.log(error);
      })
   
    }

}
