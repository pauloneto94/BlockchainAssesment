import { Component, OnInit } from '@angular/core';
import { BlockchainService } from '../shared/blockchain.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private blockchainService: BlockchainService) { }

  ngOnInit() {

    this.blockchainService.getAll();

  }

}
