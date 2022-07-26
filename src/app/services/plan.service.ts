import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plan } from '../models/plan.model';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
  url: string = "http://localhost:8080/plans/v1";

  constructor(private http: HttpClient) { }

  findAll(): Observable<HttpResponse<Plan[]>> {
    return this.http.get<Plan[]>(this.url, { observe: 'response' });
  }

  find(id: number): Observable<HttpResponse<Plan>> {
    return this.http.get<Plan>(this.url + `/${id}`, { observe: 'response' });
  }

  save(owner: Plan): Observable<HttpResponse<Plan>> {
    return this.http.post<Plan>(this.url, owner, { observe: 'response' });
  }
}