package Basic_world;

import java.util.Scanner;

public class Basic_world {
	static Scanner sc = new Scanner(System.in);
	public static boolean run(GUI gui, World world, Character character) {
		while(true) { 
			gui.delete();
			world.generate(gui);
			character.generate(gui);
			gui.generate();
			
			if(character.isHome() == true) {
				return true;
			}
			
			Direction direction = gui.loadAction();
			boolean steps = character.walk(direction);
			if(steps == false) {
				return steps;
			}
		}
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI(10, 5, sc);
		World world = new World(10, 5, new char[] { 
				 '#','#','#','#','#','#','#','#','#','#',
				 '#',' ','#',' ',' ',' ',' ',' ',' ','#',
				 '#',' ','#',' ',' ',' ','#','#',' ','#',
				 '#',' ',' ',' ','#',' ','#',' ',' ','#',
				 '#','#','#','#','#','#','#','#','#','#',
		});
		Character character = new Character(world, 7, 3, 1, 1);
		boolean goal = run(gui, world, character);
		if (goal == true) {
			System.out.println("Home at last...");
		}
		else {
			System.out.println("I must have got lost...");
		}
	}
}