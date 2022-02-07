"# angular-springboot-crud-employee" 
API Documentation

GET http://localhost:8080/api/v1/employee
Accept: application/json

####

GET http://localhost:8080/api/v1/employee/123
Accept: application/json

####

POST http://localhost:8080/api/v1/employee
Accept: application/json
Content-Type: application/json

{
 "employeeType" : "MANAGER"
}


###

PUT http://localhost:8080/api/v1/employee/vacation/d6d529e4-5b6e-49c4-8afa-12713e2586d1
Accept: application/json
Content-Type: application/json

{
  "requestedDays" : 25
}

###

PUT http://localhost:8080/api/v1/employee/work/add98fe9-bb26-4e7a-83ef-58805905d85a
Accept: application/json
Content-Type: application/json

{
  "workingDays" : 250
}
