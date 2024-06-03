import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Bill } from 'src/model/Bill';
import { Client } from 'src/model/Client';
import { Food } from 'src/model/Food';
import { FoodOrder } from 'src/model/FoodOrder';
import { Table } from 'src/model/Table';
import { BillService } from 'src/service/billService/bill.service';
import { FoodService } from 'src/service/foodService/food.service';
import { TableService } from 'src/service/tableService/table.service';
import { ClientService } from 'src/service/userService/client.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  billUnpaid: Bill[] = [];
  table: Table = {} as Table;
  listObjectBillTable: any[] = [];
  page: number = 1;
  searchTerm: any;
  listFoodToAdd: any;

  ngOnInit(): void {
    this.getAllBill();
    console.log(this.listObjectBillTable);
  }
  constructor(
    private foodService: FoodService,
    private tableService: TableService,
    private clientService: ClientService,
    private billService: BillService,
    private router: Router
  ) {}
  id: any;
  getDataTable(bill: Bill) {
    this.tableService
      .getTableById(bill.tableOrderId)
      .subscribe((res: Table) => {
        this.table = res;
        this.id = res.id;
        const date: Date = new Date(bill.dateOrder);

        // Lấy các thành phần ngày và giờ phút
        const year: number = date.getFullYear();
        const month: string = String(date.getMonth() + 1).padStart(2, '0');
        const day: string = String(date.getDate()).padStart(2, '0');
        const hours: string = String(date.getHours()).padStart(2, '0');
        const minutes: string = String(date.getMinutes()).padStart(2, '0');

        // Tạo chuỗi định dạng mong muốn
        const formattedDate: string = `${hours}:${minutes} ${day}-${month}-${year}`;
        const billObjectTable: any = {
          billId: bill.id,
          numberTable: res.number,
          areaTable: res.area,
          dateOrder: formattedDate,
          statusPay: bill.statusPay,
        };
        if (billObjectTable.statusPay != 'Paid')
          this.listObjectBillTable.push(billObjectTable);
      });
  }

  getAllBill() {
    this.billService.getAllBill().subscribe(
      (res: Bill[]) => {
        this.billUnpaid = res;
        this.billUnpaid.forEach(async (element: Bill) => {
          await this.getDataTable(element);
        });
      },
      (error) => console.log(error)
    );
  }
  getTableById(id: number) {
    this.tableService.getTableById(id).subscribe((res: any) => {
      this.table = res;
    });
  }
  onSearch() {
    this.filterList();
  }
  filteredListBill: any[] = [];
  filterList() {
    this.filteredListBill = this.listObjectBillTable.filter((data) =>
      data.numberTable.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
    this.listObjectBillTable = this.filteredListBill;
    console.log(this.filteredListBill);
  }
  billTable: any = {
    billId: 0,
    numberTable: 0,
    areaTable: '',
    statusPay: 'Unpaid',
  };
  isBillTableSelected(table: any): boolean {
    return this.billTable === table;
  }
  listFoodOrder: FoodOrder[] = [];
  searchFoodBill(id: number) {
    this.foodService.getAllFoodBillByBillId(id).subscribe((res: any) => {
      this.listFoodOrder = res;
    });
  }
  printBill() {
    alert('Payment Successfully!!!');
    this.billService.changeStatusBill(this.billTable.billId).subscribe(
      (res: any) => {
        console.log(res);
        this.listObjectBillTable = this.listObjectBillTable.filter(
          (bill) => bill.billId !== this.billTable.billId
        );
      },
      (error) => console.log(error)
    );
  }
  selectedPaymentMethod = ''; // Initially empty
  isAddFoodVisible: any;
  onPaymentMethodChange(event: any) {
    this.selectedPaymentMethod = event.target.value;
  }
  hideAddFoodDiv() {
    this.isAddFoodVisible = false;
  }
  listFoodToAddAfter: Food[] = [];
  listFoodChooseToAdd: Food[] = [];
  showAddFoodDiv() {
    this.isAddFoodVisible = true;
    this.getAllFood();
  }
  getAllFood() {
    this.foodService.getAll().subscribe((data: Food[]) => {
      data.forEach((element) => {
        if (this.id != element.comboId) {
          this.listFoodChooseToAdd.push(element);
        }
      });
      this.listFoodToAdd = this.listFoodChooseToAdd;
    });
  }
  onCheckboxChange(food: Food, event: any) {
    const foodOrderAdd: FoodOrder = {
      id: 0,
      foodId: food.id,
      quantity: 1,
      name: food.name,
      price: food.price,
      billId: this.billTable.id,
    };
    if (event && event.target && typeof event.target.checked === 'boolean') {
      if (event.target.checked) {
        this.listFoodOrder.push(foodOrderAdd);
      } else {
        const index = this.listFoodChooseToAdd.findIndex(
          (f) => f.id === food.id
        );
        if (index > -1) {
          this.listFoodChooseToAdd.splice(index, 1);
        }
      }
    } else {
      console.error('Invalid event or target');
    }
  }
  saveFoodAdd() {
    this.billService.saveListFoodOrder(this.listFoodToAdd);
  }
}
