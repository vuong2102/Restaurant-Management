import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Bill } from 'src/model/Bill';
import { Client } from 'src/model/Client';

const httpOptions ={
  headers:new HttpHeaders({'Content-Type':'Application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private apiUrl = "http://localhost:8080/api/v1";

  constructor(private httpClient: HttpClient,

  ) { }
  addClient(client: any) {
    this.httpClient.post('/api/clients', client)
      .subscribe(response => {
        console.log('Client saved successfully:', response);
        // Xử lý thành công
      }, error => {
        console.error('Error saving client:', error);
        // Xử lý lỗi
      });
  }
  createClient(client: Client): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/add-client`, client);
  }
  getClientById(id: any): Observable<Client>{
    return this.httpClient.get<Client>(`${this.apiUrl}/clients/` + id).pipe();
  }
}
