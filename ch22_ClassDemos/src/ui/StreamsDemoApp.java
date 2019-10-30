package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import business.Contact;

public class StreamsDemoApp {

	public static void main(String[] args) {
		
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach",null,"555-5555"));
		contacts.add(new Contact("Anne Boehm",null,null));
		contacts.add(new Contact("Joel Murach","joel@murach.com",null));
		
		contacts.stream().filter(c -> c.getPhone() == null)
						.forEach(c -> System.out.println(c.getName()));
		List<Contact> contactsNoPhone = contacts.stream().filter(c -> c.getPhone() == null)
				.collect(Collectors.toList());
		
		System.out.println("There are "+contactsNoPhone.size()+" contacts with no phone number.");
		
		List<String> contactNames = contacts.stream().map(c -> c.getName()).collect(Collectors.toList());
		contactNames.stream().forEach(str -> System.out.println(str));
		
		List<String> contactNames2 = contacts.stream().map(Contact::getName).collect(Collectors.toList());
		contactNames2.stream().forEach(System.out::println);
		
		String csv = contacts.stream().map(Contact::getName).reduce("All contacts: ", (a,b) -> a + b + ", ");
		csv = csv.substring(0,csv.length()-2);
		System.out.println(csv);

	}

}
