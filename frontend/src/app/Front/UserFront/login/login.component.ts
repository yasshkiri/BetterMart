import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css','../../../../assets/front/css/style2.css']
})
export class LoginComponent implements OnInit {

  constructor() { 
    const script = document.createElement('script');
    script.src = 'assets/front/js/main2.js';
    document.body.appendChild(script); 
  }

  ngOnInit(): void {
  }

}
