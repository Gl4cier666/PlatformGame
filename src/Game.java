/**
 * Bo Aanes
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.text.AbstractDocument.LeafElement;

public class Game implements KeyListener, ActionListener {
	
	public static Player player;
	public Renderer renderer;
	public boolean gameOver, win;
	public static final int WIDTH = 640, HEIGHT = 480;
	
	public Game()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		player = new Player();
		
		jframe.addKeyListener(this);
		jframe.add(renderer);
		jframe.setVisible(true);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		
		Level.addRects();
		
		timer.start();
	}
	
	public static void repaint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(player.x, player.y, player.width, player.height);
		
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
		player.physics();
		
		//FIX THIS!!!!
		if(player.playerObject.intersects(Level.upLeft) || player.playerObject.intersects(Level.down) || player.playerObject.intersects(Level.mid) || player.playerObject.intersects(Level.upRight) || player.playerObject.intersects(Level.pole))
		{
			gameOver = true;
		}
		
		//AND THIS!!!
		if(gameOver)
		{
			player.x = 0;
			player.y = 0;
			System.out.println("gameover");
			gameOver = false;
		}
		
		renderer.repaint();
	}
	
	public static void main(String[] args) throws Exception
	{
		new Game();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			player.xSpeed = Math.max(-5, player.xSpeed - 1);
			break;
			
		case KeyEvent.VK_RIGHT:
			player.xSpeed = Math.min(5, player.xSpeed + 1);
			break;
			
		case KeyEvent.VK_UP:
			player.ySpeed = Math.max(-5, player.ySpeed - 1);
			break;
			
		case KeyEvent.VK_DOWN:
			player.ySpeed = Math.min(5, player.ySpeed + 1);
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
