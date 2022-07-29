import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-drop-down',
  templateUrl: './drop-down.component.html',
  styleUrls: ['./drop-down.component.css'],
})
export class DropDownComponent implements OnInit {
  isLoggedIn = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthService
  ) {}

  ngOnInit() {}

  goToLogin() {
    this.router.navigateByUrl('login');
  }

  goToAccount() {
    this.router.navigateByUrl('cart');
  }

  goToPlan() {
    this.router.navigateByUrl('plans');
  }
}
