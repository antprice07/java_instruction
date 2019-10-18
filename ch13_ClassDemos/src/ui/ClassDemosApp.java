package ui;

public class ClassDemosApp {

	public static void main(String[] args) {
		
		String message = "Hello world!";
		System.out.println(message);
		
		int index = message.indexOf("!");
		System.out.println(index);
		
		StringBuilder sbMessage = new StringBuilder(message);
		System.out.println(sbMessage);
		
		System.out.println(sbMessage.capacity());
		System.out.println(sbMessage.length());
		

	}

}
