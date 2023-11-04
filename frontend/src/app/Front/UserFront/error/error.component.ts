import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css','../../../../assets/front/css/style2.css']
})
export class ErrorComponent implements OnInit {

  constructor() { 
    const script = document.createElement('script');
    script.src = 'assets/front/js/main2.js';
    document.body.appendChild(script); 
  }

  ngOnInit(): void {
  }

}
