public class Cricket {
	public static void main(String[] args) {
		System.out.println("Hand Cricket");
		System.out.println("Totally Two players (A & B) are there; Lets do a Toss to know who starts first\n");
	
		HandCricket handCricket = new HandCricket(new Player("A"), new Player("B"), 2);
		handCricket.startGame();
	}
}
