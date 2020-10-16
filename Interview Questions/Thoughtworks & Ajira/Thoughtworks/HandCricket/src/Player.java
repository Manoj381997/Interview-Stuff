import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	private String name;
	private int totalScore;
	private List<Integer> scores;
	private static Random random;
	private boolean isTossWon;
	
	public Player(String name) {
		super();
		this.name = name;
		random = new Random();
		this.scores = new ArrayList<Integer>();
		this.totalScore = 0;
	}
	
	public int play() {
		return random.nextInt(6);
	}
	
	public void addScore(int score) {
		this.totalScore += score;
		this.scores.add(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public boolean isTossWon() {
		return isTossWon;
	}

	public void setTossWon(boolean isTossWon) {
		this.isTossWon = isTossWon;
	}
}
