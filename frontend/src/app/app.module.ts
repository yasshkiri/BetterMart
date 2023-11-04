import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Front/home/home.component';
import { CartComponent } from './Front/cart/cart.component';
import { CheckoutComponent } from './Front/checkout/checkout.component';
import { OrderHistoryComponent } from './Front/order-history/order-history.component';
import { ClaimComponent } from './Front/claim/claim.component';
import { NavbarComponent } from './Front/navbar/navbar.component';
import { FooterComponent } from './Front/footer/footer.component';
import { PurchaseOrderComponent } from './Front/purchase-order/purchase-order.component';
import { SuggestionComponent } from './Front/suggestion/suggestion.component';
import { RelyComponent } from './Front/rely/rely.component';
import { HeaderComponent } from './Back/header/header.component';
import { FooterbComponent } from './Back/footerb/footerb.component';
import { HomebbbComponent } from './Back/homebbb/homebbb.component';
import { ForumComponent } from './Front/forum/forum.component';
import { DiscountComponent } from './Back/discount/discount.component';
import { PurchaseComponent } from './Back/purchase/purchase.component';
import { ClaimbComponent } from './Back/claimb/claimb.component';
import { DeliverybComponent } from './Back/deliveryb/deliveryb.component';
import { RelybComponent } from './Back/relyb/relyb.component';
import { RelysComponent } from './Back/relys/relys.component';
import { UsersComponent } from './Back/users/users.component';
import { SidebarbComponent } from './Back/sidebarb/sidebarb.component';
import { ForumbbComponent } from './Back/forumbb/forumbb.component';
import { RegisterComponent } from './Front/UserFront/register/register.component';
import { LoginComponent } from './Front/UserFront/login/login.component';
import { ForgotPasswordComponent } from './Front/UserFront/forgot-password/forgot-password.component';
import { SuccessComponent } from './Front/UserFront/success/success.component';
import { ErrorComponent } from './Front/UserFront/error/error.component';
import {  HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SidebarbComponent,
    UsersComponent,
    RelysComponent,
    RelyComponent,
    DeliverybComponent,
    HeaderComponent,
    ClaimComponent,
    ClaimbComponent,
    ForumComponent,
    PurchaseComponent,
    DiscountComponent,
    HomebbbComponent,
    FooterbComponent,
    FooterComponent,
    RelybComponent,
    SuggestionComponent,
    PurchaseOrderComponent,
    NavbarComponent,
    OrderHistoryComponent,
    CartComponent,
    CheckoutComponent,
    ForumbbComponent,
    RegisterComponent,
    LoginComponent,
    ForgotPasswordComponent,
    SuccessComponent,
    ErrorComponent,
    
   

 
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
