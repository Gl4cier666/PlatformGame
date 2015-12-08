import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Level extends Game {
	
	public static Rectangle one, two, three, four, five, target;
	public static int levelNum = 0;
	public Game game;
	
	public static void clearRects()
	{
		one = new Rectangle();
		two = new Rectangle();
		three = new Rectangle();
		four = new Rectangle();
		five = new Rectangle();
	}
	
	public static void addRects()
	{
		if(levelNum == 0)
		{
			clearRects();
			
			one = new Rectangle(40, 0, 80, HEIGHT / 2);
			two = new Rectangle(0, HEIGHT / 2 + 30, WIDTH - 30, HEIGHT / 2 - 30);
			three = new Rectangle(WIDTH / 2 - 60, 50, 120, 120);
			four = new Rectangle(WIDTH - 120, 0, 120, 80);
			five = new Rectangle(WIDTH - 120, 120, 90, 210);
			target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
		}
		
		if(levelNum == 1)
		{
			clearRects();
			
			one = new Rectangle(0, 25, WIDTH / 2 - 50, 120);
			two = new Rectangle(50, HEIGHT / 2 - 50, WIDTH / 2 + 70, HEIGHT / 2 - 20);
			three = new Rectangle(WIDTH / 2, 0, 120, HEIGHT / 2 - 50);
			four = new Rectangle(WIDTH / 2 + 120, 0, 200, 80);
			five = new Rectangle(WIDTH / 2 + 170, HEIGHT / 2 - 50, 120, HEIGHT / 2 + 40);
			target = new Rectangle(WIDTH - 30, HEIGHT - 50, 25, 25);
		}
	}
	
	public static void collide()
	{
		if((Player.x > one.x - 16 && Player.x < one.x + one.width && Player.y > one.y - 16 && Player.y < one.y + one.height) ||
			(Player.x > two.x - 16 && Player.x < two.x + two.width && Player.y > two.y - 16 && Player.y < two.y + two.height) ||
			(Player.x > three.x - 16 && Player.x < three.x + three.width && Player.y > three.y - 16 && Player.y < three.y + three.height) ||
			(Player.x > four.x - 16 && Player.x < four.x + four.width && Player.y > four.y - 16 && Player.y < four.y + four.height) ||
			(Player.x > five.x - 16 && Player.x < five.x + five.width && Player.y > five.y - 16 && Player.y < five.y + five.height))
			{
				gameOver = true;
			}
	}
	
	public static void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(one.x, one.y, one.width, one.height);
		g.fillRect(two.x, two.y, two.width, two.height);
		g.fillRect(three.x, three.y, three.width, three.height);
		g.fillRect(four.x, four.y, four.width, four.height);
		g.fillRect(five.x, five.y, five.width, five.height);

		g.setColor(Color.green);
		g.fillRect(target.x, target.y, target.width, target.height);
	}
	
	public static void advance()
	{
		//Sound.playMusic();
		
		if(levelNum == 0)
		{
			levelNum++;			
		}
		else if(levelNum == 1)
		{
			levelNum--;
		}
		
		addRects();
		Player.x = 0;
		Player.y = 0;
		Player.xSpeed = 0;
		Player.ySpeed = 0;
	}
	
}
