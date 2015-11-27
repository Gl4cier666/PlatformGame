import java.awt.Rectangle;

public class Level extends Game {
	
	public static Rectangle one, two, three, four, five, target;
	
	public static void firstLevel()
	{
		one = new Rectangle(40, 0, 80, HEIGHT / 2);
		two = new Rectangle(0, HEIGHT / 2 + 30, WIDTH - 30, HEIGHT / 2 - 30);
		three = new Rectangle(WIDTH / 2 - 60, 50, 120, 120);
		four = new Rectangle(WIDTH - 120, 0, 120, 80);
		five = new Rectangle(WIDTH - 120, 120, 90, 210);
		target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
	}
	
	public static void advance()
	{
		
	}
	
}
