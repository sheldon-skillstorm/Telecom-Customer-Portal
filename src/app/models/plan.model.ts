export class Plan {
    id: number;
    name: string;
    price: number;
    data: string;
    hotspot: string;
    streaming: string;
    
    constructor(id: number, name: string, price: number, data: string, hotspot: string, streaming: string) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.data = data;
        this.hotspot = hotspot;
        this.streaming = streaming;
    }
}