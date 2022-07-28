import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/login/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
}) 
export class AuthService {
  constructor(private http: HttpClient) {}
  login(credentials): Observable<any> {
    console.log(credentials);
    return this.http.post(
      AUTH_API + 'signin',
      {
        username: credentials.username,
        password: credentials.password,
      },
      httpOptions
    );
  }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ':' + password);
  // }
  // registerSuccessfulLogin(username, password) {
  //   sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  // }
  // logout() {
  //   sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  //   this.username = null;
  //   this.password = null;
  // }
  // isUserLoggedIn() {
  //   let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  //   if (user === null) return false;
  //   return true;
  // }
  // getLoggedInUserName() {
  //   let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  //   if (user === null) return '';
  //   return user;
  // }
}
