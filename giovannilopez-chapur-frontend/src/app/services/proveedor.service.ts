import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Proveedor, ProveedorResponse } from '../models/proveedor';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  private apiUrl = 'http://localhost:8080/api/v1/supplier-service';

  constructor(private http: HttpClient) {}

  getAll(page: number, size: number) {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);

    return this.http.get<ProveedorResponse>(
      'http://localhost:8080/api/v1/supplier-service',
      { params }
    );
  }

  create(proveedor: Proveedor): Observable<Proveedor> {
    return this.http.post<Proveedor>(this.apiUrl, proveedor);
  }

  update(id: string, proveedor: Proveedor): Observable<Proveedor> {
    return this.http.patch<Proveedor>(`${this.apiUrl}/${id}`, proveedor);
  }

  delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}