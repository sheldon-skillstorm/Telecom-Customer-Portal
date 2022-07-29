import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plan } from '../models/plan.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css'],
})
export class PlansComponent implements OnInit {
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

  storePlan1(name: any) {
    localStorage.setItem('Plan 1', name);
  }

  storePlan2(name: any) {
    localStorage.setItem('Plan 2', name);
  }

  storePlan3(name: any) {
    localStorage.setItem('Plan 3', name);
  }
}
