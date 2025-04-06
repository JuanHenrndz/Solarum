import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface SolarCalculation {
  consumo: number;
  paneles: number;
  potencia: string;
  produccion: string;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  consumoMensual: number = 0;
  calculoSolar: SolarCalculation[] = [
    { consumo: 200, paneles: 2, potencia: "800W", produccion: "240 kWh" },
    { consumo: 300, paneles: 3, potencia: "1.2kW", produccion: "360 kWh" },
    { consumo: 400, paneles: 4, potencia: "1.6kW", produccion: "480 kWh" },
    { consumo: 500, paneles: 5, potencia: "2.0kW", produccion: "600 kWh" },
    { consumo: 600, paneles: 6, potencia: "2.4kW", produccion: "720 kWh" },
    { consumo: 700, paneles: 7, potencia: "2.8kW", produccion: "840 kWh" },
    { consumo: 800, paneles: 8, potencia: "3.2kW", produccion: "960 kWh" },
    { consumo: 900, paneles: 9, potencia: "3.6kW", produccion: "1080 kWh" },
    { consumo: 1000, paneles: 10, potencia: "4.0kW", produccion: "1200 kWh" }
  ];

  calcularPaneles(consumo: number): SolarCalculation | undefined {
    return this.calculoSolar.find(calculo => calculo.consumo >= consumo) ||
           this.calculoSolar[this.calculoSolar.length - 1];
  }
}
