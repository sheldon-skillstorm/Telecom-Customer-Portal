import { Component, OnInit } from '@angular/core';
import { setLines } from '@angular/material/core';
import { Device } from '../Models/device.model';
import { Plan } from '../Models/plan.model';
import { PlanService } from '../services/plan.service';
import { DeviceService } from '../services/device.service';
import { TokenStorageService } from '../services/token-storage.service';
import { DeviceComponent } from '../device/device.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  isLoggedIn = true;
  newPlan: Plan = new Plan(0, '', 0, '', '', '', 0);
  device: Device[];
  number: string = '';
  name = localStorage.getItem('Name');
  total = 0;
  lines: string[] = [];
  items: number = 0;
  limit: number = 0;

  constructor(
    private planService: PlanService,
    private deviceService: DeviceService,
    private tokenStorage: TokenStorageService
  ) {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  ngOnInit(): void {
    if (this.name == 'Level 1' || this.name == 'Level 2') {
      this.lines = ['line'];
      this.items = 1;
    } else {
      this.items = 3;
      this.lines = ['line'];
    }

    if (this.name === 'Level 1') {
      this.newPlan.name = 'Level 1';
      this.newPlan.data = '25 GB high-speed data';
      this.newPlan.hotspot = '3G Unlimited mobile hotspot';
      this.newPlan.streaming = 'Standard-definition streaming';
      this.newPlan.limit = 2;
      this.total = 30;
      this.limit = 2;
    } else if (this.name == 'Level 2') {
      this.newPlan.name = 'Level 2';
      this.newPlan.data = 'Unlimited high-speed data';
      this.newPlan.hotspot = '20 GB high-speed mobile hotspot';
      this.newPlan.streaming = 'High-definition streaming';
      this.newPlan.limit = 3;
      this.total = 50;
      this.limit = 3;
    } else if (this.name == 'Level 3') {
      this.newPlan.name = 'Level 3';
      this.newPlan.data = '100 GB high-speed data';
      this.newPlan.hotspot = '10 GB high-speed mobile hotspot';
      this.newPlan.streaming = 'Standard-definition streaming';
      this.newPlan.limit = 7;
      this.total = 75;
      this.limit = 7;
      this.lines.push('line', 'line');

      this.deviceService.findAll().subscribe((data) => {
        //console.log("body: " + data.body);
        if (data.body != null) {
          this.device = data.body;
        }
      });
    }
  }

  addLine() {
    if (this.items < this.limit) {
      if (this.name == 'Level 1') {
        this.total += 30;
      } else if (this.name == 'Level 2') {
        this.total += 50;
      } else if (this.name == 'Level 3') {
        this.total += 25;
      }
      this.items++;
      this.lines.push('line');
    }
  }

  deleteLine(line: any) {
    let index = this.lines.indexOf(line);
    if (this.name == 'Level 1') {
      this.total -= 30;
      this.lines.splice(index, 1);
      this.items--;
    } else if (this.name == 'Level 2') {
      this.total -= 50;
      this.lines.splice(index, 1);
      this.items--;
    } else if (this.name == 'Level 3') {
      if (this.items > 3) {
        this.total -= 25;
        this.lines.splice(index, 1);
        this.items--;
      }
    }
  }

  public getDevice(): void {
    this.deviceService.findAll().subscribe((data) => {
      //console.log("body: " + data.body);
      if (data.body != null) {
        this.device = data.body;
      }
    });
  }

  createPlan(): void {
    this.newPlan.price = this.total;
    if (this.isLoggedIn) {
      this.planService.save(this.newPlan).subscribe((data) => {});

      this.deviceService.save(this.device).subscribe((data) => {});
    }
  }
}
