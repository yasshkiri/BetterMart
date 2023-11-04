import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor() {
  const script = document.createElement('script');
  script.src = 'assets/back/js/filejsamine.js';
  document.body.appendChild(script); 
}

  ngOnInit(): void {
  }

}
