import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ManageFoodComponent } from '../component/food/manage-food/manage-food.component';
import { NavbarComponent } from '../component/navbar/navbar.component';
import { HomeComponent } from '../component/home/home.component';
import { DetailFoodComponent } from '../component/food/detail-food/detail-food.component';
import { AddFoodComponent } from '../component/food/add-food/add-food.component';
import { OrderFoodComponent } from '../component/order-food/order-food.component';
import { ManageOrderComponent } from '../component/manage-order/manage-order.component';
import { PaymentComponent } from '../component/payment/payment.component';
import { ComboComponent } from '../component/combo/manage-combo/combo.component';
import { ComboDetailComponent } from '../component/combo/combo-detail/combo-detail.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    ManageFoodComponent,
    NavbarComponent,
    HomeComponent,
    DetailFoodComponent,
    AddFoodComponent,
    OrderFoodComponent,
    ManageOrderComponent,
    PaymentComponent,
    ComboComponent,
    ComboDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
