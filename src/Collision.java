
public class Collision extends Game {
	
	public static void collide()
	{	
		switch(Level.levelNum)
		{
		case 0:
			if(player.x > 20 && player.x < 120 && player.y < HEIGHT / 2)
			{
				gameOver = true;
			}
			else if(player.x >= 0 && player.x < WIDTH - 30 && player.y > HEIGHT / 2 + 10)
			{
				gameOver = true;
			}
			else if(player.x > WIDTH / 2 - 80 && player.x < WIDTH / 2 + 60 && player.y < 50 + 120 && player.y > 30)
			{
				gameOver = true;
			}
			else if(player.x > WIDTH - 140 && player.y < 80)
			{
				gameOver = true;
			}
			else if(player.x > WIDTH - 140 && player.x < WIDTH - 120 + 90 && player.y > 100)
			{
				gameOver = true;
			}
			break;
		
		case 1:
			if(player.x >= 0 && player.x < WIDTH / 2 - 50 && player.y > 5 && player.y < 145)
			{
				gameOver = true;
			}
			else if(player.x > 30 && player.x < WIDTH / 2 + 120 && player.y > HEIGHT / 2 - 70 && player.y < (HEIGHT / 2 - 50) + (HEIGHT / 2 - 20))
			{
				gameOver = true;
			}
			else if(player.x > WIDTH / 2 - 20 && player.x < WIDTH / 2 + 100 && player.y >= 0 && player.y < HEIGHT / 2 - 50)
			{
				gameOver = true;
			}
			else if(player.x > WIDTH / 2 + 100 && player.y >= 0 && player.y < 80)
			{
				gameOver = true;
			}
			else if(player.x > WIDTH / 2 + 150 && player.x < WIDTH / 2 + 290 && player.y > HEIGHT / 2 - 70)
			{
				gameOver = true;
			}
		}
	}

}
