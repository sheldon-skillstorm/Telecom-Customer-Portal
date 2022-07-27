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

<<<<<<< HEAD
  ngOnInit() {}
=======
  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
  }

  handleLogout() {
    this.authenticationService.logout();
  }

  goToLogin() {
    this.router.navigateByUrl('login');
  }
>>>>>>> a3d9e2f1e9c8dc346921e05e2f9af2ca3809dae0
}
