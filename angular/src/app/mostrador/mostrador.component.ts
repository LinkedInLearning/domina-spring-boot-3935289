import { Component } from '@angular/core';
import { Verdura } from '../verdura';
import { VerduleriaService } from '../verduleria.service';

@Component({
  selector: 'app-mostrador',
  templateUrl: './mostrador.component.html',
  styleUrl: './mostrador.component.css'
})
export class MostradorComponent {
  verduras: Verdura[] = [];

  constructor(private servicioVerduleria: VerduleriaService) {

  }

  ngOnInit(): void {
    this.getVerduras();
  }

  getVerduras(): void {
    this.servicioVerduleria.getVerduras().subscribe({
        next: verdurasRecibidas => {
          this.verduras = verdurasRecibidas;
        },
        error: err => console.log(err)
      }
    );
  }
}
