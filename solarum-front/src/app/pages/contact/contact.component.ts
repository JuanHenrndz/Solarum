import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface ContactData {
  name: string;
  email: string;
  subject: string;
  message: string;
}

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contactData: ContactData = {
    name: '',
    email: '',
    subject: '',
    message: ''
  };

  onSubmit() {
    // Aquí iría la lógica para enviar el formulario
    console.log('Formulario enviado:', this.contactData);
    // Reiniciar el formulario
    this.contactData = {
      name: '',
      email: '',
      subject: '',
      message: ''
    };
  }
}
