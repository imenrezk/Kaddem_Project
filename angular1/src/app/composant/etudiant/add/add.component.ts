import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { departement } from 'src/app/module/departement';
import { etudiant } from 'src/app/module/etudiant';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  etudiant:etudiant=new etudiant();
  departement:departement=new departement();
  departements!: departement[];
  myForm!: FormGroup;
  form!: FormGroup;
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.service.getDepartement()
    .subscribe(data => {
      this.departements = data;
    })
    this.myForm = new FormGroup({
      prenomE: new FormControl('', [Validators.required, Validators.minLength(2)]),
      nomE: new FormControl('', [Validators.required, Validators.minLength(2)]),
      option:new FormControl('',),
      idDepart:new FormControl('',)
  })
  }
  get prenomE() {
    return this.myForm.controls["prenomE"];
  }
  
  get option() {
    return this.myForm.controls["option"];
  }
  get nomE() {
    return this.myForm.controls["nomE"];
  }
  
  get idDepart() {
    return this.myForm.controls["idDepart"];
  }
  onSubmit(){
    this.service.createEtudiant(this.etudiant)
    .subscribe(data=>{
      alert("Ajouté Etudiant avec succès...!!!");
      this.router.navigate(["etudiant/list"]);
    })
    this.myForm.reset();
  }

}
