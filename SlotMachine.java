import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class Figure{
	int type;
	String name;
	
	Figure(int t, String n){
		this.type = t;
		this.name = n;
	}
}

class Person {
	int coins;
	
	Person(){
		this.coins = 1;
	}
	public void getMoreCoins(int n) {
		this.coins += n;
	}
}

public class SlotMachine {
	public static void Roll(Person p, ArrayList<Figure>  figures) {		
		Random rand = new Random();		
		ArrayList<Figure> resultRoulette = new ArrayList<Figure>();
		resultRoulette.add(figures.get(rand.nextInt(5))); 
		resultRoulette.add(figures.get(rand.nextInt(5))); 
		resultRoulette.add(figures.get(rand.nextInt(5))); 
		
		System.out.println(">>> " + resultRoulette.get(0).name + " " + resultRoulette.get(1).name +  " " + resultRoulette.get(2).name + " <<<");
		int	totalPoints = 0;
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>(); 
		
		Iterator<Figure> it = resultRoulette.iterator();
		while(it.hasNext()) {
			Figure element = it.next();
			totalPoints = totalPoints + (int) element.type;
			if (hash.containsKey(element.name)) 
				hash.put(element.name, (int) hash.get(element.name) + 1);
			else 
				hash.put(element.name, 1);
		}

		if 	(totalPoints == 6 && hash.contains(3)) {// Any three of the same fruit pays 10 coins.
			p.coins += 10;
			System.out.println("YOU WON 10 COINS");
		}
		else if (totalPoints == 4) { // Two sevens pays 4 coins.
			p.coins += 4;
			System.out.println("YOU WON 4 COINS");
		}
		else if (totalPoints == 3) { // Three sevens pays 30 coins.
			p.coins += 30;
			System.out.println("YOU LOOSE");
		}
		else if (totalPoints != 5)
			p.coins--;
	}
	
	public static void main(String args[]) {
		ArrayList<Figure> figures = new ArrayList<Figure>();
		// 1 = score, 2 = fruit
		figures.add(new Figure(1,"seven")); 
		figures.add(new Figure(2,"banana")); 
		figures.add(new Figure(2,"orange")); 
		figures.add(new Figure(2,"cherry"));  
		figures.add(new Figure(2,"mellon")); 
		figures.add(new Figure(2,"grapes")); 
		
		Person person = new Person();
		String option = "0";
		Scanner reader = new Scanner(System.in);
		
		 do {
		    	System.out.println("Choose an option: ");
		    	System.out.println("1: Play");
		    	System.out.println("2: Get more coins");
		    	System.out.println("3: Charge");
		    	System.out.println("0: End Game");
		    	System.out.println("--------------------");
		    	System.out.println("Person Coins: " + person.coins); 
		    	option = (reader.next());
		    	
		    	switch(option) {
		    		case "0":
		    			System.out.println("Good Bye!");
		    			break;
					case "1":
						if (person.coins > 0) {
							System.out.println("Good Luck");
							Roll(person, figures);
						}
						else {
							System.out.println("Buy more coins!");
						}
						break;
					case "2":
						System.out.println("How many coins do you want?");
						
						try {
							int plusCoins = reader.nextInt();
							if (plusCoins > 0) {
								person.getMoreCoins(plusCoins);
							}
						} catch (Exception e) {
							System.out.println("Please inster only numbers");
						}
						
						break;
					case "3":
						System.out.println("You get " + person.coins + " Coins");
						person.coins = 0;
						break;
					default:
						System.out.println("Use a valid Option");
		    	}
		    	System.out.println("Person Coins: " + person.coins); 
		 } while (!option.contentEquals("0"));
	}	
}