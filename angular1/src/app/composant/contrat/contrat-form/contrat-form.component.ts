import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Contrat } from 'src/app/models/Contrat';
import { ContratService } from '../contrat.service';

@Component({
  selector: 'app-contrat-form',
  templateUrl: './contrat-form.component.html',
  styleUrls: ['./contrat-form.component.css'],
})
export class ContratFormComponent implements OnInit {
  @Input() contract: Contrat = new Contrat();
  @Input() isUpdate: boolean = false;

  myForm: FormGroup = new FormGroup({
    dateDebut: new FormControl(this.contract.dateDebut, Validators.required),
    dateFin: new FormControl(this.contract.dateFin, Validators.required),
    specialite: new FormControl(this.contract?.specialite, Validators.required),
    archive: new FormControl('true'),
  });

  get controls() {
    // we type controls instead of controls() with get
    return this.myForm.controls;
  }
  onSubmit() {
    if (this.isUpdate) {
      this.contratService.update(this.contract).subscribe();
      this.isUpdate = false;
    } else this.contratService.insert(this.contract).subscribe();
    console.warn(this.contract);
  }
  constructor(private contratService: ContratService) {}

  ngOnInit(): void {}
}
