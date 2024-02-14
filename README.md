# employee-management-with-graphql

After running project user the url: http://localhost:8080/graphiql

#Find an employee by id using query structure as below
 query employee {
   findEmployeeById(id: "1") {
     id
     firstName
     lastName
     department
     designation

   }
 }

 
#Find all employees using query structure as below

 query allEmployees {
   findAllEmployees {
     id
     firstName
     lastName
     department
     designation
   }
 }

#Create a new employee using the mutation structure as below

 mutation employeeAddition {
   createEmployee (addedEmployee:{
     firstName:"Rodgers"
     lastName: "Ouko"
     department:"Technical department"
     designation:"Software development in test"
   }
   ) {
     id
     firstName
     lastName
     department
     designation
   }
 }

#Update an employee using the mutation structure as below

 mutation employeeUpdate {
   updateEmployee(id:"2", updatedEmployee: {
     firstName:"Duncan"
     lastName: "Karani"
     department:"Technical department"
     designation:"Assistant Manager"
   }){
     id
     firstName
     lastName
     department
     designation
   }
 }
