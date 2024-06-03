import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Table } from 'src/model/Table';

@Injectable({
  providedIn: 'root',
})
export class TableService {
  changeStatusTableById(id: any) {
    return this.httpClient.get<any>(`${this.apiUrl}/change-status-byId/` + id);
  }
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient,
    private router: Router) {}

  getAll(): Observable<Table[]> {
    return this.httpClient.get<Table[]>(`${this.apiUrl}/tables`).pipe();
  }

  changeStatusTable(table: Table): Observable<Object> {
    return this.httpClient.post(`${this.apiUrl}/change-status`, table);
  }
  getTableById(id: any) {
    return this.httpClient.get<Table>(`${this.apiUrl}/tables/`+ id);
  }
}
