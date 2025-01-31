import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8080/api/v1/employees";

  constructor(private httpClient: HttpClient) { }

  getEmployeeList() : Observable<Employee[]>{
      return this.httpClient.get<Employee[]>(`${this.baseUrl}`);
  } 

  createEmployee(employee : Employee): Observable<any>{
    return this.httpClient.post(`${this.baseUrl}`,employee);
  }

  getEmployeeById(id:string):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/${id}`);
  }

  updateEmployee(id:String,employee:Employee):Observable<any>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,employee);
  }

  deleteEmployee(id:String):Observable<any>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
