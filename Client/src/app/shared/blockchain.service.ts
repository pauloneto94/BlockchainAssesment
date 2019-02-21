import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlockchainService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{

    return this.http.get('//localhost:8080/pjchain');

  }

  //https://developer.okta.com/blog/2018/08/22/basic-crud-angular-7-and-spring-boot-2
}
