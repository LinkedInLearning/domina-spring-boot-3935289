import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MostradorComponent } from './mostrador/mostrador.component';
import { HttpClientModule } from '@angular/common/http';
import { AnyadirComponent } from './anyadir/anyadir.component';

@NgModule({
  declarations: [
    AppComponent,
    MostradorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
