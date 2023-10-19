import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UniversiteRoutingModule } from './universite-routing.module';
import { AdduniversiteComponent } from './adduniversite/adduniversite.component';
import { ListuniversiteComponent } from './listuniversite/listuniversite.component';
import { EdituniversiteComponent } from './edituniversite/edituniversite.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AdduniversiteComponent,
    ListuniversiteComponent,
    EdituniversiteComponent
  ],
  imports: [
    CommonModule,
    UniversiteRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
  ]
})
export class UniversiteModule { }
