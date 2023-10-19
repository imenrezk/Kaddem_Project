import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:"etudiant", loadChildren:()=>import('./composant/etudiant/etudiant.module').then(m=>m.EtudiantModule)},
  {path:"departement", loadChildren:()=>import('./composant/departement/departement.module').then(m=>m.DepartementModule)},
  {path:"universite", loadChildren:()=>import('./composant/universite/universite.module').then(m=>m.UniversiteModule)},
  {path:"equipe", loadChildren:()=>import('./composant/equipe/equipe.module').then(m=>m.EquipeModule)},
  {
    path: 'contrat',
    loadChildren: () =>
      import('./composant/contrat/contrat.module').then(
        (m) => m.ContratModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
