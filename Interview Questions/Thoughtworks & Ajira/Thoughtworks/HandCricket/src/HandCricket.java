
import com.game.enumeration.Toss;
import com.game.service.CoinToss;

public class HandCricket {
	private Player playerOne;
	private Player playerTwo;
	private int rounds;
	private Player battingPlayer;
	private Player bowlingPlayer;
	private int[] score;
	
	public HandCricket(Player playerOne, Player playerTwo, int rounds) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.rounds = rounds;
		this.score = new int[rounds];
	}
	
	public void startGame() {
		toss();
		playRounds();
		declareWinner();
	}

	private void playRounds() {
		for (int round = 1; round <= rounds; round++) {
			System.out.println("Round "+ round +"\n");
			
			for (int ballThrow = 0; ballThrow < 6; ballThrow++) {
				int batterScore = battingPlayer.play();
				int bowlerScore = bowlingPlayer.play();
				
				System.out.print(battingPlayer.getName()+" throws "+ batterScore+" ");
				System.out.print(bowlingPlayer.getName()+" throws "+ bowlerScore+" ");
				
				if (batterScore == bowlerScore) {
					System.out.print(battingPlayer.getName()+" is out");
					break;
				}
				else {
					battingPlayer.addScore(batterScore);
					bowlingPlayer.addScore(bowlerScore);
					System.out.print(battingPlayer.getName()+" score is "+ battingPlayer.getTotalScore()+" ");
				}
				System.out.println();
			}
			score[round-1] = battingPlayer.getTotalScore();
			System.out.println("\nRound "+ round+" ends\n");
			
			// Switching players
			setPlayers(bowlingPlayer, battingPlayer);
		}
		
	}
	
	private void declareWinner() {
		if (battingPlayer.isTossWon()) {
			if (score[0] > score[1]) System.out.println(battingPlayer.getName() + " wins");
			else System.out.println(bowlingPlayer.getName() + " wins");
		} else if (bowlingPlayer.isTossWon()) {
			if (score[1] > score[0]) System.out.println(bowlingPlayer.getName() + " wins");
			else System.out.println(battingPlayer.getName() + " wins");
		}
		else {
			System.out.println("Its a Tie");
		}
	}

	private void toss() {
		if (CoinToss.getProbability() == Toss.HEAD) {
			System.out.println("Player "+ playerOne.getName() +" starts batting");
			this.playerOne.setTossWon(true);
			setPlayers(playerOne, playerTwo);
		}
		else {
			System.out.println("Player "+ playerTwo.getName() +" starts batting");
			this.playerTwo.setTossWon(true);
			setPlayers(playerTwo, playerOne);
		}
	}

	private void setPlayers(Player playerOne, Player playerTwo) {
		this.battingPlayer = playerOne;
		this.bowlingPlayer = playerTwo;
		this.battingPlayer.setTotalScore(0);
		this.bowlingPlayer.setTotalScore(0);
	}
}
