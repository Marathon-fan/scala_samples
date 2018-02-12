import { Component, OnInit } from '@angular/core';
import { Product } from "../shared/product";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css'],
})
export class ProductsListComponent implements OnInit {

  products: Product[] = null;

  constructor( ) { }

  ngOnInit() {
  }

}
