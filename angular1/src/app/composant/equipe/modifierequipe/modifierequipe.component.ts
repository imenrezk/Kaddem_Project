import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { equipe } from 'src/app/module/equipe';
import { ServiceEquipeService } from '../Service/service-equipe.service';

@Component({
  selector: 'app-modifierequipe',
  templateUrl: './modifierequipe.component.html',
  styleUrls: ['./modifierequipe.component.css']
})
export class ModifierequipeComponent implements OnInit {
  equipe :equipe=new equipe();
  niveau:string="Customer";
  constructor(private router:Router,private service:ServiceEquipeService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.Editar();
  }
  Editar(){
    let idEquipe=localStorage.getItem("idEquipe");
    this.service.getEquipeId(+idEquipe!)
    .subscribe(data=>{
      this.equipe=data;
    })
  }

  Actualizar(equipe:equipe){
    this.service.updateEquipe(equipe)
    .subscribe(data=>{
      this.equipe=data;
      alert("Mis à jour avec succés...!!!");
      this.router.navigate(["equipe/listequipe"]);
    })
  }

}
