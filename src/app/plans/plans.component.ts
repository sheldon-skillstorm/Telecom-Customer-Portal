import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {
  planName: string = 'Name';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToCart() {
    this.router.navigateByUrl('cart');
  }

  storePlan(name: any) {
    localStorage.setItem(this.planName, name);
  }
}
