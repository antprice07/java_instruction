
public class TicTacToeApp {
	static String[][] gameBoard = new String[3][3];

	public static void main(String[] args) {

		boolean isGameOver = false;
		String p1 = " X ";
		String p2 = " O ";
		System.out.println("Welcome to Tic Tac Toe");
		String reset = "y";
		while (reset.equalsIgnoreCase("y")) {
			resetGameBoard();

			do {
				gridPrint(gameBoard);
				playerSelection(p1, p2);
				isGameOver = isGameOverCheck(gameBoard, p1);
				if (isGameOver)
					break;
				gridPrint(gameBoard);
				playerSelection(p2, p1);
				isGameOver = isGameOverCheck(gameBoard, p2);

			} while (!isGameOver);
			System.out.println("Game Over. :)");
			reset = Console.getLine("Play again? y/n: ");
			if(reset.equalsIgnoreCase("y")) {
				isGameOver=false;
			}
			System.out.println("Goodbye!");
		}
	}

	private static void resetGameBoard() {
		gameBoard[0][0] = "   ";
		gameBoard[0][1] = "   ";
		gameBoard[0][2] = "   ";
		gameBoard[1][0] = "   ";
		gameBoard[2][0] = "   ";
		gameBoard[1][1] = "   ";
		gameBoard[1][2] = "   ";
		gameBoard[2][1] = "   ";
		gameBoard[2][2] = "   ";
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

	static boolean isGameOverCheck(String[][] space, String player) {
		boolean gameOver = false;
		if (space[0][0].equalsIgnoreCase(player) && space[0][1].equalsIgnoreCase(player)
				&& space[0][2].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[0][0].equalsIgnoreCase(player) && space[1][0].equalsIgnoreCase(player)
				&& space[2][0].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[0][1].equalsIgnoreCase(player) && space[1][1].equalsIgnoreCase(player)
				&& space[2][1].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[0][2].equalsIgnoreCase(player) && space[1][2].equalsIgnoreCase(player)
				&& space[2][2].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[1][0].equalsIgnoreCase(player) && space[1][1].equalsIgnoreCase(player)
				&& space[1][2].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[2][0].equalsIgnoreCase(player) && space[2][1].equalsIgnoreCase(player)
				&& space[2][2].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[0][0].equalsIgnoreCase(player) && space[1][1].equalsIgnoreCase(player)
				&& space[2][2].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		}
		if (space[0][2].equalsIgnoreCase(player) && space[1][1].equalsIgnoreCase(player)
				&& space[2][0].equalsIgnoreCase(player)) {
			gameOver = true;
			System.out.println(player + "wins!");
			return gameOver;
		} else
			return gameOver;

	}

	static void playerSelection(String player, String otherPlayer) {
		boolean isValid = false;
		while (!isValid) {
			int row = (Console.getInt(player + "'s turn\r\n" + "Pick a row (1, 2, 3): ", 0, 4)) - 1;
			int column = (Console.getInt("Pick a column (1, 2, 3): ", 0, 4)) - 1;
			if (gameBoard[row][column].equalsIgnoreCase(player)
					|| gameBoard[row][column].equalsIgnoreCase(otherPlayer)) {
				System.out.println("Space is occupied, please make another selection.");
			} else {
				gameBoard[row][column] = player;
				isValid = true;
			}
		}
	}

}
