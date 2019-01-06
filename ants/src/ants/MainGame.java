package ants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGame extends JFrame implements ActionListener
{
	private GamePanel gamePanel = new GamePanel();
	private JButton startButton = new JButton("Start");
	private JButton quitButton = new JButton("Quit");
	private JButton pauseButton = new JButton("Pause");
	private Looper looper = new Looper(gamePanel);

	public MainGame()
	{
		super("Fixed Timestep Game Loop Test");
		gamePanel.setLooper(looper);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 2));
		p.add(startButton);
		p.add(pauseButton);
		p.add(quitButton);
		cp.add(gamePanel, BorderLayout.CENTER);
		cp.add(p, BorderLayout.SOUTH);
		setSize(500, 500);

		startButton.addActionListener(this);
		quitButton.addActionListener(this);
		pauseButton.addActionListener(this);
	}

	public static void main(String[] args)
	{
		MainGame glt = new MainGame();
		glt.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object s = e.getSource();
		if (s == startButton) {
			looper.running = !looper.running;
			if (looper.running) {
				startButton.setText("Stop");
				looper.runGameLoop();
			} else {
				startButton.setText("Start");
			}
		} else if (s == pauseButton) {
			looper.paused = !looper.paused;
			if (looper.paused) {
				pauseButton.setText("Unpause");
			} else {
				pauseButton.setText("Pause");
			}
		} else if (s == quitButton) {
			System.exit(0);
		}
	}
}