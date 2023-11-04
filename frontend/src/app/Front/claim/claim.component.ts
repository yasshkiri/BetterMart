import { Component, OnInit } from '@angular/core';
import { ClaimService } from 'src/app/shared/claim.service';
import { Claim } from 'src/app/Models/claim';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {
  claim: Claim = new Claim();



  claimForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private claimService: ClaimService, private router: Router) {}

  ngOnInit(): void {
    this.claimForm = this.formBuilder.group({
      claimType: ['', Validators.required],
      productType: ['', Validators.required],
      descriptionC: ['', Validators.required]
    });

 
  }


  onSubmit(): void {
    if (this.claimForm.invalid) {
      return;
    }
    const claim: Claim = this.claimForm.value;
    claim.dateC = new Date(); // Set the datePub field to the current date and time
    this.claimService.addClaim(claim)
      .subscribe(
        (response) => {
          console.log('Claim added:', response);
          this.router.navigate(['/Claim']);
        },
        (error) => {
          console.error('Error adding claim:', error);
        }
      );
  }

 
 

}
