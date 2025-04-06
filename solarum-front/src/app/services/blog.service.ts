import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface BlogPost {
  id: number;
  title: string;
  excerpt: string;
  content: string;
  image: string;
  date: string;
  author: string;
  category: string;
  tags: string[];
}

export interface Category {
  name: string;
  count: number;
}

export interface Tag {
  name: string;
  count: number;
}

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private posts: BlogPost[] = [];
  private lastId = 0;

  constructor() {
    // Inicializar con algunos posts de ejemplo
    this.createPost({
      title: 'Beneficios de la Energía Solar',
      excerpt: 'Descubre por qué la energía solar es la mejor opción para tu hogar',
      content: 'Contenido detallado sobre los beneficios...',
      image: 'assets/images/solar-panels.jpg',
      author: 'Admin',
      category: 'Energía Renovable',
      tags: ['Sostenibilidad', 'Ahorro'],
      date: new Date().toISOString()
    });
  }

  getPosts(): Observable<BlogPost[]> {
    return of(this.posts);
  }

  getPostById(id: number): Observable<BlogPost | undefined> {
    return of(this.posts.find(post => post.id === id));
  }

  getPopularPosts(): Observable<BlogPost[]> {
    return of(this.posts.slice(0, 3));
  }

  getCategories(): Observable<Category[]> {
    const categories = new Map<string, number>();
    this.posts.forEach(post => {
      categories.set(post.category, (categories.get(post.category) || 0) + 1);
    });
    return of(Array.from(categories.entries()).map(([name, count]) => ({ name, count })));
  }

  getTags(): Observable<Tag[]> {
    const tags = new Map<string, number>();
    this.posts.forEach(post => {
      post.tags.forEach(tag => {
        tags.set(tag, (tags.get(tag) || 0) + 1);
      });
    });
    return of(Array.from(tags.entries()).map(([name, count]) => ({ name, count })));
  }

  getPostsByCategory(category: string): Observable<BlogPost[]> {
    return of(this.posts.filter(post => post.category === category));
  }

  getPostsByTag(tag: string): Observable<BlogPost[]> {
    return of(this.posts.filter(post => post.tags.includes(tag)));
  }

  searchPosts(query: string): Observable<BlogPost[]> {
    const searchTerm = query.toLowerCase();
    return of(this.posts.filter(post =>
      post.title.toLowerCase().includes(searchTerm) ||
      post.excerpt.toLowerCase().includes(searchTerm) ||
      post.content.toLowerCase().includes(searchTerm)
    ));
  }

  createPost(postData: Omit<BlogPost, 'id'>): Observable<BlogPost> {
    const newPost: BlogPost = {
      ...postData,
      id: ++this.lastId
    };
    this.posts.unshift(newPost);
    return of(newPost);
  }

  updatePost(id: number, postData: Partial<BlogPost>): Observable<BlogPost | undefined> {
    const index = this.posts.findIndex(post => post.id === id);
    if (index !== -1) {
      this.posts[index] = { ...this.posts[index], ...postData };
      return of(this.posts[index]);
    }
    return of(undefined);
  }

  deletePost(id: number): Observable<boolean> {
    const index = this.posts.findIndex(post => post.id === id);
    if (index !== -1) {
      this.posts.splice(index, 1);
      return of(true);
    }
    return of(false);
  }
}
