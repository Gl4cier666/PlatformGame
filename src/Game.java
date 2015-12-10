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
	public Sound sound;
	public static boolean gameOver, win;
	public static final int WIDTH = 640, HEIGHT = 480;
	public static int ticks, anTime;
	
	/**
	 * @author Bo Aanes
	 */
	
	public Game()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		player = new Player();
		sound = new Sound();
		
		jframe.setTitle("Game");
		jframe.setVisible(true);
		jframe.addKeyListener(this);
		jframe.add(renderer);
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
		
		Level.draw(g);
		Player.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ticks++;
		
		if(ticks % 25 == 0)
		{
			if(anTime == 0)
			{
				anTime++;
			}
			else if(anTime == 1)
			{
				anTime--;
			}
		}
		
		player.physics();
		Player.loadPlayer();
		Level.collide();
		
		if(Player.x + Player.width > Level.target.x && Player.y + Player.height > Level.target.y)
		{
			Level.advance();
		}
		
		if(gameOver)
		{
			Player.x = 0;
			Player.y = 0;
			Player.xSpeed = 0;
			Player.ySpeed = 0;
			
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
