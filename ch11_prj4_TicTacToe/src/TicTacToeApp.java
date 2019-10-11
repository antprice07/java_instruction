
public class TicTacToeApp {

	public static void main(String[] args) {

		boolean isGameOver = false;
		String p1 = " X ";
		String p2 = " O ";
		System.out.println("Welcome to Tic Tac Toe");
		String[][] space = new String[3][3];
		space[0][0] = "   ";
		space[0][1] = "   ";
		space[0][2] = "   ";
		space[1][0] = "   ";
		space[2][0] = "   ";
		space[1][1] = "   ";
		space[1][2] = "   ";
		space[2][1] = "   ";
		space[2][2] = "   ";

		do{
			gridPrint(space);
			int selection = choice(p1);
			fillSpace(selection,space,p1);
			isGameOver = isGameOverCheck(space,p1);
			if(isGameOver) break;
			gridPrint(space);
			selection = choice(p2);
			fillSpace(selection,space,p2);
			isGameOver = isGameOverCheck(space,p2);

		}while (!isGameOver);
		System.out.println("Game Over. :)");
	}

	public static void gridPrint(String[][] space) {
		System.out.println("+---+---+---+");
		System.out.println("|" + space[0][0] + "|" + space[0][1] + "|" + space[0][2] + "|");
		System.out.println("+---+---+---+");
		System.out.println("|" + space[1][0] + "|" + space[1][1] + "|" + space[1][2] + "|");
		System.out.println("+---+---+---+");
		System.out.println("|" + space[2][0] + "|" + space[2][1] + "|" + space[2][2] + "|");
		System.out.println("+---+---+---+");

	}

	static int concat(int a, int b) {
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		s1 += s2;
		int c = Integer.parseInt(s1);
		return c;
	}

	static int choice(String player) {
		int row = Console.getInt(player + "'s turn\r\n" + "Pick a row (1, 2, 3): ",0,4);
		int column = Console.getInt("Pick a column (1, 2, 3): ",0,4);
		int selection = concat(row, column);
		return selection;
	}

	static void fillSpace(int selection, String[][] choices, String player) {
		if (selection == 11) {
			choices[0][0] = player;
		}
		if(selection == 12) {
			choices[0][1] = player;
		}
		if(selection == 13) {
			choices[0][2] = player;
		}
		if(selection == 21) {
			choices[1][0] = player;
		}
		if(selection == 22) {
			choices[1][1] = player;
		}
		if(selection == 23) {
			choices[1][2] = player;
		}
		if(selection == 31) {
			choices[2][0] = player;
		}
		if(selection == 32) {
			choices[2][1] = player;
		}
		if(selection == 33) {
			choices[2][2] = player;
		}
	}
	static boolean isGameOverCheck(String[][]space,String player) {
		boolean gameOver = false;
		if(space[0][0].equalsIgnoreCase(player) && space[0][1].equalsIgnoreCase(player)&&space[0][2].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[0][0].equalsIgnoreCase(player)&& space[1][0].equalsIgnoreCase(player)&&space[2][0].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[0][1].equalsIgnoreCase(player)&& space[1][1].equalsIgnoreCase(player)&&space[2][1].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[0][2].equalsIgnoreCase(player)&& space[1][2].equalsIgnoreCase(player)&&space[2][2].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[1][0].equalsIgnoreCase(player)&& space[1][1].equalsIgnoreCase(player)&&space[1][2].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[2][0].equalsIgnoreCase(player)&& space[2][1].equalsIgnoreCase(player)&&space[2][2].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[0][0].equalsIgnoreCase(player)&& space[1][1].equalsIgnoreCase(player)&&space[2][2].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}
		if(space[0][2].equalsIgnoreCase(player)&& space[1][1].equalsIgnoreCase(player)&&space[2][0].equalsIgnoreCase(player)) {
			gameOver=true;
			return gameOver;
		}else
			return gameOver;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
