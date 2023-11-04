import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Front/home/home.component';
import { CartComponent } from './Front/cart/cart.component';
import { CheckoutComponent } from './Front/checkout/checkout.component';
import { OrderHistoryComponent } from './Front/order-history/order-history.component';
import { ClaimComponent } from './Front/claim/claim.component';
import { PurchaseOrderComponent } from './Front/purchase-order/purchase-order.component';
import { SuggestionComponent } from './Front/suggestion/suggestion.component';
import { RelyComponent } from './Front/rely/rely.component';
import { HomebbbComponent } from './Back/homebbb/homebbb.component';
import { FooterbComponent } from './Back/footerb/footerb.component';
import { HeaderComponent } from './Back/header/header.component'; 
import { ForumComponent } from './Front/forum/forum.component';
import { DiscountComponent } from './Back/discount/discount.component';
import { ClaimbComponent } from './Back/claimb/claimb.component';
import { DeliverybComponent } from './Back/deliveryb/deliveryb.component';
import { RelybComponent } from './Back/relyb/relyb.component';
import { RelysComponent } from './Back/relys/relys.component';
import { UsersComponent } from './Back/users/users.component';
import { PurchaseComponent } from './Back/purchase/purchase.component';
import { SidebarbComponent } from './Back/sidebarb/sidebarb.component';
import { ForumbbComponent } from './Back/forumbb/forumbb.component';
import { RegisterComponent } from './Front/UserFront/register/register.component';
import { LoginComponent } from './Front/UserFront/login/login.component';
import { ForgotPasswordComponent } from './Front/UserFront/forgot-password/forgot-password.component';
import { ErrorComponent } from './Front/UserFront/error/error.component'; 
import { SuccessComponent } from './Front/UserFront/success/success.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'Cart', component: CartComponent},
  {  path: 'Checkout', component: CheckoutComponent },
  {  path: 'OrderHistory', component:  OrderHistoryComponent},
  {  path: 'Claim', component:  ClaimComponent},
  {  path: 'Purchase', component:  PurchaseOrderComponent},
  {  path: 'Suggestion', component:  SuggestionComponent},
  {  path: 'Rely', component:  RelyComponent},
  {  path: 'Homebbb', component:  HomebbbComponent},
  {  path: 'Forum', component:  ForumComponent},
  {  path: 'Discount', component:  DiscountComponent},
  {  path: 'PurchaseB', component:  PurchaseComponent},
  {  path: 'ClaimB', component:  ClaimbComponent},
  {  path: 'DeliveryB', component:  DeliverybComponent},
  {  path: 'RelyB', component:  RelybComponent},
  {  path: 'RelyS', component:  RelysComponent},
  {  path: 'Users', component:  UsersComponent},
  {  path: 'Forumbb', component:  ForumbbComponent},
  {  path: 'Register', component:  RegisterComponent},
  {  path: 'loginn', component:  LoginComponent},
  {  path: 'forgotpassword', component:  ForgotPasswordComponent},
  {  path: 'errorLogin', component:  ErrorComponent},
  {  path: 'success', component:  SuccessComponent},







  


  

 
  {path: '', redirectTo: '', pathMatch: 'full'}
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }




