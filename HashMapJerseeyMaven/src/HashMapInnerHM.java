package com.kevin.HashMapProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HashMapInnerHM {
	public static void main(String[] args)

	{
		List<Customer> customerList = new ArrayList<Customer>();
		
		Customer cust1 = new Customer("Kevin", "Kilrush");
		Customer cust2 = new Customer("Brendan", "Cappa");
		Customer cust3 = new Customer("Marty", "Cooraclare");
		Customer cust4 = new Customer("Derick", "Kilkee");
		
		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
		customerList.add(cust4);
		
		Map<String, Map<String, List<Customer>>> map = new HashMap<String, Map<String, List<Customer>>>();
		Map<String, List<Customer>> innerHashMap = new HashMap<String, List<Customer>>();
			
		map.put("eu", innerHashMap);
		map.put("us", innerHashMap);
		innerHashMap.put("ie", customerList);
		innerHashMap.put("uk", customerList);
		
		List<Customer> lst = new ArrayList<Customer>();
		
		// Code checks if the outer HM is 'eu' and then if the next HM is 'ie' in which
		// case the ArrayList is assigned to a temp ArrayList and a new Customer is added
		for (Entry<String, Map<String, List<Customer>>> outer : map.entrySet()) {
			if(outer.getKey().equals("eu")) {
				System.out.println("EU Exists");
				
				// Assigns the <String, List<Customer> HashMap to a temp HashMap
				Map<String, List<Customer>> innerHashmap = new HashMap<String, List<Customer>>();
				innerHashmap = outer.getValue();
				
				for (Entry<String, List<Customer>> inner : innerHashmap.entrySet()) {
					if(inner.getKey().equals("uk")) {
						System.out.println("United Kingdom Exists.");
						
						// Get the ArrayList<Customer> and i can start adding Customers to this List.
						lst = new ArrayList<Customer>();
						lst = inner.getValue();
						lst.add(new Customer("Tony", "New York"));	
						innerHashMap.put("uk", lst);
					}			
				}
				
				for (Entry<String, List<Customer>> inner : innerHashmap.entrySet()) {
					if(inner.getKey().equals("uk")) {					
						lst = new ArrayList<Customer>();
						lst = inner.getValue();
						System.out.println("Check that i have five (5) Customers in the ArrayList: " + lst.size());
					}			
				}
				
				if (!lst.isEmpty()) {
					for (Customer customer : lst) {
						System.out.println("Customer Name: " + customer.getName() + ", Address: " + customer.getAddress());
					}
				}
			}
		} 
		
		map.put("asia", innerHashMap);
		for(Entry<String, Map<String, List<Customer>>> entry : map.entrySet()) {
			System.out.println("HashMap now contains these Regions: " + entry.getKey());
		}
	}
}
