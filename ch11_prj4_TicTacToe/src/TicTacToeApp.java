
public class TicTacToeApp {

	public static void main(String[] args) {

		boolean gameOver = false;
		String p1 = " X ";
		String p2 = " O ";
		System.out.println("Welcome to Tic Tac Toe");
		String[][] space = new String[3][3];
		space[0][0]="   ";
		space[0][1]="   ";
		space[0][2]="   ";
		space[1][0]="   ";
		space[2][0]="   ";
		space[1][1]="   ";
		space[1][2]="   ";
		space[2][1]="   ";
		space[2][2]="   ";
		int[][] selections = new int[3][3];
		selections[0][0]=1;
		
		while(!gameOver) {
			gridPrint(space);
			int row = Console.getInt("X's turn\r\n" + 
					"Pick a row (1, 2, 3): ");
			int column = Console.getInt("Pick a row (1, 2, 3): ");
			concat(row,column);
			
			
			
		}
		
	}
	
	public static void gridPrint(String[][] space) {
		System.out.println("+---+---+---+");
		System.out.println("|"+space[0][0]+"|"+space[0][1]+"|"+space[0][2]+"|");
		System.out.println("+---+---+---+");
		System.out.println("|"+space[1][0]+"|"+space[1][1]+"|"+space[1][2]+"|");
		System.out.println("+---+---+---+");
		System.out.println("|"+space[2][0]+"|"+space[2][1]+"|"+space[2][2]+"|");
		System.out.println("+---+---+---+");
		
	}
	static int concat(int a, int b) 
	{
	    String s1 = Integer.toString(a); 
	    String s2 = Integer.toString(b);  
	    s1+=s2;
	    int c = Integer.parseInt(s1);
	    return c; 
	}

}
