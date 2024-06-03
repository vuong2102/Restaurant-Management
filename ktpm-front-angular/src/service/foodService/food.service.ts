import { Food } from './../../model/Food';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable,of} from 'rxjs';
import { Router } from '@angular/router';

const httpOptions ={
  headers:new HttpHeaders({'Content-Type':'Application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private apiUrl = "http://localhost:8080/api/v1/foods";

  constructor(private httpClient:HttpClient,
    private router: Router,
  ) { }

  getAll():Observable<Food[]>{
    return this.httpClient.get<Food[]>(`${this.apiUrl}`);
  }
  getFoodById(id: number): Observable<Food>{
    return this.httpClient.get<Food>(`${this.apiUrl}/${id}`);
  }
  deleteFood(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/delete/${id}`);
  }
  getAllFoodBillByBillId(id: number): Observable<Food[]>{
    return this.httpClient.get<Food[]>(`${this.apiUrl}/billId/${id}`);
  }
  searchFood(searchTerm: string): Observable<Food[]> {
    return this.httpClient.get<Food[]>(`${this.apiUrl}?searchTerm=` + searchTerm);
  }
  updateFood(food: Food): Observable<Food> {
    return this.httpClient.put<Food>(`${this.apiUrl}/update/${food.id}`, food);
  }
}
