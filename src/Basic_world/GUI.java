package Basic_world;

import java.util.Scanner;

public class GUI { 
	private Scanner sc;
	private char[][] map;
	private int  width;
	private int height;
	
	public GUI(int width, int height, Scanner sc) {
		this.width = width;
		this.height = height;
		this.sc = sc;
		map = new char[width][height];
	}
	
	public void delete() { 
		map(' ', width, height);
	}
	
	public void map(char symbol, int width, int height) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++){
				write(x, y, ' ');
			}
		}
	}
	
	public void write(int x, int y, char symbol) {
		map[x][y] = symbol;
	}
	
	public void generate() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(map[x][y]);
			}
			System.out.println();
		}
	}
	
	public Direction loadAction() {
		System.out.println("Where next? ");
		int n = sc.nextInt();
		switch (n) {
		case 8:
			return Direction.NORTH;
		case 2:
			return Direction.SOUTH;
		case 6:
			return Direction.EAST;
		case 4:
			return Direction.WEST;
		}
		
		return null;
	}
}
