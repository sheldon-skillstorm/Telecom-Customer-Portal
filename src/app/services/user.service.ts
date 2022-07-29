import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.mode';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  url = 'http://localhost:8080/user/v1';
  constructor(private http: HttpClient) {}

  findAll(): Observable<HttpResponse<User[]>> {
    return this.http.get<User[]>(this.url, { observe: 'response' });
  }

  find(id: number): Observable<HttpResponse<User>> {
    return this.http.get<User>(this.url + `/${id}`, { observe: 'response' });
  }

  save(users: User): Observable<HttpResponse<User>> {
    return this.http.post<User>(this.url, users, { observe: 'response' });
  }
  update(users: User, id: number): Observable<any> {
    return this.http.put<User>(this.url + '/${id}', { responseType: 'text' });
  }
}
