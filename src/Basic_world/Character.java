package Basic_world;

public class Character { 
	private World world; 
	private int startX;
	private int startY; 
	private int homeX;
	private int homeY;
//	private int[][] start;
//	private int[][] home;
	
	public Character (World world, int startX, int startY, int homeX, int homeY) {
		this.world = world;
		this.startX = startX;
		this.startY = startY;
		this.homeX = homeX;
		this.homeY = homeY;
//		start = new int[startX][startY];
//		home = new int[homeX][homeY];
	}
	
	public boolean walk(Direction direction) { 
		Direction north = Direction.NORTH;
		Direction south = Direction.SOUTH;
		Direction east = Direction.EAST;
		Direction west = Direction.WEST;
		char up = world.area(startX, startY-1);
		char down = world.area(startX, startY+1);
		char right = world.area(startX+1, startY);
		char left = world.area(startX-1, startY);
		
		if(direction == north && up == ' ') {
			startY -= 1;
			return true;
		}
		if(direction == south && down == ' ') {
			startY += 1;
			return true;
		}
		if(direction == east && right == ' ') {
			startX += 1;
			return true;
		}
		if(direction == west && left == ' ') {
			startX -= 1;
			return true;
		}
		
		return false;
	}
	
	public boolean isHome() {
		if(startX == homeX && startY == homeY) {
			return true;
		}
	
		return false;	
	}
	
	public void generate(GUI gui) { 
		gui.write(startX, startY, '@');
		gui.write(homeX, homeY, '^');
	}
}