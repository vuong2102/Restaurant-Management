import { Component, OnInit } from '@angular/core';
import { FoodService } from '../../../service/foodService/food.service';
import { Food } from 'src/model/Food';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detail-food',
  templateUrl: './detail-food.component.html',
  styleUrls: ['./detail-food.component.css']
})

export class DetailFoodComponent implements OnInit{
  food: Food = {} as Food;
  id: any;

  constructor(private foodService: FoodService,
    private router: Router,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.foodService.getFoodById(this.id).subscribe(data => {
      this.food = data
    })
  }
}
