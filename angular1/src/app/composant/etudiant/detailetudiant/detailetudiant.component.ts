import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { etudiant } from 'src/app/module/etudiant';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-detailetudiant',
  templateUrl: './detailetudiant.component.html',
  styleUrls: ['./detailetudiant.component.css']
})
export class DetailetudiantComponent implements OnInit {
  idEtudiant!:number;
  etudiant :etudiant=new etudiant();
   nbEtudiants:number=0;
  constructor(private service: ServiceService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
   this.detail();
 
  } 
 detail(){
  let idEtudiant=localStorage.getItem("idEtudiant");
  this.service.getEtudiantId(+idEtudiant!)
  .subscribe(data=>{
    this.etudiant=data;
  })
 }
  

}
