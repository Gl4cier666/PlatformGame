import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Component {
	
	private static final long serialVersionUID = 1L;
	public static int x, y, width, height;
	public static double xSpeed, ySpeed;
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	static BufferedImage player, flame;
	
	public Player()
	{
		x = 0;
		y = 0;
		width = 16;
		height = 16;
		up = true;
	}
	
	public void physics()
	{
		x += xSpeed;
		y += ySpeed;
		
		if(y >= Game.HEIGHT - 52)
		{
			y = Game.HEIGHT - 52;
			ySpeed = 0;
			Game.gameOver = true;
		}
		else if(y < 0)
		{
			y = 0;
			ySpeed = 0;
			Game.gameOver = true;
		}
		else if(x >= Game.WIDTH - 20)
		{
			x = Game.WIDTH - 25;
			xSpeed = 0;
			Game.gameOver = true;
		}
		else if(x < 0)
		{
			x = 0;
			xSpeed = 0;
			Game.gameOver = true;
		}
	}
	
	public void loadImage()
	{
		if(down)
		{
			try {
				player = ImageIO.read(new File("assets/object_rocket_down.png"));
				flame = ImageIO.read(new File("assets/afterburner_down.png"));
			} catch (IOException e){}
		}
		
		if(up)
		{
			try {
				player = ImageIO.read(new File("assets/object_rocket_up.png"));
				flame = ImageIO.read(new File("assets/afterburner_up.png"));
			} catch (IOException e){}
		}
		
		if(right)
		{
			try {
				player = ImageIO.read(new File("assets/object_rocket_right.png"));
				flame = ImageIO.read(new File("assets/afterburner_right.png"));
			} catch (IOException e){}
		}
		
		if(left)
		{
			try {
				player = ImageIO.read(new File("assets/object_rocket_left.png"));
				flame = ImageIO.read(new File("assets/afterburner_left.png"));
			} catch (IOException e){}
		}
	}
	
	public static void draw(Graphics g)
	{
		g.drawImage(player, x, y, null);
		
		if(ySpeed >= 3 || ySpeed <= -3 || xSpeed >= 3 || xSpeed <= -3)
		{
			if(down)
			{
				g.drawImage(flame, x, y - 14, null);
			}
			else if(up)
			{
				g.drawImage(flame, x, y + 14, null);
			}
			else if(right)
			{
				g.drawImage(flame, x - 14, y, null);
			}
			else if(left)
			{
				g.drawImage(flame, x + 14, y, null);
			}
		}
	}
	
	public Dimension getPrefferedSize()
	{
		if(player == null){
			return new Dimension(width, height);
		} else {
			return new Dimension(player.getWidth(null), player.getHeight(null));
		}
	}
	
	public void movement(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			xSpeed = Math.max(-5, xSpeed - 1);
			up = false;
			down = false;
			left = true;
			right = false;
			break;
			
		case KeyEvent.VK_RIGHT:
			xSpeed = Math.min(5, xSpeed + 1);
			up = false;
			down = false;
			left = false;
			right = true;
			break;
			
		case KeyEvent.VK_UP:
			ySpeed = Math.max(-5, ySpeed - 1);
			up = true;
			down = false;
			left = false;
			right = false;
			break;
			
		case KeyEvent.VK_DOWN:
			ySpeed = Math.min(5, ySpeed + 1);
			up = false;
			down = true;
			left = false;
			right = false;
			break;
		}
	}
	
}
