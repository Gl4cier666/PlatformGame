import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements KeyListener, ActionListener {
	
	public Renderer renderer;
	
	public static Rectangle object;
	
	public boolean gameOver, win;
	
	public static final int WIDTH = 640, HEIGHT = 480;
	
	/**
	 * Author: Bo Aanes~
	 */
	 
	public Game()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		
		jframe.addKeyListener(this);
		jframe.add(renderer);
		jframe.setVisible(true);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		
		object = new Rectangle(0, 0, 20, 20);
		Level.addRects();
		
		timer.start();
	}
	
	public static void repaint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(object.x, object.y, object.width, object.height);
		
		g.setColor(Color.blue);
		g.fillRect(Level.upLeft.x, Level.upLeft.y, Level.upLeft.width, Level.upLeft.height);
		g.fillRect(Level.down.x, Level.down.y, Level.down.width, Level.down.height);
		g.fillRect(Level.mid.x, Level.mid.y, Level.mid.width, Level.mid.height);
		g.fillRect(Level.upRight.x, Level.upRight.y, Level.upRight.width, Level.upRight.height);
		g.fillRect(Level.pole.x, Level.pole.y, Level.pole.width, Level.pole.height);
		
		g.setColor(Color.green);
		g.fillRect(Level.target.x, Level.target.y, Level.target.width, Level.target.height);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(object.intersects(Level.upLeft) || object.intersects(Level.down) || object.intersects(Level.mid) || object.intersects(Level.upRight) || object.intersects(Level.pole))
		{
			gameOver = true;
		}
		
		if(object.x < 0)
		{
			object.x = 0;
		}
		else if (object.x > WIDTH - 26)
		{
			object.x = WIDTH - 26;
		}
		else if(object.y < 0)
		{
			object.y = 0;
		}
		else if(object.y > HEIGHT - 50)
		{
			object.y = HEIGHT - 50;
		}
		
		if(object.intersects(Level.target))
		{
			win = true;
			
			if(win)
			{
				Level.advance();
			}
		}
		
		if(gameOver)
		{
			object.x = 0;
			object.y = 0;
			
			gameOver = false;
		}
		
		renderer.repaint();
	}
	
	public static void main(String[] args)
	{
		new Game();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			object.y = object.y - 5;
			break;
		
		case KeyEvent.VK_DOWN:
			object.y = object.y + 5;
			break;
			
		case KeyEvent.VK_LEFT:
			object.x = object.x - 5;
			break;
			
		case KeyEvent.VK_RIGHT:
			object.x = object.x + 5;
			break;
			
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
}
