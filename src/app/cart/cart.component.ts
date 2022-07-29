import { Component, OnInit } from '@angular/core';
import { setLines } from '@angular/material/core';
import { Device } from '../models/device.model';
import { Plan } from '../models/plan.model';
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
  isLoggedIn = false;
  newPlan: Plan = new Plan(0, "", 0, "", "", "", 0); 
  devices: Device[] = [];
  number: string = "";

  plan1 = localStorage.getItem('Plan 1');
  plan2 = localStorage.getItem('Plan 2');
  plan3 = localStorage.getItem('Plan 3');
  plans = [this.plan1, this.plan2, this.plan3];

  plan1Lines = []
  plan2Lines = []
  plan3Lines = []

  plan1Items = 0;
  plan2Items = 0;
  plan3Items = 0;

  plan1Lim = 0;
  plan2Lim = 0;
  plan3Lim = 0;

  plan1Total = 0;
  plan2Total = 0;
  plan3Total = 0;


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
    this.plan1Lines = ['line'];
    this.plan1Items = 1;
    this.plan1Total = 30;
    this.plan1Lim = 2;

    this.plan2Lines = ['line'];
    this.plan2Items = 1;
    this.plan2Total = 50;
    this.plan2Lim = 3;

    this.plan3Lines = ['line', 'line', 'line'];
    this.plan3Items = 3;
    this.plan3Total = 75;
    this.plan3Lim = 7;
  }

  addLine(plan) {
    if (plan == 'Level 1') {
      this.addLine1();
    }

    else if (plan == 'Level 2') {
      this.addLine2();
    }

    else if (plan == 'Level 3') {
      this.addLine3();
    }
  }

  addLine1() {
    if (this.plan1Items < this.plan1Lim) {
      this.plan1Total += 30;
      this.plan1Items++;
      this.plan1Lines.push('line');
    }
  }

  addLine2() {
    if (this.plan2Items < this.plan2Lim) {
      this.plan2Total += 50;
      this.plan2Items++;
      this.plan2Lines.push('line');
    }
  }

  addLine3() {
    if (this.plan3Items < this.plan3Lim) {
      this.plan3Total += 25;
      this.plan3Items++;
      this.plan3Lines.push('line');
    }
  }

  deleteLine(plan, line) {
    if (plan == 'Level 1') {
      this.deleteLine1(line);
    }

    else if (plan == 'Level 2') {
      this.deleteLine2(line);
    }

    else if (plan == 'Level 3') {
      this.deleteLine3(line);
    }
  }

  deleteLine1(line: any) {
    if (this.plan1Items > 1) {
      let index = this.plan1Lines.indexOf(line);
      this.plan1Total -= 30;
      this.plan1Lines.splice(index, 1);
      this.plan1Items--;
    }
  }

  deleteLine2(line: any) {
    if (this.plan2Items > 1) {
      let index = this.plan2Lines.indexOf(line);
      this.plan2Total -= 30;
      this.plan2Lines.splice(index, 1);
      this.plan2Items--;
    }
  }

  deleteLine3(line: any) {
    if (this.plan3Items > 3) {
      let index = this.plan3Lines.indexOf(line);
      this.plan3Total -= 30;
      this.plan3Lines.splice(index, 1);
      this.plan3Items--;
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

  deletePlan(plan) {
    if (plan === 'Level 1') {
      localStorage.removeItem('Plan 1');
    }
    else if (plan === 'Level 2') {
      localStorage.removeItem('Plan 2');
    }
    else if (plan === 'Level 3') {
      localStorage.removeItem('Plan 3');
    }
    location.reload();
  }

  createPlan(): void {
  //  this.newPlan.price = this.total;
    if(this.isLoggedIn) {
      this.planService.save(this.newPlan).subscribe(data => {
      });

      this.deviceService.save(this.device).subscribe((data) => {});
    }
  }
}
