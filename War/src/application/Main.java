package application;
	

public class Main {
	
	/* Method Name: Main
	 * Return type: void
	 * Parameters: None
	 * Description: Launches the application
	 */
	public static void main(String[] args) {
		System.out.println("Playing War!\n");
		War newGame = new War(2);
		newGame.dealCards();
	}
}
