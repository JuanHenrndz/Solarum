import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginData = {
    email: '',
    password: ''
  };

  registerData = {
    name: '',
    email: '',
    password: '',
    confirmPassword: ''
  };

  isLoginMode = true;
  errorMessage = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  toggleMode(): void {
    this.isLoginMode = !this.isLoginMode;
    this.errorMessage = '';
  }

  onSubmit(): void {
    if (this.isLoginMode) {
      this.login();
    } else {
      this.register();
    }
  }

  private login(): void {
    if (!this.loginData.email || !this.loginData.password) {
      this.errorMessage = 'Por favor, completa todos los campos';
      return;
    }

    this.authService.login(this.loginData.email, this.loginData.password)
      .subscribe({
        next: () => {
          this.router.navigate(['/']);
        },
        error: (error) => {
          this.errorMessage = 'Error al iniciar sesión. Por favor, verifica tus credenciales.';
        }
      });
  }

  private register(): void {
    if (!this.registerData.name || !this.registerData.email ||
        !this.registerData.password || !this.registerData.confirmPassword) {
      this.errorMessage = 'Por favor, completa todos los campos';
      return;
    }

    if (this.registerData.password !== this.registerData.confirmPassword) {
      this.errorMessage = 'Las contraseñas no coinciden';
      return;
    }

    this.authService.register(
      this.registerData.name,
      this.registerData.email,
      this.registerData.password
    ).subscribe({
      next: () => {
        this.router.navigate(['/']);
      },
      error: (error) => {
        this.errorMessage = 'Error al registrar usuario. Por favor, intenta nuevamente.';
      }
    });
  }
}
