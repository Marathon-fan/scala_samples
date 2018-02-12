import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx'; // import all operations including map

@Injectable()
export class ProductService {

  constructor(private http: Http) { }

  getPosts() {
    //return this.http.get('http://localhost:8080/db/api/posts')
    return this.http.get('http://localhost:8080/web/posts')
      .map( (response: Response ) => {
          return response.json();
      })
      .catch( (error: Response) => {
         return Observable.throw('some error in getPosts() : ProductserviceService ');
       });
  }
}


