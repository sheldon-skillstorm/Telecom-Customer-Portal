import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlansComponent } from './plans/plans.component';
import { AboutComponent } from './about/about.component';
import { CartComponent } from './cart/cart.component';
import { LogInComponent } from './log-in/log-in.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'plans', component: PlansComponent
  },
  {
    path: 'why-teleskill', component: AboutComponent
  },
  {
    path: 'cart', component: CartComponent
  },
  {
    path: 'log-in', component: LogInComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
