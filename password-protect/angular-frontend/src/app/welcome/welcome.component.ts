import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message='Wellcome to Application';
  name =''
  welcomeServerMessage:string

  constructor(
    private route: ActivatedRoute,
    private welcomeDataService : WelcomeDataService
    
    ) { }

  ngOnInit() {
    this.name = this.route.snapshot.params['name']
  }

  getWelcomeMessage() {
    this.welcomeDataService.executeHelloWorldBeanService().subscribe(
      response => this.handelSucessfulResponse(response),
      error => this.handelErrorResponse(error)
    )
  }

  handelSucessfulResponse(response) {
    this.welcomeServerMessage = response.message;
  }

  handelErrorResponse(error){
    this.welcomeServerMessage=error.message;
  }
  

}
