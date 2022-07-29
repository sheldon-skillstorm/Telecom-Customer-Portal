import { Component, OnInit } from '@angular/core';
import { Device } from '../models/device.model';
import { DeviceService } from '../services/device.service';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css'],
})
export class ManageComponent implements OnInit {
  public device: Device[];

  constructor(private deviceService: DeviceService) {}

  ngOnInit(): void {
    this.deviceService.findAll().subscribe((data) => {
      //console.log("body: " + data.body);
      if (data.body != null) {
        this.device = data.body;
      }
    });
  }
}
