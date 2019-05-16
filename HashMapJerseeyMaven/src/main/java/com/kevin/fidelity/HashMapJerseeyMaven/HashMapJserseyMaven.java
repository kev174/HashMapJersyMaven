package com.kevin.fidelity.HashMapJerseeyMaven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;



public class HashMapJserseyMaven {
	
	private final static Logger log = Logger.getLogger(HashMapJserseyMaven.class);
	
	public static void main(String[] args)

	{	
		log.info("THIS IS A WARNING");	
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		Customer cust1 = new Customer("Kevin", "Kilrush");
		Customer cust2 = new Customer("Brendan", "Cappa");
		Customer cust3 = new Customer("Marty", "Cooraclare");
		Customer cust4 = new Customer("Derick", "Kilkee");
		Customer cust5 = new Customer("Josie", "Cavann");
		
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
		
		List<Customer> customerArrayList = new ArrayList<Customer>();	
		Map<String, List<Customer>> tempInnerHM = new HashMap<String, List<Customer>>();

		if(map.containsKey("eu")) {
			// innerHashmap is assigned the main HashMaps embedded HashMap.  
			tempInnerHM = map.get("eu");
			if(tempInnerHM.containsKey("ie")) {
				customerArrayList = tempInnerHM.get("ie");
				customerArrayList.add(new Customer("Tony", "Tipperary"));
			}
			for (Customer customer : customerArrayList) {
				System.out.println("Customer Name: " + customer.getName() + ", Address: " + customer.getAddress());
			}
		}
		
		// Iterates through a HashMap and assigns <Customer> to ArrayList
		for (Entry<String, List<Customer>> inner : tempInnerHM.entrySet()) {
			if(inner.getKey().equals("uk")) {					
				customerArrayList = new ArrayList<Customer>();
				customerArrayList = inner.getValue();
				System.out.println("Check that i have five (5) Customers in the ArrayList: " + customerArrayList.size());
			}			
		}
		
		map.put("asia", innerHashMap);
		for(Entry<String, Map<String, List<Customer>>> entry : map.entrySet()) {
			System.out.println("HashMap now contains these Regions: " + entry.getKey());
		}
	}
}
