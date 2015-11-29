import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements KeyListener, ActionListener {
	
	public static Player player;
	public Renderer renderer;
	public static Collision collision;
	public static boolean gameOver, win;
	public static final int WIDTH = 640, HEIGHT = 480;
	public int ticks, frzTime;
	
	/**
	 * Bo Aanes
	 */
	
	public Game()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		player = new Player();
		
		jframe.setTitle("Platform Game 0.1");
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
		g.fillRect(Level.one.x, Level.one.y, Level.one.width, Level.one.height);
		g.fillRect(Level.two.x, Level.two.y, Level.two.width, Level.two.height);
		g.fillRect(Level.three.x, Level.three.y, Level.three.width, Level.three.height);
		g.fillRect(Level.four.x, Level.four.y, Level.four.width, Level.four.height);
		g.fillRect(Level.five.x, Level.five.y, Level.five.width, Level.five.height);
		
		g.setColor(Color.green);
		g.fillRect(Level.target.x, Level.target.y, Level.target.width, Level.target.height);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ticks++;
		player.physics();
		
		Collision.collide();
		
		if(player.xSpeed == 0 && player.ySpeed == 0)
		{
			frzTime++;
			
			if(frzTime > 25)
			{
				gameOver = true;
				frzTime = 0;
			}
		}
		
		if(player.xSpeed != 0 || player.ySpeed != 0)
		{
			frzTime = 0;
		}
		
		if(player.x > WIDTH - 30 && player.y > HEIGHT - 55)
		{
			Level.advance();
		}
		
		if(gameOver)
		{
			player.x = 0;
			player.y = 0;
			player.xSpeed = 0;
			player.ySpeed = 0;
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
		player.movement(e);
		
		switch(e.getKeyCode())
		{
		case (KeyEvent.VK_ESCAPE):
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
