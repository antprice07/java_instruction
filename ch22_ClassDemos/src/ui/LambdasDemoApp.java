package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import business.Contact;


public class LambdasDemoApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Lambda / Stream Demo App");
		
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach",null,"555-5555"));
		contacts.add(new Contact("Anne Boehm",null,null));
		contacts.add(new Contact("Joel Murach","joel@murach.com",null));
		
		List<Contact> contactsNoPhone = contactsNoPhone(contacts);
		
		for(Contact c : contactsNoPhone) {
			System.out.println(c);
		}
		
		List<Contact> contactsWOPhone = filterContacts(contacts, c -> c.getPhone()==null);
		for(Contact c: contactsWOPhone) {
			System.out.println(c.getName());
		}
		
		List<Contact> contactNoEmail = filterContacts(contacts, c -> {return c.getEmail()==null&& c.getPhone()==null;});
		for(Contact c: contactNoEmail) {
			System.out.println(c.getName());
		}
		
		
		processContacts(contacts, c -> c.setName(c.getName().toUpperCase()));
		
		processContacts(contacts, c -> System.out.println(c.getName()));
		
		List<String> contactPhoneNumbers = transformContacts(contacts, c -> {
			String phone = c.getPhone()==null ? "n/a" : c.getPhone();
					return c.getName()+": " + phone;
		});
		
		for(String phoneNumber:contactPhoneNumbers) {
			System.out.println(phoneNumber);
		}
		
		processContacts2(contacts, c -> c.getPhone()==null,
				c -> c.getName().toLowerCase(),
				str -> System.out.println(str));

	}
	
	private static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition){
		
		List<Contact> filteredContacts = new ArrayList<>();
		
		for(Contact c : contacts) {
			if(condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
	}
	
	private static List<Contact> contactsNoPhone(List<Contact> contacts){
		List<Contact> contactsNoPhone = new ArrayList<>();
		for (Contact c : contacts) {
			if (c.getPhone()==null) {
				contactsNoPhone.add(c);
			}
		}
		return contactsNoPhone;
	}
	
	private static void processContacts(List<Contact> contacts, Consumer<Contact> consumer) {
		for(Contact c : contacts) {
			consumer.accept(c);
		}
	}
	
	private static List<String> transformContacts(List<Contact> contacts, Function<Contact,String> function){
		List<String> strings = new ArrayList<>();
		for(Contact c:contacts) {
			strings.add(function.apply(c));
		}
		return strings;
	}
	
	private static void processContacts2(List<Contact> contacts, 
			Predicate<Contact> condition,
			Function<Contact,String> function, 
			Consumer<String> consumer) {
		for(Contact c : contacts) {
			if(condition.test(c)) {
				String s = function.apply(c);
				consumer.accept(s);
			}
		}
	}

}
