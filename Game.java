import java.util.Random;

class GameEnviroment{
	int totalToss;
	int totalHeads;
	int totalTails;
	
	GameEnviroment(){
		//set to 10 games
		this.totalToss  = 10;
		this.totalHeads = 0;
		this.totalTails = 0;
	}
}

public class Game {
	public static void main(String args[]) {
		GameEnviroment game = new GameEnviroment();
		Random rand = new Random();
		
		for (int i = 0; i < game.totalToss; i++) {
			//0 to tails and 1 to Heads
			int result = (rand.nextInt(2) == 0) ? game.totalTails++ : game.totalHeads++;
		}
		
		System.out.println("Total Tails: " + game.totalTails);
		System.out.println("Total Heads: " + game.totalHeads);
	}
}