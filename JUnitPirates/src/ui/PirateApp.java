package ui;

import java.util.ArrayList;
import java.util.List;

import business.Pirate;

public class PirateApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Pirate App.");
		List<Pirate> pirates = new ArrayList<>();
		
		pirates.add(new Pirate("Jack Sparrow"));
		pirates.add(new Pirate("PegLeg Pete",3));
		pirates.add(new Pirate("Barnacle Bob"));
		pirates.add(new Pirate("Edward Teach"));
		
		printPirateSummary(pirates);
		
		System.out.println("Watch out... pirate fight!!!");
		
		Pirate p1 = pirates.get(1);
		Pirate p2 = pirates.get(2);
		
		p1.loseALimb();
		p2.loseALimb();
		p1.loseALimb();
		p2.loseALimb();
		p1.loseALimb();
		p1.loseALimb();
		
		printPirateSummary(pirates);
		
		
		
		
		System.out.println("Goodbye!");

	}
	
	private static void printPirateSummary(List<Pirate>pirates) {
		System.out.println("Pirates Summary.");
		System.out.println("================");
		pirates.stream().forEach(System.out::println);
		System.out.println("Total pirates: "+Pirate.getNumPirates());
		System.out.println("Total limbs lost: "+Pirate.getTotalLimbsLost());
		
	}

}
