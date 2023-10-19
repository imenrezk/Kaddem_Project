import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { departement } from 'src/app/module/departement';
import { ServicedepartementService } from '../Service/servicedepartement.service';

@Component({
  selector: 'app-listdepartement',
  templateUrl: './listdepartement.component.html',
  styleUrls: ['./listdepartement.component.css']
})
export class ListdepartementComponent implements OnInit {
  departements!: departement[];
  title ='pagination';
  page: number=1;
  count: number=0;
tableSize: number = 5; 
tableSizes: any = [5, 10, 15, 20]; 
  constructor(private service:ServicedepartementService, private router: Router) { }

  ngOnInit(): void {
    this.service.getdepartement()
    .subscribe(data => {
      this.departements = data;
    });
  }

  onTableDataChange (departement: any){
    this.page=departement;
    this.service.getdepartement();
   }

  Editar(departement:departement):void{
    localStorage.setItem("idDepart",departement.idDepart.toString());
    this.router.navigate(["departement/editdepartement"]);
  }

  Delete(departement:departement){
    this.service.deleteDepartement(departement)
    .subscribe(data=>{
      this.departements=this.departements.filter(p=>p!==departement);
      alert("Departement supprimé...");
    })
  }
  List(){
    this.router.navigate(["departement/listdepartement"]);
  }
  ajouter(){
    this.router.navigate(["departement/adddepartement"]);
    
  }
  tri(){
    this.service.tri()
    .subscribe(data => {
      this.departements = data;
    });
    this.router.navigate(["departement/listdepartement"]);
   }

   rechercher (nomDepartement :String){
    this.service.retrieveDepartementBynom(nomDepartement).subscribe(data =>{
      this.departements=data ;
    },error=>{
      console.log(error);
    })
    
  }

}
