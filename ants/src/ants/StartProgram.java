package ants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class StartProgram extends JFrame
{
	BufferedImage bi;

	public static void main(String[] args)
	{
		try {
			new StartProgram();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StartProgram() throws IOException
	{
		super("Class Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		InputStream res = StartProgram.class.getResourceAsStream("/data/test.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(res));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Hello", 200, 50);
	}

}