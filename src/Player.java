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
	public boolean up, down, left, right;
	static BufferedImage img;
	
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
	
	public void loadImage()
	{
		if(down)
		{
			try {
				img = ImageIO.read(new File("assets/object_rocket_down.png"));
			} catch (IOException e){}
		}
		
		if(up)
		{
			try {
				img = ImageIO.read(new File("assets/object_rocket_up.png"));
			} catch (IOException e){}
		}
		
		if(right)
		{
			try {
				img = ImageIO.read(new File("assets/object_rocket_right.png"));
			} catch (IOException e){}
		}
		
		if(left)
		{
			try {
				img = ImageIO.read(new File("assets/object_rocket_left.png"));
			} catch (IOException e){}
		}
	}
	
	public static void draw(Graphics g)
	{
		g.drawImage(img, x, y, null);
	}
	
	public Dimension getPrefferedSize()
	{
		if(img == null){
			return new Dimension(width, height);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}
	
	public void movement(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			xSpeed = Math.max(-10, xSpeed - 1);
			up = false;
			down = false;
			left = true;
			right = false;
			break;
			
		case KeyEvent.VK_RIGHT:
			xSpeed = Math.min(10, xSpeed + 1);
			up = false;
			down = false;
			left = false;
			right = true;
			break;
			
		case KeyEvent.VK_UP:
			ySpeed = Math.max(-10, ySpeed - 1);
			up = true;
			down = false;
			left = false;
			right = false;
			break;
			
		case KeyEvent.VK_DOWN:
			ySpeed = Math.min(10, ySpeed + 1);
			up = false;
			down = true;
			left = false;
			right = false;
			break;
		}
	}
	
}
