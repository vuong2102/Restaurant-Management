import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Combo } from 'src/model/Combo';
import { Food } from 'src/model/Food';
import { ComboService } from 'src/service/comboService/combo.service';
import { FoodService } from 'src/service/foodService/food.service';

@Component({
  selector: 'app-combo-detail',
  templateUrl: './combo-detail.component.html',
  styleUrls: ['./combo-detail.component.css'],
})
export class ComboDetailComponent implements OnInit {
  isAddFoodVisible: any;
  id: any;
  combo: Combo = {} as Combo;
  listFood: Food[] = [];
  listFoodToAdd: Food[] = [];
  listFoodToAddAfter: Food[] = [];
  listFoodChooseToAdd: Food[] = [];
  page:number = 1;
  
  constructor(
    private comboService: ComboService,
    private foodService: FoodService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.comboService.getComboById(this.id).subscribe((data) => {
      this.combo = data;
    });
    this.getListFoodOfCombo(this.id);
  }
  getListFoodOfCombo(id: any) {
    this.comboService.getFoodComboById(id).subscribe((data: Food[]) => {
      this.listFood = data;
    });
  }
  getAllFood(){
    this.foodService.getAll().subscribe((data: Food[]) => {
      data.forEach(element => {
        if(this.id != element.comboId){
          this.listFoodToAddAfter.push(element)
        }
      });
      this.listFoodToAdd = this.listFoodToAddAfter;
    });
  }
  updateFood(food: Food, comboId: any) {
    food.comboId = comboId;
    this.foodService.updateFood(food).subscribe(
      (data) => {},
      (error) => console.log(error)
    );
  }
  addFood(food: Food) {}
  hideAddFoodDiv() {
    this.isAddFoodVisible = false;
  }
  showAddFoodDiv() {
    this.isAddFoodVisible = true;
    this.getAllFood();
  }
  onCheckboxChange(food: Food, event: any) {
    if (event && event.target && typeof event.target.checked === 'boolean') {
      if (event.target.checked) {
        this.listFoodChooseToAdd.push(food);
      } else {
        const index = this.listFoodChooseToAdd.findIndex(f => f.id === food.id);
        if (index > -1) {
          this.listFoodChooseToAdd.splice(index, 1);
        }
      }
    } else {
      console.error('Invalid event or target');
    }
  }
  saveFoodAdd() {
    for(let food of this.listFoodChooseToAdd){
      this.updateFood(food, this.id);
    }
  }
}
