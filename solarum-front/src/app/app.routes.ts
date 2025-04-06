import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ArticleDetailComponent } from './pages/article-detail/article-detail.component';
import { LoginComponent } from './pages/login/login.component';
import { CreateArticleComponent } from './pages/blog/create-article/create-article.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'blog/create', component: CreateArticleComponent },
  { path: 'blog/:id', component: ArticleDetailComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '' }
];
