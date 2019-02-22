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

  addTransaction(transaction: any): Observable<any>{

    return this.http.post('//localhost:8080/pjchain/newTransaction', transaction);

  }

  getTransactionsByName(name: string){

    return this.http.get('//localhost:8080/pjchain/transactions/' + name);

  }

  getAmountByName(name: string){

    return this.http.get('//localhost:8080/pjchain/amount/' + name);

  }

  mine(){

    return this.http.get('//localhost:8080/pjchain/mine');

  }

  //https://developer.okta.com/blog/2018/08/22/basic-crud-angular-7-and-spring-boot-2
}
