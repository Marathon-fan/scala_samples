import { Component, OnInit, Input } from '@angular/core';
import { Product } from "../shared/product";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  @Input()
  product: Product = null;

  constructor() { }

  ngOnInit() {
  }

}

