import { Component, OnInit } from '@angular/core';
import { setLines } from '@angular/material/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  name = localStorage.getItem('Name');
  lines: string[] = [];
  items: number = 0;

  constructor() { }

  ngOnInit(): void {
    if (this.name != null) {
      this.lines = ['line']
      this.items = 1;
    }
  }

  addLine() {
    this.lines.push('line');
    this.items++;
  }
}
