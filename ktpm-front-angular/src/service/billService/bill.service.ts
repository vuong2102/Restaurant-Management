import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from 'src/model/Bill';
import { Food } from 'src/model/Food';
import { FoodOrder } from 'src/model/FoodOrder';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  private apiUrl = "http://localhost:8080/api/v1";

  constructor(private httpClient: HttpClient,

  ) { }
  createBill(bill: any): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/add-bill`, bill);
  }
  saveListFoodOrder(listFood: FoodOrder[]): Observable<any>{
    return this.httpClient.post(`${this.apiUrl}/add-list-foodOrder`, listFood);
  }
  getAllBill(): Observable<Bill[]>{
    return this.httpClient.get<Bill[]>(`${this.apiUrl}/get-bill`).pipe(
    )
  }
  changeStatusBill(id: number): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/change-status-bill/${id}`);
  }
}
