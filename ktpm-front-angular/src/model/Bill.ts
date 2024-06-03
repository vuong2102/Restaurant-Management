import { Guid } from "guid-typescript";

export class Bill {
  public id: number;
  public clientId: number;
  public tableOrderId: number;
  public totalPrice: number;
  public dateOrder: Date;
  public statusPay: any;
  constructor(id: number, clientId: number, tableOrderId: number, totalPrice: number, dateOrder: Date, statusPay: any) {
    this.id = id;
    this.clientId = clientId;
    this.tableOrderId = tableOrderId;
    this.totalPrice = totalPrice;
    this.dateOrder = dateOrder;
    this.statusPay = statusPay;
  }
}
