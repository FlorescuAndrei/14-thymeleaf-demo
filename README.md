# 14-thymeleaf-demo
Spring Thymeleaf Learning project.  
A web app that show a list of customer. You can add a new customer, edit or delete a customer.  
This Spring Boot  app use Thymeleaf template instead of JSP for pages, and connect to MySQL database .  
  

Dependency: Web ; Thymeleaf; DevTools; Data JPA;  MySQL Driver (mysql-connector-java);  
Links for remote bootstrap files:  
  - https://getbootstrap.com/		-> get started -> Starter template – copy and add to html page.  
  
How to use the app:  
Select from CustomerController  
  - simple-list-customers.html – show the page in a basic format. Created for test before adding Services and DAO package;
  - fancy-list-customers.html – add style using css and bootstrap framework.
  
  
 Learning notes:  
 /static/index.html  redirect for localhost:8080.    
 
 | Expresion | Description                                        |
| :----------|:---------------------------------------------------|
| th: action | Location to send form data                         |
| th: object | Reference to model attribute                       |
| th: field  | Bind input field to  a property on model attribute | 
   
     
To do:  
Add security.  
  
  
  
[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git) 

 
