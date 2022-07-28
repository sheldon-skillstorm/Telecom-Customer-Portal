export class Plan {
    id: number;
    name: string;
    price: number;
    data: string;
    hotspot: string;
    streaming: string;
    limit: number;
    
    constructor(id: number, name: string, price: number, data: string, hotspot: string, streaming: string, limit: number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.data = data;
        this.hotspot = hotspot;
        this.streaming = streaming;
        this.limit = limit;
    }
}