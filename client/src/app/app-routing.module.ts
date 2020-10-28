import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './component/create-employee/create-employee.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './component/update-employee/update-employee.component';

const routes: Routes = [
{path:'employees', component:EmployeeListComponent},
{path:'create-employee',component:CreateEmployeeComponent},
{path:'',redirectTo:'employees',pathMatch:'full'},
{path:'update-employee/:id',component:UpdateEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
