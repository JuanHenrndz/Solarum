import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, Router, ActivatedRoute } from '@angular/router';
import { BlogService, BlogPost } from '../../services/blog.service';

@Component({
  selector: 'app-article-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {
  article: BlogPost | undefined;
  relatedArticles: BlogPost[] = [];

  constructor(
    private blogService: BlogService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.loadArticle(id);
    });
  }

  loadArticle(id: number): void {
    this.blogService.getPost(id).subscribe(article => {
      if (article) {
        this.article = article;
        this.loadRelatedArticles(article);
      }
    });
  }

  loadRelatedArticles(currentArticle: BlogPost): void {
    this.blogService.getPosts().subscribe(posts => {
      this.relatedArticles = posts
        .filter(post => post.id !== currentArticle.id)
        .slice(0, 2);
    });
  }

  navigateToTag(tag: string): void {
    this.router.navigate(['/blog'], { queryParams: { tag } });
  }
}
