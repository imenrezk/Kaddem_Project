import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdduniversiteComponent } from './adduniversite/adduniversite.component';
import { EdituniversiteComponent } from './edituniversite/edituniversite.component';
import { ListuniversiteComponent } from './listuniversite/listuniversite.component';

const routes: Routes = [
{path:'Listuniversite',component:ListuniversiteComponent},
{path:'adduniversite',component:AdduniversiteComponent},
{path:'edituniversite',component:EdituniversiteComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UniversiteRoutingModule { }
