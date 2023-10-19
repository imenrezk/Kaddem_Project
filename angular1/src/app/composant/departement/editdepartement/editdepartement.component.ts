import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { departement } from 'src/app/module/departement';
import { ServicedepartementService } from '../Service/servicedepartement.service';


@Component({
  selector: 'app-editdepartement',
  templateUrl: './editdepartement.component.html',
  styleUrls: ['./editdepartement.component.css']
})
export class EditdepartementComponent implements OnInit {
  departement :departement=new departement();
  constructor(private router:Router,private service:ServicedepartementService) { }

  ngOnInit(): void {
    this.Editar();
  }
  Editar(){
    let idDepart=localStorage.getItem("idDepart");
    this.service.getDepartementId(+idDepart!)
    .subscribe(data=>{
      this.departement=data;
    })

  }
  Actualizar(departement:departement){
    this.service.updateDepartement(departement)
    .subscribe(data=>{
      this.departement=data;
      alert("Mis à jour avec succés...!!!");
      this.router.navigate(["departement/listdepartement"]);
    })
  }
}
