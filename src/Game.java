import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements KeyListener, ActionListener {
	
	public static Player player;
	public Renderer renderer;
	public Sound sound;
	public static boolean gameOver, win;
	public static final int WIDTH = 640, HEIGHT = 480;
	public static int ticks, anTime;
	static BufferedImage bg;
	
	/**
	 * @author Bo Aanes
	 */
	
	public Game()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		player = new Player();
		
		jframe.setTitle("Game");
		jframe.setVisible(true);
		jframe.addKeyListener(this);
		jframe.add(renderer);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		
		Level.addRects();
		Sound.playMusic();
		
		timer.start();
	}
	
	public static void repaint(Graphics g)
	{
		try {
			bg = ImageIO.read(new File("assets/images/pictures/bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics2D graphics2D = (Graphics2D) g;
		BufferedImage image = bg;
		Rectangle r = new Rectangle(0, 0, WIDTH, HEIGHT);
		graphics2D.setPaint(new TexturePaint(image, r));
		
		Rectangle fillBg = new Rectangle(0, 0, WIDTH, HEIGHT);
		graphics2D.fill(fillBg);
		
		graphics2D.fill(fillBg);
		
		Level.draw(g);
		Player.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ticks++;
		
		Player.physics();
		Player.loadPlayer();
		Level.loadObjects();
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
		case (KeyEvent.VK_Q):
			Level.advance();
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
