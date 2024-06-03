import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Combo } from 'src/model/Combo';
import { Food } from 'src/model/Food';

@Injectable({
  providedIn: 'root'
})
export class ComboService {

  private apiUrl = "http://localhost:8080/api/v1/combos";
  private apiUrlFood = "http://localhost:8080/api/v1/foods";

  constructor(private httpClient: HttpClient,

  ) { }
  getAllCombo():Observable<Combo[]>{
    return this.httpClient.get<Combo[]>(`${this.apiUrl}`).pipe(
    )
  }
  getComboById(id: number):Observable<Combo> {
    return this.httpClient.get<Combo>(`${this.apiUrl}/${id}`);
  }
  getFoodComboById(id: number): Observable<Food[]>{
    return this.httpClient.get<Food[]>(`${this.apiUrlFood}/combo/${id}`).pipe()
  }
}
