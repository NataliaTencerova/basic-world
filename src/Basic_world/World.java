package Basic_world;

public class World { 
	private int width;
	private int height;
	private char[][] map;
	
	public World(int width, int height, char[]data) {
		this.width = width;
		this.height = height;
		map = new char[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map[x][y]= data[y*width+x];
			}
		}
	}
	
	public char area(int x, int y) { 
		if(x < 0) {
			return 0;
		}
		if(x >= width) {
			return 0;
		}
		if(y < 0) {
			return 0;
		}
		if (y >= height){
			return 0;
		}
		return map[x][y];
	}
	
	public void generate(GUI gui) { 
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				gui.write(x, y, area(x, y));
			}	
		}
	}
}