import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtudiantRoutingModule } from './etudiant-routing.module';
import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { EditComponent } from './edit/edit.component';
import { NbretudiantComponent } from './nbretudiant/nbretudiant.component';
import { DetailetudiantComponent } from './detailetudiant/detailetudiant.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    ListComponent,
    AddComponent,
    EditComponent,
    NbretudiantComponent,
    DetailetudiantComponent,
    
   

  ],
  imports: [
    CommonModule,
    EtudiantRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
  ]
})
export class EtudiantModule { }
