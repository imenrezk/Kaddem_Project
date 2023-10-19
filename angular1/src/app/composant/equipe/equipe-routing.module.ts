import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterequipeComponent } from './ajouterequipe/ajouterequipe.component';
import { ListequipeComponent } from './listequipe/listequipe.component';
import { ModifierequipeComponent } from './modifierequipe/modifierequipe.component';

const routes: Routes = [
  {path:'listequipe',component:ListequipeComponent},
  {path:'ajouterequipe',component:AjouterequipeComponent},
  {path:'modifierequipe',component:ModifierequipeComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EquipeRoutingModule { }
