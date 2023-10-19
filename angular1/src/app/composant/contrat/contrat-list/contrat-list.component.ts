import { Component, OnDestroy, OnInit } from '@angular/core';

import { Subject } from 'rxjs';
import { Contrat } from 'src/app/models/Contrat';
import { ContratService } from '../contrat.service';

@Component({
  selector: 'app-contrat-list',
  templateUrl: './contrat-list.component.html',
  styleUrls: ['./contrat-list.component.css'],
})
export class ContratListComponent implements OnInit, OnDestroy {
  currentContract: Contrat = new Contrat();
  contratList: Contrat[] = new Array();
  isUpdate: boolean = false;
  isDeleted: boolean = false;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(private contratService: ContratService) {}

  delete(id: number) {
    this.isDeleted = true;
    this.contratService.delete(id).subscribe();
    this.contratService.getAll().subscribe((data) => (this.contratList = data));
  }
  update(contrat: Contrat) {
    this.isUpdate = true;
    this.currentContract = contrat;
    //console.log(this.currentContract);
  }

  getChiffreAffaire() {
    this.contratService.getChiffreAffaireEntreDeuxDate(
      new Date('2022-11-05'),
      new Date('2023-06-07'),
      this.contratList
    );
  }

  ngOnInit(): void {
    this.dtOptions = {
      pageLength: 5,
      stateSave: true,
      lengthMenu: [
        [5, 10, 15, -1],
        [5, 10, 15, 'All'],
      ],
      processing: true,
    };
    this.contratService.getAll().subscribe((data) => {
      this.contratList = data;
      this.dtTrigger.next(undefined);
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }
}
