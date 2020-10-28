import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees:Employee[];

  constructor(private employeeService : EmployeeService,private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data =>{
      this.employees = data;
    });
  }

  updateEmployee(id:string){
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id:string){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
        this.getEmployees();
    },error=>{
      console.log(error);
    })
  }

}
