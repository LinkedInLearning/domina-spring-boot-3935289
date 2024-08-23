import { Injectable } from '@angular/core';
import { Verdura } from './verdura';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VerduleriaService {

  private urlApi = 'http://localhost:8080/verduras';
  constructor(private http: HttpClient) { }

  getVerduras(): Observable<Verdura[]> {
    return this.http.get<Verdura[]>(this.urlApi);
  }

  nuevaVerdura(verdura: Verdura): Observable<Verdura> {
    return this.http.post<Verdura>(this.urlApi, verdura);
  }
}
