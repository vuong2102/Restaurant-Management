import { Component, OnInit } from '@angular/core';
import { FoodService } from '../../../service/foodService/food.service';
import { Food } from 'src/model/Food';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-food',
  templateUrl: './manage-food.component.html',
  styleUrls: ['./manage-food.component.css'],
})
export class ManageFoodComponent implements OnInit {
  listFood: Food[] = [];

  ngOnInit(): void {
    this.getAll();
  }
  constructor(private foodService: FoodService, private router: Router) {}

  getAll() {
    this.foodService.getAll().subscribe((res: any) => {
      this.listFood = res;
    });
  }
  detailFood(id: number) {
    this.router.navigate(['foods', id]);
  }
  deleteFood(id: number) {
    this.foodService.deleteFood(id).subscribe((data) => {
      this.router.navigate(['']);
      alert('Delete SuccessFully');
      // this.getEmployees();
    });
  }
  addFood(){
    this.router.navigate(['/create-food']);
  }
}
