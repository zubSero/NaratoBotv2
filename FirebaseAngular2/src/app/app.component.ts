import { Component } from '@angular/core';
import { AngularFireDatabase, FirebaseListObservable, FirebaseObjectObservable } from 'angularfire2/database';

@Component({
  selector: 'app-root',
  template: `
  <h1>Session ID: --- {{ (item | async)?.id }}</h1>
  <h1>Intent ID: --- {{ (item | async)?.result?.metadata?.intentId }}</h1>
  <h1>Session Status: --- {{ (item | async)?.status?.errorType }}</h1>
  <h1>Session code: --- {{ (item | async)?.status?.code }}</h1>
  <h1>Intent Name: --- {{ (item | async)?.result?.metadata?.intentName }}</h1>
  <h1>Webhook used?  --- {{ (item | async)?.result?.metadata?.webhookUsed }}</h1>
  <h1>Action: --- {{ (item | async)?.result?.action }}</h1>
  <h1>action incomplete? --- {{ (item | async)?.result?.actionIncomplete }}</h1>
  <h1>Language: --- {{ (item | async)?.lang }}</h1>
  <h1>Response: --- {{ (item | async)?.result?.fulfillment?.speech }}</h1>
  <h1>ResolvedQuery: --- {{ (item | async)?.result?.resolvedQuery }}</h1>
  <h1>Timestamp: --- {{ (item | async)?.timestamp }}</h1>
  `,
})

/*export class AppComponent {
  constructor(private af: AngularFireDatabase) {
    const json$ = af.object('JSON/JSON');
    json$.subscribe(console.log);
  }

}*/

export class AppComponent {
  item: FirebaseObjectObservable<any>;
  constructor(db: AngularFireDatabase) {
    this.item = db.object('JSON/JSON');
    this.item.subscribe(console.log);
  }
}

