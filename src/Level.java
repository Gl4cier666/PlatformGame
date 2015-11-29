import java.awt.Rectangle;

public class Level extends Game {
	
	public static Rectangle one, two, three, four, five, target;
	public static int levelNum = 0;
	
	public static void addRects()
	{
		if(levelNum == 0)
		{
			one = new Rectangle(40, 0, 80, HEIGHT / 2);
			two = new Rectangle(0, HEIGHT / 2 + 30, WIDTH - 30, HEIGHT / 2 - 30);
			three = new Rectangle(WIDTH / 2 - 60, 50, 120, 120);
			four = new Rectangle(WIDTH - 120, 0, 120, 80);
			five = new Rectangle(WIDTH - 120, 120, 90, 210);
			target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
		}
		
		if(levelNum == 1)
		{
			one = new Rectangle(0, 25, WIDTH / 2 - 50, 120);
			two = new Rectangle(50, HEIGHT / 2 - 50, WIDTH / 2 + 70, HEIGHT / 2 - 20);
			three = new Rectangle(WIDTH / 2, 0, 120, HEIGHT / 2 - 50);
			four = new Rectangle(WIDTH / 2 + 120, 0, 200, 80);
			five = new Rectangle(WIDTH / 2 + 170, HEIGHT / 2 - 50, 120, HEIGHT / 2 + 40);
			target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
		}
	}
	
	public static void advance()
	{
		if(levelNum == 0)
		{
			levelNum++;			
		}
		else if(levelNum == 1)
		{
			levelNum--;
		}
		
		addRects();
		
		player.x = 0;
		player.y = 0;
		player.xSpeed = 0;
		player.ySpeed = 0;
	}
	
}
