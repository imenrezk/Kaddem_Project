import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { etudiant } from 'src/app/module/etudiant';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  etudiant :etudiant=new etudiant();
  myForm!: FormGroup;
  form!: FormGroup;
  option:string="Customer";
  constructor(private router:Router,private service:ServiceService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let idEtudiant=localStorage.getItem("idEtudiant");
    this.service.getEtudiantId(+idEtudiant!)
    .subscribe(data=>{
      this.etudiant=data;
    })
  }
  Actualizar(etudiant:etudiant){
    this.service.updateEtudiant(etudiant)
    .subscribe(data=>{
      this.etudiant=data;
      alert("Mis à jour avec succés...!!!");
      this.router.navigate(["etudiant/list"]);
    })
  }


}
