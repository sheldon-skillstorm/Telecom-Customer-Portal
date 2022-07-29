import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Device } from '../Models/device.model';
import { DeviceService } from '../services/device.service';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css'],
})
export class DeviceComponent implements OnInit {
  device: Device[];
  newDevice: Device = new Device(0, '', '');
  router: any;

  constructor(private deviceService: DeviceService) {}

  ngOnInit(): void {
    this.deviceService.findAll().subscribe((data) => {
      //console.log("body: " + data.body);
      if (data.body != null) {
        this.device = data.body;
      }
    });
  }

  // create(): void {
  //   this.deviceService.save(this.newDevice).subscribe((data) => {});
  // }
}
