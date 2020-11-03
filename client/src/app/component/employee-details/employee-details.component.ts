import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: string;
  employee: Employee;

  constructor(private route:ActivatedRoute,private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

  this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
    },error=>{
      console.log(error);
    });
  }

}
