import java.awt.Rectangle;
import java.awt.event.KeyEvent;

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
	
	public void movement(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			xSpeed = Math.max(-5, xSpeed - 1);
			break;
			
		case KeyEvent.VK_RIGHT:
			xSpeed = Math.min(5, xSpeed + 1);
			break;
			
		case KeyEvent.VK_UP:
			ySpeed = Math.max(-5, ySpeed - 1);
			break;
			
		case KeyEvent.VK_DOWN:
			ySpeed = Math.min(5, ySpeed + 1);
			break;
		}
	}
	
}
