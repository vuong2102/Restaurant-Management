import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFoodComponent } from 'src/component/food/add-food/add-food.component';
import { DetailFoodComponent } from 'src/component/food/detail-food/detail-food.component';
import { ManageFoodComponent } from 'src/component/food/manage-food/manage-food.component';
import { OrderFoodComponent } from 'src/component/order-food/order-food.component';
import { PaymentComponent } from 'src/component/payment/payment.component';
import { Combo } from '../model/Combo';
import { ComboComponent } from 'src/component/combo/manage-combo/combo.component';
import { ComboDetailComponent } from 'src/component/combo/combo-detail/combo-detail.component';

const routes: Routes = [
  {path: '', component: ManageFoodComponent},
  {path: 'foods/:id', component: DetailFoodComponent},
  {path: 'create-food', component: AddFoodComponent},
  {path: 'order-food', component: OrderFoodComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'combo', component: ComboComponent},
  {path: 'combo/:id', component: ComboDetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
