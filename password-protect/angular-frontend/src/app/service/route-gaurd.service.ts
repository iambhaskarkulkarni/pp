import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGaurdService implements CanActivate{

  constructor(private hardcodedAuthenticationService : HardcodedAuthenticationService,
    private router : Router
    ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      console.log("inside can active")
      if(this.hardcodedAuthenticationService.isUserLoggedIn()) 
       return true
      this.router.navigate(['login'])
      return false
  }

}
