package application;
	

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Playing War!\n");
		int gameType = readIntegerArgument(args, 0);
		War warGame = getWarGame(gameType, args);
		warGame.runGame();
	}
	
	public static int readIntegerArgument(String[] intArg, int index) {
		int argument = -1;
		try {
			argument = Integer.parseInt(intArg[index]);
		} catch (Exception e) {
			System.err.println("Argument " + intArg[index] + "should be an integer!");
			System.exit(0);
		}
		return argument;
	}
	
	public static War getWarGame(int gameType, String[] args) {
		War warGame = null;
		int seed = -1;
		if (gameType == 1) {
			int rounds = readIntegerArgument(args, 1);
			seed = readIntegerArgument(args, 2);
			warGame = new WarClassic(rounds, seed);
		} else if (gameType == 2) {
			seed = readIntegerArgument(args, 1);
			warGame = new WarStoreDeck(2, seed);
		} else if (gameType == 3) {
			seed = readIntegerArgument(args, 1);
			warGame = new WarStoreDeck(3, seed);
		}
		return warGame;
	}
	
	
	
}
