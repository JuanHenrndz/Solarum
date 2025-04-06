import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BlogService } from '../../../services/blog.service';
import { AuthService } from '../../../services/auth.service';

interface ArticleForm {
  title: string;
  excerpt: string;
  content: string;
  category: string;
  tags: string[];
  image: string;
}

@Component({
  selector: 'app-create-article',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {
  articleForm: ArticleForm = {
    title: '',
    excerpt: '',
    content: '',
    category: '',
    tags: [],
    image: ''
  };

  categories: string[] = [
    'Paneles Solares',
    'Energía Renovable',
    'Sostenibilidad',
    'Tecnología Solar',
    'Instalación',
    'Mantenimiento'
  ];

  newTag: string = '';
  errorMessage: string = '';
  isSubmitting: boolean = false;

  constructor(
    private blogService: BlogService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['/login']);
    }
  }

  addTag(): void {
    if (this.newTag.trim() && !this.articleForm.tags.includes(this.newTag.trim())) {
      this.articleForm.tags.push(this.newTag.trim());
      this.newTag = '';
    }
  }

  removeTag(tag: string): void {
    this.articleForm.tags = this.articleForm.tags.filter(t => t !== tag);
  }

  validateForm(): boolean {
    if (!this.articleForm.title.trim()) {
      this.errorMessage = 'El título es requerido';
      return false;
    }
    if (!this.articleForm.excerpt.trim()) {
      this.errorMessage = 'El resumen es requerido';
      return false;
    }
    if (!this.articleForm.content.trim()) {
      this.errorMessage = 'El contenido es requerido';
      return false;
    }
    if (!this.articleForm.category.trim()) {
      this.errorMessage = 'La categoría es requerida';
      return false;
    }
    return true;
  }

  onSubmit(): void {
    if (!this.validateForm()) return;

    this.isSubmitting = true;
    const currentUser = this.authService.getCurrentUser();

    this.blogService.createPost({
      ...this.articleForm,
      author: currentUser?.name || 'Anónimo',
      date: new Date().toISOString()
    }).subscribe({
      next: () => {
        this.router.navigate(['/blog']);
      },
      error: (err: Error) => {
        this.errorMessage = 'Error al crear el artículo: ' + err.message;
        this.isSubmitting = false;
      },
      complete: () => {
        this.isSubmitting = false;
      }
    });
  }
}
