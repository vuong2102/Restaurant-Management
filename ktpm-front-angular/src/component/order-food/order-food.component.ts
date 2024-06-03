import { Table } from './../../model/Table';
import { Router } from '@angular/router';
import { Client } from './../../model/Client';
import { FoodOrder } from './../../model/FoodOrder';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Food } from 'src/model/Food';
import { FoodService } from 'src/service/foodService/food.service';
import { TableService } from 'src/service/tableService/table.service';
import { ClientService } from 'src/service/userService/client.service';
import { BillService } from 'src/service/billService/bill.service';
import { Guid } from 'guid-typescript';
import { Bill } from 'src/model/Bill';


@Component({
  selector: 'app-order-food',
  templateUrl: './order-food.component.html',
  styleUrls: ['./order-food.component.css'],
})
export class OrderFoodComponent implements OnInit, OnChanges {
  listFood: Food[] = [];
  listTable: Table[] = [];
  tableSelected: Table = {} as Table;
  listFoodOrder: FoodOrder[] = [];
  totalPrice = 0;
  quantity = 1;
  totalNumber!: number;
  foodOrder: FoodOrder = {} as FoodOrder;
  foodGetById: Food = {} as Food;
  client: Client = {} as Client;
  bill: Bill = {} as Bill;
  idClient: number | undefined;
  idBill: any;
  searchTerm: any;
  page: number = 1;
  constructor(
    private foodService: FoodService,
    private tableService: TableService,
    private clientService: ClientService,
    private billService: BillService,
    private router: Router
  ) {}
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.getAllFood();
    this.getAllTable();
    this.checkSearchTerm();
  }
  checkSearchTerm(){
    if(this.searchTerm !== null){
      this.page = 1
    }
  }
  getAllFood() {
    this.foodService.getAll().subscribe((res: any) => {
      this.listFood = res;
    });
  }
  getAllTable() {
    this.tableService.getAll().subscribe((res: any) => {
      this.listTable = res;
    });
  }

  onCheckboxChange(table: any) {
    this.tableSelected = table;
  }
  isTableSelected(table: any): boolean {
    return this.tableSelected === table;
  }
  increaseQuantity(foodOrder: FoodOrder) {
    foodOrder.quantity += 1;
    this.totalPrice += foodOrder.price;
  }
  decreaseQuantity(foodOrder: FoodOrder) {
    foodOrder.quantity -= 1;
    if (foodOrder.quantity < 1) {
      alert('Ban muon xoa food??');
      this.listFoodOrder = this.listFoodOrder.filter(
        (item) => item.quantity >= 1
      );
    }
    this.totalPrice -= foodOrder.price;
  }
  onQuantityChange() {
    this.totalPrice = this.calculateTotal();
  }
  calculateTotal(): number {
    return this.listFoodOrder.reduce((total, food) => total + food.price * food.quantity, 0);
  }
  // saveClient() {
  //   this.clientService.createClient(this.client).subscribe(
  //     (data: any) => {
  //       this.idClient = data.id;
  //       this.changeStatusTable();
  //     },
  //     (error) => console.log(error)
  //   );
  //   alert("Order SuccessFully...");
  // }

  saveBill(table: Table) {
    const billFinal: Object = {
      clientId: null,
      tableOrderId: table.id,
      totalPrice: this.totalPrice,
      dateOrder: new Date(),
    };
    this.billService.createBill(billFinal).subscribe(
      (data: any) => {
        this.listFoodOrder.forEach(element => {
          element.billId = data.id;
        });
        this.saveListFoodOrder(this.listFoodOrder);
        this.changeStatusTable();
      },
      (error) => console.log(error)
    );
  }
  createBill(bill: any) {
    this.billService.createBill(bill).subscribe(
      (data) => {
      },
      (error) => console.log(error)
    );
  }
  changeStatusTable(){
    const table: Table = {
      id: this.tableSelected.id,
      number: this.tableSelected.number,
      status: this.tableSelected.status,
      area: this.tableSelected.area,
    }
    this.tableService.changeStatusTable(table).subscribe(
      (data: any) => {
      },
      (error) => console.log(error)
    );
  }

  saveListFoodOrder(listFoodOrder: any){
    this.billService.saveListFoodOrder(listFoodOrder).subscribe(
      (data) => {
      },
      (error) => console.log(error)
    );
  }
  addToOrder(food: Food) {
    const existingFoodOrder = this.listFoodOrder.find(
      (item) => item.foodId === food.id
    );
    if (existingFoodOrder) {
      alert('Food Already Exist!!!');
    } else {
      const foodOrder2: FoodOrder = {
        id: food.id,
        quantity: 1,
        foodId: food.id,
        name: food.name,
        price: food.price,
        billId: this.idBill,
      };
      this.foodOrder.id = food.id;
      this.listFoodOrder.push(foodOrder2);

      for (let foodOrder of this.listFoodOrder) {
        this.foodService.getFoodById(foodOrder.foodId).subscribe((data) => {
          this.foodGetById = data;
        });
      }
      this.totalPrice += foodOrder2.price * foodOrder2.quantity;
    }
  }
  async onSubmit() {
    if(this.listFoodOrder.length == 0) alert("You need to choose some Foods !!!")
    else if(this.tableSelected.id == null) alert("Table is required !!!")
    else{
      this.saveBill(this.tableSelected);

    }
  }
  onSearch(){
    this.filterList();
  }
  filteredListFood: Food[] = [];
  filterList() {
    this.filteredListFood = this.listFood.filter(food =>
      food.name.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
    this.listFood = this.filteredListFood;
    console.log(this.filteredListFood)
  }
}
