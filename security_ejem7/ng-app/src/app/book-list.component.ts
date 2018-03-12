import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Book, BookService } from './book.service';
import { LoginService } from './login.service';

@Component({
  template: `
    <h2>Books</h2>
    <ul class="items">
      <li *ngFor="let book of books">
        <a [routerLink]="['/book', book.id]">{{book.title}}</a>
      </li>
    </ul>
    <button *ngIf="loginService.isLogged" (click)="newBook()">New book</button>
  `
})
export class BookListComponent implements OnInit {

  books: Book[];

  constructor(private router: Router, private service: BookService,
    public loginService: LoginService) { }

  ngOnInit() {
    this.service.getBooks().subscribe(
      books => this.books = books,
      error => console.log(error)
    );
  }

  newBook() {
    this.router.navigate(['/book/new']);
  }
}
