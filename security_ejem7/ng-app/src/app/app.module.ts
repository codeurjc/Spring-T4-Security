import { LoginService } from './login.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { BookListComponent } from './book-list.component';
import { BookDetailComponent } from './book-detail.component';
import { BookFormComponent } from './book-form.component';
import { LoginComponent } from './login.component';

import { BookService } from './book.service';
import { routing } from './app.routing';

@NgModule({
  declarations: [AppComponent, BookDetailComponent, BookListComponent, BookFormComponent, LoginComponent],
  imports: [BrowserModule, FormsModule, HttpModule, JsonpModule, routing],
  bootstrap: [AppComponent],
  providers: [BookService, LoginService]
})
export class AppModule { }
