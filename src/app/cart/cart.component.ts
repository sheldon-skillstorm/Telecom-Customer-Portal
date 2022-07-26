import { Component, OnInit } from '@angular/core';
import { setLines } from '@angular/material/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  name = localStorage.getItem('Name');
  total = 0;
  lines: string[] = [];
  items: number = 0;

  constructor() { }

  ngOnInit(): void {
    if (this.name != null) {
      this.lines = ['line']
      this.items = 1;
    }

    if (this.name === 'Level 1') {
      this.total = 30;
    }

    else if (this.name == 'Level 2') {
      this.total = 50;
    }

    else if (this.name == 'Level 3') {
      this.total = 25;
    }
  }

  addLine() {
    if (this.name == 'Level 1') {
      this.total += 30;
    }

    else if (this.name == 'Level 2') {
      this.total += 50;
    }

    else if (this.name == 'Level 3') {
      this.total += 25;
    }

    this.lines.push('line');
    this.items++;
  }

  deleteLine(line: any) {
    if (this.name == 'Level 1') {
      this.total -= 30;
    }

    else if (this.name == 'Level 2') {
      this.total -= 50;
    }

    else if (this.name == 'Level 3') {
      this.total -= 25;
    }

    let index = this.lines.indexOf(line);
    this.lines.splice(index, 1);
    this.items--;
  }
}
