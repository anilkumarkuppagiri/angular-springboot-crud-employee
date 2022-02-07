import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeWorkComponent } from './update-employee-work/update-employee-work.component';
import { UpdateEmployeeVacationComponent } from './update-employee-vacation/update-employee-vacation.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  {path: 'employees', component: EmployeeListComponent},
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'update-employee-work/:id', component: UpdateEmployeeWorkComponent},
  {path: 'update-employee-vacation/:id', component: UpdateEmployeeVacationComponent},
  {path: 'employee-details/:id', component: EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
