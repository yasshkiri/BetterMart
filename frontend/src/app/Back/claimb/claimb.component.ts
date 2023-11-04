import { Component, OnInit } from '@angular/core';
import { ClaimService } from 'src/app/shared/claim.service';
import { Claim } from 'src/app/Models/claim';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-claimb',
  templateUrl: './claimb.component.html',
  styleUrls: ['./claimb.component.css']
})
export class ClaimbComponent implements OnInit {
  claims :Claim[] = [];

  constructor(private claimService : ClaimService, private router: Router, private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.claimService.getClaims().subscribe(claims => this.claims = claims);
  }


  onDeletef(id: Number) {
    this.claimService.deleteClaim(id).subscribe(
      (response) => {
        console.log(`Claim ${id} deleted`);
        this.claims = this.claims.filter(c => c.idClaim !== id);
        this.router.navigate(['/ClaimB']); // navigate to the publications list
        
      },
      (error) => {
        console.error('Error deleting claim:', error);
        // handle the error here
      }
    );
  } 

 onDelete(): void {
  this.claimService.deleteClaims().subscribe(
    (response) => {
      console.log('claims deleted:', response);
      this.router.navigate(['/ClaimB']); // navigate to the publications list
    },
    (error) => {
      console.error('Error deleting publications:', error);
    }
  );
}

traiterRec(idClaim: number) {
  const url = `http://localhost:8888/pidev/pi/RecTrue/${idClaim}`;
  this.httpClient.put(url, {}).subscribe(
    () => {
      console.log('Claim status updated successfully.');
      // Perform any additional actions on success
    },
    (error : any) => {
      console.error('Error updating claim status:', error);
      // Handle the error as needed
    }
  );
}



}
