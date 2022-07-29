export class Device {
  id: number;
  name: string;
  number: string;

  constructor(id: number, name: string, number: string) {
    this.id = id;
    this.number = number;
    this.name = name;
  }
}
