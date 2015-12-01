
public class Collision extends Game {
	
	public static void collide()
	{	
		switch(Level.levelNum)
		{
		case 0:
			if(Player.x > 20 && Player.x < 120 && Player.y < HEIGHT / 2)
			{
				gameOver = true;
			}
			else if(Player.x >= 0 && Player.x < WIDTH - 30 && Player.y > HEIGHT / 2 + 10)
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH / 2 - 80 && Player.x < WIDTH / 2 + 60 && Player.y < 50 + 120 && Player.y > 30)
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH - 140 && Player.y < 80)
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH - 140 && Player.x < WIDTH - 120 + 90 && Player.y > 100)
			{
				gameOver = true;
			}
			break;
		
		case 1:
			if(Player.x >= 0 && Player.x < WIDTH / 2 - 50 && Player.y > 5 && Player.y < 145)
			{
				gameOver = true;
			}
			else if(Player.x > 30 && Player.x < WIDTH / 2 + 120 && Player.y > HEIGHT / 2 - 70 && Player.y < (HEIGHT / 2 - 50) + (HEIGHT / 2 - 20))
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH / 2 - 20 && Player.x < WIDTH / 2 + 100 && Player.y >= 0 && Player.y < HEIGHT / 2 - 50)
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH / 2 + 100 && Player.y >= 0 && Player.y < 80)
			{
				gameOver = true;
			}
			else if(Player.x > WIDTH / 2 + 150 && Player.x < WIDTH / 2 + 290 && Player.y > HEIGHT / 2 - 70)
			{
				gameOver = true;
			}
		}
	}

}
