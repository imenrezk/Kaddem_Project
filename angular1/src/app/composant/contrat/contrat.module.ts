import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContratRoutingModule } from './contrat-routing.module';
import { ContratListComponent } from './contrat-list/contrat-list.component';
import { ContratFormComponent } from './contrat-form/contrat-form.component';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CaFormComponent } from './ca-form/ca-form.component';

@NgModule({
  declarations: [ContratListComponent, ContratFormComponent, CaFormComponent],
  imports: [
    CommonModule,
    ContratRoutingModule,
    DataTablesModule,
    ReactiveFormsModule,
    FormsModule,
  ],
})
export class ContratModule {}
