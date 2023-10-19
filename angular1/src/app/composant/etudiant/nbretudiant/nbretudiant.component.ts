import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { etudiant } from 'src/app/module/etudiant';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-nbretudiant',
  templateUrl: './nbretudiant.component.html',
  styleUrls: ['./nbretudiant.component.css']
})
export class NbretudiantComponent implements OnInit {
  idDepart!:number;
  etudiant :etudiant=new etudiant();
   nbEtudiants:number=0;
  constructor(private service: ServiceService,private router: Router) { }

  ngOnInit(): void {
 
  }
  nombre(){
    this.service.NbrEtudiant(this.idDepart).subscribe(res=>{
      if(res!=null)
      this.nbEtudiants=res
    else
  this.nbEtudiants=0});
  }

}
