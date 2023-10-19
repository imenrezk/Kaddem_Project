import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { ListComponent } from './list/list.component';
import{NbretudiantComponent} from './nbretudiant/nbretudiant.component'
import{ DetailetudiantComponent }from'./detailetudiant/detailetudiant.component'
const routes: Routes = [
  {path:'list',component:ListComponent},
  {path:'addetudiant',component:AddComponent},
  {path:'edit',component:EditComponent},
  {path:'nbretudiantpardepartement',component:NbretudiantComponent},
  {path:'detailetudiant',component:DetailetudiantComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EtudiantRoutingModule { }
