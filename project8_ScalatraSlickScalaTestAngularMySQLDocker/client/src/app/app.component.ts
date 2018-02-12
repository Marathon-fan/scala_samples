import { Component, OnInit } from '@angular/core';
import { Product } from './shared/product';
import { ProductDetailComponent } from "./product-detail/product-detail.component";
import { Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map' ;
import { Http } from '@angular/http';
import { ProductService } from "./shared/product.service";
import { Injectable } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

@Injectable()
export class AppComponent implements OnInit {
  title = 'app';


  //products: Array<Product> = [];
  products: Product[] = [];
  input_userId:string = "";
  input_text:string = "";
  input_delete_postId:string = "";

  constructor(private productSvc: ProductService, private http: Http){}

  ngOnInit() {
    this.productSvc.getPosts().subscribe(
        (data: Product[]) => {
          this.products = data;
        },
        (error) => console.log(error),
        () => console.log(this.products.length + " product(s) are retrieved")
      );
  }

  getProducts(): Product[] {
    return this.products;
  }

  onFormSubmit_addPost() {
    console.log(this.input_userId);
    console.log(this.input_text);

    const url: string = '/web/post/?text=' + this.input_text.replace(/\s/g, "") + "&&userId=" + this.input_userId;

    this.http.post(url, {title:'', body:''})
          .subscribe(
            res => {
              console.log(res);
            },
            err => {
              console.log("Error occured in onFormSubmit_addPost");
            }
          );
  }
  onFormSubmit_deletePost() {
    console.log(this.input_delete_postId);
    const url: string = '/web/post_delete/?postId=' + this.input_delete_postId;
    this.http.post(url, {title:'', body:''})
      .subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log("Error occured in onFormSubmit_deletePost");
        }
      );
  }
}
