import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlansComponent } from './plans/plans.component';
import { AboutComponent } from './about/about.component';
import { CartComponent } from './cart/cart.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { HomeComponent } from './home/home.component';
import { MatBadgeModule } from '@angular/material/badge';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import {
  HttpClient,
  HttpClientModule,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { DropDownComponent } from './drop-down/drop-down.component';
import { MatMenuModule } from '@angular/material/menu';
import { LogoutComponent } from './logout/logout.component';
import { authInterceptorProviders } from './services/interceptor.service';
import { ManageComponent } from './manage/manage.component';
import { BillsComponent } from './bills/bills.component';
import { UserComponent } from './user/user.component';
import { DeviceComponent } from './device/device.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlansComponent,
    AboutComponent,
    CartComponent,
    LoginComponent,
    DropDownComponent,
    LogoutComponent,
    ManageComponent,
    BillsComponent,
    UserComponent,
    DeviceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatBadgeModule,
    MatExpansionModule,
    MatIconModule,
    FormsModule,
    HttpClientModule,
    MatMenuModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent],
})
export class AppModule {}
