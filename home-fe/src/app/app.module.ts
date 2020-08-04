import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { RolesPaneComponent } from './roles-pane/roles-pane.component';
import { NamePaneComponent } from './name-pane/name-pane.component';
import { HttpClientModule } from '@angular/common/http';
import { AvailableServicesComponent } from './available-services/available-services.component';
import { ServiceCardComponent } from './available-services/service-card/service-card.component';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    RolesPaneComponent,
    NamePaneComponent,
    AvailableServicesComponent,
    ServiceCardComponent
  ],
  imports: [
    BrowserModule,
	HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
