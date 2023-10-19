import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { departement } from 'src/app/module/departement';
import { etudiant } from 'src/app/module/etudiant';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
 etudiants!: etudiant[];
  idEtudiant!:number;
 etudiant :etudiant=new etudiant();
  departements!:departement[];
  title ='pagination';
  page: number=1;
  count: number=0;
tableSize: number = 5; 
tableSizes: any = [5, 10, 15, 20]; 
//public etudiants!:any[];  
//etudiant:any = new etudiant(); 
  constructor(private service: ServiceService,private router: Router,private route: ActivatedRoute) { }
 
  
  
  ngOnInit(): void {
    this.service.getEtudiant()
    .subscribe(data => {
      this.etudiants = data;
    });
  }


  onTableDataChange (etudiant: any){
    this.page=etudiant;
    this.service.getEtudiant();
   }
   
  Editar(etudiant:etudiant):void{
    localStorage.setItem("idEtudiant",etudiant.idEtudiant.toString());
    this.router.navigate(["etudiant/edit"]);
  }
  
    Delete(etudiant:etudiant){
      this.service.deleteEtudiant(etudiant)
      .subscribe(data=>{
        this.etudiants=this.etudiants.filter(p=>p!==etudiant);
        alert("Etudiant supprimé...");
      })
    }
    Listar(){
      this.router.navigate(["etudiant/list"]);
    }
    Nuevo(){
      this.router.navigate(["etudiant/addetudiant"]);
    }


    nbr(){
      this.router.navigate(["etudiant/nbretudiantpardepartement"]);
    }
    detail(){
      this.router.navigate(["etudiant/detailetudiant"]); 
    }
   
    
 tri(){
  this.service.tri()
  .subscribe(data => {
    this.etudiants = data;
  });
  this.router.navigate(["etudiant/list"]);
 }

    onChangeSelect(option:String) {
      this.service.findAllByOption(option).subscribe(data =>{
        this.etudiants=data ;
      },error=>{
        console.log(error);
      })
    }

    rechercher (idDepart :number){
      this.service.findAllByDepartement(idDepart).subscribe(data =>{
        this.etudiants=data ;
      },error=>{
        console.log(error);
      })
      this.router.navigate(["etudiant/list"]);
    }
}
