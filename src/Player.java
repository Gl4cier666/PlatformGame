import java.awt.Rectangle;

public class Player {
	
	public int x, y, width, height;
	public double xSpeed, ySpeed;
	public Rectangle playerObject;
	
	public Player()
	{
		x = 0;
		y = 0;
		width = 20;
		height = 20;
		
		playerObject = new Rectangle(x, y, width, height);
	}
	
	public void physics()
	{
		x += xSpeed;
		y += ySpeed;
		
		if(y >= Game.HEIGHT - 52)
		{
			y = Game.HEIGHT - 52;
			ySpeed = 0;
		}
		else if(y < 0)
		{
			y = 0;
			ySpeed = 0;
		}
		else if(x >= Game.WIDTH - 25)
		{
			x = Game.WIDTH - 25;
			xSpeed = 0;
		}
		else if(x < 0)
		{
			x = 0;
			xSpeed = 0;
		}
	}
	
}
