import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css','../../../../assets/front/css/style2.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor() {
    const script = document.createElement('script');
    script.src = 'assets/front/js/main2.js';
    document.body.appendChild(script); 
   }

  ngOnInit(): void {
  }

}
