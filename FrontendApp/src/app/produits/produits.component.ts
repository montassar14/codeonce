import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule  } from '@angular/forms';
import { CatalogueService } from '../catalogue.service';


@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  constructor(private fb:FormBuilder, private catService:CatalogueService) { }
  products:any;
  productFormGroup!:FormGroup;
  submitted:boolean=false;
  category:any;

  ngOnInit(): void {
    this.productFormGroup=this.fb.group({
      category:["",Validators.required],
    })
    this.catService.getAllProducts().subscribe(data=>{
      console.log(data);
      this.products=data;

      
    })
  }
  onSearchProduct(){
    this.category=String(this.productFormGroup.value.category);
    //console.log(this.productFormGroup.value.category);
    console.log(this.category);
    console.log(typeof(this.category));
    this.catService.getProductsByCategory(String(this.category)).subscribe(data=>{
      console.log(data);
      this.products=data;
    })
  }

}
