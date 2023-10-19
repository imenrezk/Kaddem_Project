import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { departement } from 'src/app/module/departement';
import { ServicedepartementService } from '../Service/servicedepartement.service';

@Component({
  selector: 'app-adddepartement',
  templateUrl: './adddepartement.component.html',
  styleUrls: ['./adddepartement.component.css']
})
export class AdddepartementComponent implements OnInit {
  departement:departement=new departement();
  myForm!: FormGroup;
  constructor(private router:Router, private service:ServicedepartementService) { }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      nomDepartement: new FormControl('', [Validators.required, Validators.minLength(1)]),
      nbrEmployes: new FormControl('', [Validators.required, Validators.pattern("[0-9]*")]),
    
  })
  }

get nomDepartement() {
  return this.myForm.controls["nomDepartement"];
}

get nbrEmployes() {
  return this.myForm.controls["nbrEmployes"];
}

onSubmit(){
  this.service.createDepartement(this.departement)
  .subscribe(data=>{
    alert("Ajouté Depatement avec succès...!!!");
    this.router.navigate(["departement/listdepartement"]);
  })
  this.myForm.reset();
}

}
