import java.awt.Rectangle;

public class Level extends Game {
	
	public static Rectangle upLeft, down, mid, upRight, pole, target;
	
	public static void addRects()
	{
		upLeft = new Rectangle(40, 0, 80, HEIGHT / 2);
		down = new Rectangle(0, HEIGHT / 2 + 30, WIDTH - 30, HEIGHT / 2 - 30);
		mid = new Rectangle(WIDTH / 2 - 60, 50, 120, 120);
		upRight = new Rectangle(WIDTH - 120, 0, 120, 80);
		pole = new Rectangle(WIDTH - 120, 120, 90, 210);
		target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
	}
	
	public static void advance()
	{
		
	}
	
}
