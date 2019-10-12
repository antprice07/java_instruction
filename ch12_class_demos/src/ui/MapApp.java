package ui;

import java.util.HashMap;
import java.util.Map;

import business.Product;

public class MapApp {

	public static void main(String[] args) {
		
		Map<String,Product> products = new HashMap<>();
		Product p1 = new Product("Java","Murach's Java",57.50);
		Product p2 = new Product("c#","Murach's C#",59.50);
		Product p3 = new Product("andr","Murach's Android",58.50);
		
		products.put(p1.getCode(), p1);
		products.put(p2.getCode(), p2);
		products.put(p3.getCode(), p3);
		
		for(Map.Entry<String,Product> prod:products.entrySet()) {
			System.out.println(prod.getKey()+": "+prod.getValue());
			
		}
		
		System.out.println(products.get("c#"));
		
		System.out.println(products.containsKey("java"));
		System.out.println(products.containsKey("Java"));
		
		
		
		
		

	
	}

}
