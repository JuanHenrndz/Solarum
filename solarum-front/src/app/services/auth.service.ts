import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

export interface User {
  id: number;
  email: string;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<User | null>;
  public currentUser: Observable<User | null>;

  constructor() {
    const storedUser = localStorage.getItem('currentUser');
    this.currentUserSubject = new BehaviorSubject<User | null>(storedUser ? JSON.parse(storedUser) : null);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User | null {
    return this.currentUserSubject.value;
  }

  public getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }

  public isAuthenticated(): boolean {
    return this.currentUserSubject.value !== null;
  }

  login(email: string, password: string): Observable<User> {
    // Simulación de login - En una aplicación real, esto haría una llamada a la API
    return new Observable<User>(subscriber => {
      setTimeout(() => {
        if (email === 'demo@example.com' && password === 'password') {
          const user: User = {
            id: 1,
            name: 'Usuario Demo',
            email: email
          };
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          subscriber.next(user);
          subscriber.complete();
        } else {
          subscriber.error('Credenciales inválidas');
        }
      }, 1000);
    });
  }

  register(name: string, email: string, password: string): Observable<User> {
    // Simulación de registro - En una aplicación real, esto haría una llamada a la API
    return new Observable<User>(subscriber => {
      setTimeout(() => {
        const user: User = {
          id: Math.floor(Math.random() * 1000) + 1,
          name: name,
          email: email
        };
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        subscriber.next(user);
        subscriber.complete();
      }, 1000);
    });
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
