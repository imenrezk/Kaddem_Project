import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { universite } from 'src/app/module/universite';
import { ServiceuniversiteService } from '../Service/serviceuniversite.service';

@Component({
  selector: 'app-edituniversite',
  templateUrl: './edituniversite.component.html',
  styleUrls: ['./edituniversite.component.css']
})
export class EdituniversiteComponent implements OnInit {
  universite :universite=new universite();
  constructor(private router:Router,private service:ServiceuniversiteService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.Editar();
  }
  Editar(){
    let idUniv=localStorage.getItem("idUniv");
    this.service.getUniversiteId(+idUniv!)
    .subscribe(data=>{
      this.universite=data;
    })
  }
  Actualizar(universite:universite){
    this.service.updateUniversite(universite)
    .subscribe(data=>{
      this.universite=data;
      alert("Mis à jour avec succés...!!!");
      this.router.navigate(["universite/Listuniversite"]);
    })
  }

}
