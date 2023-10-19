import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipeRoutingModule } from './equipe-routing.module';
import { AjouterequipeComponent } from './ajouterequipe/ajouterequipe.component';
import { ListequipeComponent } from './listequipe/listequipe.component';
import { ModifierequipeComponent } from './modifierequipe/modifierequipe.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgxPaginationModule } from 'ngx-pagination';
@NgModule({
  declarations: [
    AjouterequipeComponent,
    ListequipeComponent,
    ModifierequipeComponent
  ],
  imports: [
    CommonModule,
    EquipeRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
  ]
})
export class EquipeModule { }
