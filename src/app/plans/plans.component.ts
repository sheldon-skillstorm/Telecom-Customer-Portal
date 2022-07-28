import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plan } from '../Models/plan.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css'],
})
export class PlansComponent implements OnInit {
  planName: string = 'Name';
  PlanList: Plan[] = [];

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.userService.findAll().subscribe((data) => {
      // console.log('body: ' + data.body);
      if (data.body != null) {
        this.PlanList = data.body;
      }
    });
  }

  goToCart() {
    this.router.navigateByUrl('cart');
  }

  storePlan(name: any) {
    localStorage.setItem(this.planName, name);
  }
}
