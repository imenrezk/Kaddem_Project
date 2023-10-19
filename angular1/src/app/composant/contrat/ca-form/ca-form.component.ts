import { Component, Input, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';
import { Contrat } from 'src/app/models/Contrat';
import { ContratService } from '../contrat.service';

@Component({
  selector: 'app-ca-form',
  templateUrl: './ca-form.component.html',
  styleUrls: ['./ca-form.component.css'],
})
export class CaFormComponent implements OnInit {
  @Input() contratList: Contrat[] = new Array();
  isSubmitted = false;
  startDate!: Date;
  endDate!: Date;
  CA: number = 0;

  public onSubmit(form: NgForm) {
    console.log('start' + this.startDate);
    console.log('end' + this.endDate);
    this.CA = this.contratService.getChiffreAffaireEntreDeuxDate(
      new Date(this.startDate),
      new Date(this.endDate),
      this.contratList
    );
    this.isSubmitted = true;
  }

  constructor(private contratService: ContratService) {}

  ngOnInit(): void {}
}
