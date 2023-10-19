import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { universite } from 'src/app/module/universite';
import { ServiceuniversiteService } from '../Service/serviceuniversite.service';

@Component({
  selector: 'app-adduniversite',
  templateUrl: './adduniversite.component.html',
  styleUrls: ['./adduniversite.component.css']
})
export class AdduniversiteComponent implements OnInit {
  universite:universite=new universite();
  myForm!: FormGroup;
  constructor(private service: ServiceuniversiteService,private router: Router) { }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      nomUniv: new FormControl('', [Validators.required, Validators.minLength(2)]),
      diplomes: new FormControl('', [Validators.required, Validators.minLength(2)]),
   
  })
  }
  get nomUniv() {
    return this.myForm.controls["nomUniv"];
  }
  
  get diplomes() {
    return this.myForm.controls["diplomes"];
  }
onSubmit(){
    this.service.createUniversite(this.universite)
    .subscribe(data=>{
      alert("Ajouté Universite avec succès...!!!");
      this.router.navigate(["universite/Listuniversite"]);
    })
    this.myForm.reset();
  }

}
