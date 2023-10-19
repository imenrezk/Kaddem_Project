import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartementRoutingModule } from './departement-routing.module';
import { AdddepartementComponent } from './adddepartement/adddepartement.component';
import { ListdepartementComponent } from './listdepartement/listdepartement.component';
import { EditdepartementComponent } from './editdepartement/editdepartement.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AdddepartementComponent,
    ListdepartementComponent,
    EditdepartementComponent
  ],
  imports: [
    CommonModule,
    DepartementRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
  ]
})
export class DepartementModule { }
