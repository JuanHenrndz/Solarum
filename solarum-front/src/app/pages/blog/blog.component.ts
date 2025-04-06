import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BlogService, BlogPost, Category, Tag } from '../../services/blog.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-blog',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  posts: BlogPost[] = [];
  popularPosts: BlogPost[] = [];
  categories: Category[] = [];
  tags: Tag[] = [];
  currentPage: number = 1;
  postsPerPage: number = 6;
  hasMorePages: boolean = true;
  searchQuery: string = '';
  currentCategory: string = '';
  currentTag: string = '';
  isAuthenticated: boolean = false;

  constructor(
    private blogService: BlogService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loadPosts();
    this.loadPopularPosts();
    this.loadCategories();
    this.loadTags();
    this.isAuthenticated = this.authService.isAuthenticated();

    // Suscribirse a cambios en el estado de autenticación
    this.authService.currentUser.subscribe(user => {
      this.isAuthenticated = !!user;
    });
  }

  loadPosts(): void {
    if (this.searchQuery) {
      this.blogService.searchPosts(this.searchQuery).subscribe(posts => {
        this.posts = posts;
      });
    } else if (this.currentCategory) {
      this.blogService.getPostsByCategory(this.currentCategory).subscribe(posts => {
        this.posts = posts;
      });
    } else if (this.currentTag) {
      this.blogService.getPostsByTag(this.currentTag).subscribe(posts => {
        this.posts = posts;
      });
    } else {
      this.blogService.getPosts().subscribe(posts => {
        this.posts = posts;
      });
    }
  }

  loadPopularPosts(): void {
    this.blogService.getPopularPosts().subscribe(posts => {
      this.popularPosts = posts;
    });
  }

  loadCategories(): void {
    this.blogService.getCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  loadTags(): void {
    this.blogService.getTags().subscribe(tags => {
      this.tags = tags;
    });
  }

  searchPosts(): void {
    this.currentPage = 1;
    this.currentCategory = '';
    this.currentTag = '';
    this.loadPosts();
  }

  filterByCategory(category: string): void {
    this.currentPage = 1;
    this.currentCategory = category;
    this.currentTag = '';
    this.searchQuery = '';
    this.loadPosts();
  }

  filterByTag(tag: string): void {
    this.currentPage = 1;
    this.currentTag = tag;
    this.currentCategory = '';
    this.searchQuery = '';
    this.loadPosts();
  }

  clearCategoryFilter(): void {
    this.currentCategory = '';
    this.loadPosts();
  }

  clearTagFilter(): void {
    this.currentTag = '';
    this.loadPosts();
  }

  clearSearch(): void {
    this.searchQuery = '';
    this.loadPosts();
  }

  clearAllFilters(): void {
    this.currentCategory = '';
    this.currentTag = '';
    this.searchQuery = '';
    this.loadPosts();
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.loadPosts();
    }
  }

  nextPage(): void {
    this.currentPage++;
    this.loadPosts();
  }
}
