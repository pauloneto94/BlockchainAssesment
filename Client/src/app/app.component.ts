import { Component } from '@angular/core';
import { BlockchainService } from './shared/blockchain.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'PJChain';

  constructor(private blockchainService: BlockchainService){

    //VERIFICAR SERVICE COMPARADO A WALLET

  }

  onMine(): boolean{

    return true;

  }

}
