import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css','../../../../assets/front/css/style2.css']
})
export class RegisterComponent implements OnInit {

  constructor() { 
    const script = document.createElement('script');
  script.src = 'assets/front/js/main2.js';
  document.body.appendChild(script); 
  }

  ngOnInit(): void {
  }

}
