import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { VerduleriaService } from '../verduleria.service';
import { Verdura } from '../verdura';

@Component({
  selector: 'app-anyadir',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './anyadir.component.html',
  styleUrl: './anyadir.component.css'
})
export class AnyadirComponent {
  formularioNueva = new FormGroup({
    nombre: new FormControl(''),
    precio: new FormControl(0),
    troceable: new FormControl(false)
  });

  constructor(private servicioVerduleria: VerduleriaService) {}

  anyadirVerdura() {
    console.log("añadir verdura");
    console.log(this.formularioNueva.value);
    const verdura: Verdura = {...(this.formularioNueva.value)};
    console.log(verdura);
    this.servicioVerduleria.nuevaVerdura(verdura).subscribe();
  }
}
