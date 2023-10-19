import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { equipe } from 'src/app/module/equipe';
import { ServiceEquipeService } from '../Service/service-equipe.service';

@Component({
  selector: 'app-ajouterequipe',
  templateUrl: './ajouterequipe.component.html',
  styleUrls: ['./ajouterequipe.component.css']
})
export class AjouterequipeComponent implements OnInit {
  equipe:equipe=new equipe();
  myForm!: FormGroup;
  
  constructor(private service:ServiceEquipeService,private router: Router) { }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      nomEquipe: new FormControl('', [Validators.required, Validators.minLength(2)]),
      nbmax:new FormControl('', [Validators.required, Validators.pattern("^[0-9]*")]),
      niveau:new FormControl('', ),
      mail:new FormControl('',[Validators.required,Validators.pattern("^[a-zA-Z0-9._-]+@gmail.com")]),
  })
  }


get nomEquipe() {
  return this.myForm.controls["nomEquipe"];
}
get nbmax() {
  return this.myForm.controls["nbmax"];
}
get niveau() {
  return this.myForm.controls["niveau"];
}

get mail() {
  return this.myForm.controls["mail"];
}
onSubmit(){
  this.service.createEquipe(this.equipe).subscribe(data=>{
    alert("Equipe ajoutée avec succès...!!!");
    this.router.navigate(["equipe/listequipe"]);
  })
  this.myForm.reset();
}


}
