import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { BasicAuthenticationService } from '../basic-authentication.service';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor{

  constructor(private basicAuthentication : BasicAuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {

    // let username = 'bhaskar'
    // let password = 'password'
    // let basicAuthHeaderString = 'Basic ' + window.btoa(username + ":" + password);

    let username = this.basicAuthentication.getAuthenticatedUser();
    let basicAuthHeaderString = this.basicAuthentication.getAuthenticatedToken();

    if(username && basicAuthHeaderString) {
      request = request.clone({
        setHeaders : {
          Authorization : basicAuthHeaderString
        },
        url : `${API_URL}/${request.url}`
      })
    }
    return next.handle(request);
  }
}
