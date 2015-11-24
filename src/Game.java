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
	
	public static Rectangle object, sqOne, sqTwo, sqThree, sqFour;
	
	public boolean gameOver, started;
	
	public static final int WIDTH = 640, HEIGHT = 480;
	
	/**
	 * Author: Bo Aanes~ hehehehe
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
		
		object = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		sqOne = new Rectangle(0, 0, WIDTH / 2 - 10, HEIGHT / 2 - 10);
		sqTwo = new Rectangle(0, HEIGHT / 2 + 10, WIDTH / 2 - 10, HEIGHT / 2 - 10);
		sqThree = new Rectangle(WIDTH / 2 + 10, 0, WIDTH / 2 - 10, HEIGHT / 2 - 10);
		sqFour = new Rectangle(WIDTH / 2 + 10, HEIGHT / 2 + 10, WIDTH / 2 - 10, HEIGHT / 2 - 10);
		
		timer.start();
	}
	
	public static void repaint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(object.x, object.y, object.width, object.height);
		
		g.setColor(Color.blue);
		g.fillRect(sqOne.x, sqOne.y, sqOne.width, sqOne.height);
		g.fillRect(sqTwo.x, sqTwo.y, sqTwo.width, sqTwo.height);
		g.fillRect(sqThree.x, sqThree.y, sqThree.width, sqThree.height);
		g.fillRect(sqFour.x, sqFour.y, sqFour.width, sqFour.height);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(object.intersects(sqOne) || object.intersects(sqTwo) || object.intersects(sqThree) || object.intersects(sqFour))
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
		
		if(gameOver)
		{
			object.x = WIDTH / 2 - 10;
			object.y = HEIGHT / 2 - 10;
			
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
