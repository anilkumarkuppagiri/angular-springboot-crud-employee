import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { Vacation } from './vacation';
import { WorkRequest } from './workRequest';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8080/api/v1/employee";

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployeeWork(id: number, work: WorkRequest): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, work);
  }

  updateEmployeeVacation(id: number, vacation: Vacation): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, vacation);
  }
}
