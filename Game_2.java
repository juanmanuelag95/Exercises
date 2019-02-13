import java.util.Scanner;
import java.util.Hashtable;
import java.util.Random;

class Cat {
	public boolean SearchMouse(Mouse m,int x, int y){
		return (m.board[x][y] == 1) ? true : false;
	}
}
class Mouse {
	int[][] board = {
			  { 0 ,0, 0, 0, 0 },
			  { 0 ,0, 0, 0, 0 },
			  { 0 ,0, 0, 0, 0 },
			  { 0 ,0, 0, 0, 0 },
			  { 0 ,0, 0, 0, 0 }
			};
	
	Mouse(int x, int y){
		this.board[x][y] = 1;
	}
}

public class Game_2 {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		String option = "0";
		int successes = 0; 
		int failures  = 0; 
		
	    do {
	    	System.out.print("Do you want to play Yes(1) or No(0): ");
	    	option = (reader.next());

		    switch(option) {
				case "1":
					System.out.println("Lets play");
					Random 		rand = new Random();
					Mouse 		mouse = new Mouse(rand.nextInt(5), rand.nextInt(5));
					Cat 		cat = new Cat();
					boolean 	correct = false;
					int 		times = 0;
					Hashtable 	hash = new Hashtable(); 
					
					do{
						String coord = "";
						System.out.print("Cat Coordinates to search(0-4 values): ");
						coord = (reader.next());

						if (hash.containsKey(coord)) {
							System.out.println("Coordinates already used");
						}else {
							hash.put(coord, true); 
							if(coord.matches("[01234],[01234]")) {
								String[] trimCoordinates = coord.split(",");
								correct = cat.SearchMouse(mouse, Integer.parseInt(trimCoordinates[0]), Integer.parseInt(trimCoordinates[1]));
								System.out.println("Mouse founded: " + correct); 
								if (correct) {
									successes++;
									break;
								}
								times++;
							}
							else {
								System.out.println("Invalid format, format expected: digit,digit");
							}
						}
					} while (!correct && times < 5);
					
					if (!correct && times == 5) {
						failures++;
					}
					
					System.out.println("Success: " + successes);
					System.out.println("Failures: " + failures);
					break;
				case "0":
					System.out.println("Good bye");
					System.out.println("Success: " + successes);
					System.out.println("Failures: " + failures);
					break;
				default:
					System.out.println("Use valid option");
		    }
		 
		} while (!option.contentEquals("0"));
	}
}