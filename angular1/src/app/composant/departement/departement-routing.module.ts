import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListdepartementComponent } from './listdepartement/listdepartement.component';
import{ AdddepartementComponent } from './adddepartement/adddepartement.component'
import { EditdepartementComponent } from './editdepartement/editdepartement.component';
const routes: Routes = [
  {path:'listdepartement',component:ListdepartementComponent},
  {path:'adddepartement',component:AdddepartementComponent},
  {path:'editdepartement',component:EditdepartementComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartementRoutingModule { }
