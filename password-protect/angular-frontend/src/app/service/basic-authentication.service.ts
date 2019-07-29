import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }

  executeJWTAuthenticationService(username, password) {
    return this.http.post<any>(`${API_URL}/authenticate`,
      { username,
        password
      }
    ).pipe(
      map(
        data => {
          sessionStorage.setItem("authenticatedUser", username);
          sessionStorage.setItem("token", `Bearer ${data.token}`);
          return data;
        }
      )
    );
  }

  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ":" + password);
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    return this.http.get<Authentication>(`${API_URL}/basicauth`,
      { headers }
    ).pipe(
      map(
        data => {
          sessionStorage.setItem("authenticatedUser", username);
          sessionStorage.setItem("token", basicAuthHeaderString);
          return data;
        }
      )
    );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem("authenticatedUser")
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser)
      return sessionStorage.getItem("token")
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("authenticatedUser")
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem("authenticatedUser");
    sessionStorage.removeItem("token");
  }
}

export class Authentication {

  constructor(private message: string) { };

}
