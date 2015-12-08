import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	public static AudioInputStream audioInput;
	public static Clip clip;
	
	public Sound()
	{
		playMusic();
	}
	
	public static void playMusic()
	{
		char[] chars = "1234".toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		
		for(int i = 0; i < 1; i++)
		{
			char c = chars[random.nextInt(chars.length)];
			stringBuilder.append(c);
		}
		String output = stringBuilder.toString();
		
		try
		{
			audioInput = AudioSystem.getAudioInputStream(new File("assets/song_" + output + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
		}
		catch(Exception e)
		{
			System.out.println("Error playing sound");
		}
	}
	
}
