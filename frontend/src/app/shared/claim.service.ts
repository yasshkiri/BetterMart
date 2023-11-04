import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs'; 
import { Claim } from '../Models/claim';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {
  showUrl = 'http://localhost:8888/pidev/pi/claims';
  
  addUrl ='http://localhost:8888/pidev/pi/addC';
  
  deleteUrl='http://localhost:8888/pidev/pi';
  
 deleteAllUrl='http://localhost:8888/pidev/pi/delete';

 traiterRecUrl = 'http://localhost:8888/pidev/pi/RecTrue';


  constructor(private http: HttpClient) { }

  getClaims(): Observable<Claim[]> {
    console.log('Fetching claims from server...');
    return this.http.get<Claim[]>(this.showUrl);
  }

 addClaim(claim :Claim): Observable<Claim>{
   return this.http.post<Claim>(`${this.addUrl}`, claim);
  }

  deleteClaim(id: Number): Observable<string> {
    const url = `${this.deleteUrl}/${id}`;
    return this.http.delete<string>(url, { responseType: 'text' as 'json' });
  }
  
  deleteClaims(): Observable<any> {
    return this.http.delete(this.deleteAllUrl);
  }

  traiterRec(idClaim: number): Observable<any> {
    const url = `${this.traiterRecUrl}/${idClaim}`;
    return this.http.put(url, null);
  }
}
