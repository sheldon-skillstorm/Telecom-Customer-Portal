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
  limit: number = 0;
  errorMessage = 'cannot exceed plan device limit';

  constructor() { }

  ngOnInit(): void {
    if (this.name == 'Level 1' || this.name == 'Level 2') {
      this.lines = ['line']
      this.items = 1;
    }

    else { 
      this.items = 3; 
      this.lines = ['line'];
    }

    if (this.name === 'Level 1') {
      this.total = 30;
      this.limit = 2;
    }

    else if (this.name == 'Level 2') {
      this.total = 50;
      this.limit = 3;
    }

    else if (this.name == 'Level 3') {
      this.total = 75;
      this.limit = 7;
      this.lines.push('line', 'line');
    }
  }

  addLine() {
    if (this.items < this.limit) {
      if (this.name == 'Level 1') {
        this.total += 30;
      }
  
      else if (this.name == 'Level 2') {
        this.total += 50;
      }
  
      else if (this.name == 'Level 3') {
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
    }

    else if (this.name == 'Level 2') {
      this.total -= 50;
      this.lines.splice(index, 1);
      this.items--;
    }

    else if (this.name == 'Level 3') {
      if (this.items > 3) {
        this.total -= 25;
        this.lines.splice(index, 1);
        this.items--;
      }
    }
  }
}
