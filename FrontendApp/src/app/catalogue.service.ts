import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {

  public host:string="http://localhost:8080/App";
  constructor(private http:HttpClient) {
   }

   getAllProducts(){
    return this.http.get(this.host+"/products");
   }

   getProductsByCategory(category:String){
    return this.http.get(this.host+"/products/"+category);
   }
}
