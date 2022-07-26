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

  save(plan: Plan): Observable<HttpResponse<Plan>> {
    return this.http.post<Plan>(this.url, plan, { observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<Object>>  {
    return this.http.delete(this.url + `/${id}`, { observe: 'response' });
  }

  put(id: number): Observable<HttpResponse<Object>> {
    return this.http.put(this.url, + `/${id}`, { observe: 'response' });
  }

}