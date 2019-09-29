
public class BMDBApp {

	public static void main(String[] args) {

		Actor actor1 = new Actor(1,"Leonardo","Dicaprio","Male","1974-11-11");
		Actor actor2 = new Actor(2,"Tom","Hardy","Male","1977-09-17");
		Actor actor3 = new Actor(3,"Ellen","Page","Female","1987-02-21");
		
		Movie movie1 = new Movie(1,"Inception","PG-13",2010,"Christopher Nolan");
		Movie movie2 = new Movie(2,"Wolf of Wall Street","R",2013,"Martin Scorsese");
		
		Credit cr1 = new Credit(1,1,1,"Cobb");
		Credit cr2 = new Credit(2,1,2,"Eames");
		Credit cr3 = new Credit(3,1,3,"Ariadne");
		Credit cr4 = new Credit(4,2,2,"Jordan Belfort");
		
		System.out.println(actor1);
		System.out.println(actor2);
		System.out.println(actor3);
		System.out.println();
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println();
		System.out.println(cr1);
		System.out.println(cr2);
		System.out.println(cr3);
		System.out.println(cr4);
		
	}

}
