package com.andrei.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andrei.thymeleafdemo.entity.Customer;
import com.andrei.thymeleafdemo.service.CustomerService;



@Controller
@RequestMapping("/customers")
public class CustomerController {

	
	//load in-memory employee 
//	private List<Customer> customers;
//	
//	@PostConstruct
//	private void loadData() {
//		//create employee
//		Customer customer1 = new Customer(1,"Leslie",  "Andrews","leslie@email.com");
//		Customer customer2 = new Customer(2,"Ema",  "Baumgarten","emma@email.com");
//		Customer customer3 = new Customer(3,"Avani",  "Gupta","avani@email.com");
//		
//		//create the list
//		customers = new ArrayList<>();
//		customers.add(customer1);
//		customers.add(customer2);
//		customers.add(customer3);	
//	}
	
//	@GetMapping("/list")
//	public String listCustomers(Model model) {
//		
//		model.addAttribute("customers",customers);
//		
//		return "customers/simple-list-customers";
//	}
	
	
	
	//whire in our Customer Service
	@Autowired
	private CustomerService customerService;  //in course inject CustomerService in constructor
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customers = customerService.findAll();
		
		model.addAttribute("customers", customers);
		
		return "customers/fancy-list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customers/customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.save(customer);
		
		//"POST/Redirect/GET" pattern avoid duplicate submission in case user hits reload in the browser 
		return "redirect:/customers/list";   
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer= customerService.findById(id);
		
		
		model.addAttribute("customer", customer);
		
		
		return "customers/customer-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		
		customerService.deleteById(id);
		
		return "redirect:/customers/list";
	}
	
	
	
	
	
}
