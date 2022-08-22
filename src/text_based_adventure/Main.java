package text_based_adventure;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//system objects
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//game variables
		
		String enemies[] = {"ains gowl", "voldemort", "kaguya", "freiza" };
		HashSet<String> enemyDown = new HashSet<>();
		int maxEnemyHealth = 100;
		int enemyAttackDamage = 50;
		
		//player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 50;
		int healthPotionDropChance = 50; //50%percentage
		
		boolean running = true;
		
		System.out.println("Welcome to the dungeon");
		
		GAME:while(running) {
				System.out.println("----------------------------------------------------------");
				
				
				String enemy = enemies[rand.nextInt(enemies.length)];
				if(enemyDown.contains(enemy))
					continue;
				
				enemyDown.add(enemy);
				int enemyHealth = rand.nextInt(maxEnemyHealth);
				System.out.println("\t# " + enemy + " has appeared! #\n");
				
				while(enemyHealth > 0) {
					System.out.println("\tYour HP:" + health);
					System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
					System.out.println("\n\tWhat would you like to do?");
					System.out.println("\t 1. Attack");
					System.out.println("\t 2. Drink health potion");
					System.out.println("\t 3. Run!");
					
					String input = sc.nextLine();
					if(input.equals("1")) {
						int damageDealt = rand.nextInt(attackDamage);
						int damageTaken = rand.nextInt(enemyAttackDamage);
						
						enemyHealth -= damageDealt;
						health -= damageTaken;
						
						System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage ");
						System.out.println("\t> you recieve " + damageTaken + " in retaliation ");
						
						if(health<1) {
							System.out.println("\n\t you have taken too much damage, you are too weak to go on");
							break;
						}
					}
					else if(input.equals("2")) {
						if(numHealthPotions>0) {
							health += healthPotionHealAmount;
							numHealthPotions--;
							System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
									+ "\n\t You now have " + health + " HP "
									+ "\n\t you have " + numHealthPotions + " health potions left. \n");
						}
						else {
							System.out.println("\t> You have no health potions left! defeat enemies for a chance to get health potion!");
						}
					}
					else if(input.equals("3")) {
						System.out.println("\t You run away from the " + enemy + "!");
						continue GAME;
					}
					else {
						System.out.println("\t Invalid command!");
					}
				}
				
				if(health < 1) {
					System.out.println("\n You limp out of the dungeon, weak from battle.");
					break;
				}
				System.out.println("----------------------------------------------------------");
				System.out.println(" # " + enemy + " was defeated! #");
				
				if(enemyDown.size()== enemies.length) {
					System.out.println("\n\t You have successfully defeated all enemies in the dungeon. Congrats on your successful adevnture");
					break GAME;
				}
				
				System.out.println(" # You have " + health + " HP left. #");
				if(rand.nextInt(100) < healthPotionDropChance) {
					numHealthPotions++;
					System.out.println(" # The " + enemy + " dropped a health potion! #");
					System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
				}
				System.out.println("----------------------------------------------------------");
				
				
				System.out.println("What would you like to do now??");
				System.out.println("1. Continue fighting");
				System.out.println("2. Exit dungeon");
				
				String input = sc.nextLine();
				
				while(!input.equals("1") && !input.equals("2")) {
					System.out.println("Invalid command!");
					input = sc.nextLine();
				}
				
				if(input.equals("1")) {
					System.out.println("You continue on your adventure!");
				}
				else if(input.equals("2")) {
					System.out.println("You exit the dungeon, successful from your adventures!");
				}
				
				
			}
		
		System.out.println("*********************************************************");
		System.out.println("Thanks for playing");
		System.out.println("*********************************************************");

	}

}
