import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Device } from '../models/device.model';
import { DeviceService } from '../services/device.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css'],
})
export class DeviceComponent implements OnInit {
  isLoggedIn = true;
  device: Device[];
  newDevice: Device = new Device(0, '', '');
  router: any;

  constructor(
    private deviceService: DeviceService,
    private tokenStorage: TokenStorageService
  ) {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  ngOnInit(): void {
    this.deviceService.findAll().subscribe((data) => {
      //console.log("body: " + data.body);
      if (data.body != null) {
        this.device = data.body;
      }
    });
  }

  createDevice(): void {
    if (this.isLoggedIn) {
      this.deviceService.save(this.newDevice).subscribe((data) => {});
    }
  }
}
