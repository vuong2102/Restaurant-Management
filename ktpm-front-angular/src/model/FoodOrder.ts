export class FoodOrder {
  id: number;
  foodId: number;
  quantity: number;
  name: string;
  price: number;
  billId: number;

  constructor(data: any) {
    this.id = data.id ?? 0; // Sử dụng 0 nếu id không được cung cấp
    this.foodId = data.foodId;
    this.quantity = data.quantity;
    this.name = data.name;
    this.price = data.price;
    this.billId = data.billId;
  }
}
