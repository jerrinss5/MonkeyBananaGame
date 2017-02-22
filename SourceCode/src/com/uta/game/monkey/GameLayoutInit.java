package com.uta.game.monkey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GameLayoutInit extends JFrame {

	/** Global Variable Declaration */
	// Width and Height and Block Size
	static final int WIDTH = 700;
	static final int HEIGHT = 700;
	static final int ICONSIZE = 35;
	// Score and game panel height size
	private static final int SCOREHEIGHT = 35;
	private static final int GAMEHEIGHT = 675;
	// to check if game is paused or in running state
	private static Boolean running = false;
	// Score panel
	private JPanel scorePanel = new JPanel();
	// Game panel
	private JPanel gamePanel = new JPanel();
	// Timers
	private static int bananaTimerCountdown = 5;
	private static int overallCountdown = 30;
	// Button for play
	private static JButton play = new JButton("Play");
	// Text Area to display score, overall game timer and the banana shock
	// counter
	private static JTextArea scoreText = new JTextArea();
	private static JTextArea overallGameTimerText = new JTextArea();
	private static JTextArea bananaShockText = new JTextArea();
	private static JTextArea stateText = new JTextArea();
	private static int score = 0;

	public Subject subject;
	MonkeyKeyListener monkeyKeyListener;

	ImageIcon monkeyIcon = new ImageIcon(this.getClass().getClassLoader()
			.getResource("monkey.png"));
	ImageIcon bananaIcon = new ImageIcon(this.getClass().getClassLoader()
			.getResource("banana_small.png"));

	private JLabel monkeyLabel = new JLabel(monkeyIcon);
	private JLabel bananaLabel = new JLabel(bananaIcon);

	static Random ran = new Random();
	private static Timer timer;

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		GameLayoutInit.score = score;
	}

	public JLabel getMonkeyLabel() {
		return monkeyLabel;
	}

	public void setMonkeyLabel(JLabel monkeyLabel) {
		this.monkeyLabel = monkeyLabel;
	}

	public JLabel getBananaLabel() {
		return bananaLabel;
	}

	public void setBananaLabel(JLabel bananaLabel) {
		this.bananaLabel = bananaLabel;
	}

	public static JTextArea getScoreText() {
		return scoreText;
	}

	public static void setScoreText(JTextArea scoreText) {
		GameLayoutInit.scoreText = scoreText;
	}

	public static JTextArea getOverallGameTimerText() {
		return overallGameTimerText;
	}

	public static void setOverallGameTimerText(JTextArea overallGameTimerText) {
		GameLayoutInit.overallGameTimerText = overallGameTimerText;
	}

	public static JTextArea getBananaShockText() {
		return bananaShockText;
	}

	public static void setBananaShockText(JTextArea bananaShockText) {
		GameLayoutInit.bananaShockText = bananaShockText;
	}

	public static Boolean getRunning() {
		return running;
	}

	public static void setRunning(Boolean running) {
		GameLayoutInit.running = running;
	}

	public static int getBananaTimerCountdown() {
		return bananaTimerCountdown;
	}

	public static void setBananaTimerCountdown(int bananaTimerCountdown) {
		GameLayoutInit.bananaTimerCountdown = bananaTimerCountdown;
	}

	public static int getOverallCountdown() {
		return overallCountdown;
	}

	public static void setOverallCountdown(int overallCountdown) {
		GameLayoutInit.overallCountdown = overallCountdown;
	}

	public JPanel getScorePanel() {
		return scorePanel;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public static JButton getPlay() {
		return play;
	}

	public static void setPlay(JButton play) {
		GameLayoutInit.play = play;
	}

	public GameLayoutInit() {
		// starting the game
		running = true;
		// banana reset position timer
		bananaTimerCountdown = 6;
		// overall timer count down
		overallCountdown = 30;
		// to stay clear of taskbar below
		setDefaultLookAndFeelDecorated(true);
		// setting the screen size
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		// to center the frame
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (getWidth() / 2);
		int yPos = (dim.height / 2) - (getHeight() / 2);
		setLocation(xPos, yPos);
		// not allowing resizing of JFrame
		setResizable(false);

		// setting tool tip for play button
		if (getPlay() != null)
			getPlay().setToolTipText("Press to Play !!");

		if (getScoreText() != null) {
			getScoreText().setText(" Score: " + getScore());
			getScoreText().setToolTipText(
					"Your Score - Based on number of banans eaten");
		}
		if (getOverallGameTimerText() != null) {
			getOverallGameTimerText().setText(
					"Time left: " + getOverallCountdown());
			getOverallGameTimerText().setToolTipText("Time left in Game!");
		}
		if (getBananaShockText() != null) {
			getBananaShockText().setText(
					"New Banana in: " + getBananaTimerCountdown());
			getBananaShockText().setToolTipText(
					"Time left for a new Banana to appear!");
		}

		if (getMonkeyLabel() != null) {
			monkeyLabel.setSize(ICONSIZE, ICONSIZE);
			monkeyLabel.setLocation(randomizer(), randomizer());
		}
		if (getBananaLabel() != null) {
			bananaLabel.setSize(ICONSIZE, ICONSIZE);
			bananaLabel.setLocation(randomizer(), randomizer());
		}

		if (getScorePanel() != null) {
			getScorePanel().setBounds(0, 0, WIDTH, SCOREHEIGHT);
			getScorePanel().setBackground(Color.blue);
			if (getPlay() != null)
				getScorePanel().add(getPlay());
			if (getScoreText() != null)
				getScorePanel().add(getScoreText());
			if (getOverallGameTimerText() != null)
				getScorePanel().add(getOverallGameTimerText());
			if (getBananaShockText() != null)
				getScorePanel().add(getBananaShockText());
			if (getStateText() != null)
				getScorePanel().add(stateText);

			add(getScorePanel());
		}
		if (getGamePanel() != null) {
			getGamePanel().setBounds(0, SCOREHEIGHT, WIDTH, GAMEHEIGHT);
			getGamePanel().setBackground(Color.green);
			getGamePanel().setLayout(null);
			if (getMonkeyLabel() != null) {
				getGamePanel().add(monkeyLabel);
			}
			if (getBananaLabel() != null)
				getGamePanel().add(bananaLabel);
			add(getGamePanel());
		}

		// Initializing the monkey and banana.
		subject = new Subject(monkeyLabel, bananaLabel);
		monkeyKeyListener = new MonkeyKeyListener(subject);
		addKeyListener(monkeyKeyListener);
		setFocusable(true);

		play.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				restart();
				requestFocus();
			}
		});

		// terminate the program on exit
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// set visibility to true
		setVisible(true);

		timer();
	}

	public static JTextArea getStateText() {
		return stateText;
	}

	public static void setStateText(JTextArea stateText) {
		GameLayoutInit.stateText = stateText;
	}

	/**
	 * Function to randomize the numbers from 0 to 17 so as that icons appear
	 * inside the frame
	 */
	public static int randomizer() {
		return (ran.nextInt(17) * ICONSIZE);
	}

	public void restart() {
		timer.cancel();
		score = 0;
		running = true;
		bananaTimerCountdown = 5;
		overallCountdown = 30;
		removeKeyListener(monkeyKeyListener);
		getBananaLabel().setVisible(true);
		getBananaLabel().setLocation(randomizer(), randomizer());
		getMonkeyLabel().setLocation(randomizer(), randomizer());
		addKeyListener(new MonkeyKeyListener(subject));
		getMonkeyLabel().setRequestFocusEnabled(true);
		getBananaLabel().setRequestFocusEnabled(true);
		setFocusable(true);
		timer();
	}

	private void timer() {
		int delay = 1000;
		int period = 1000;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				bananaTimerCountdown = setInterval();
				bananaShockText.setText("New Banana in:  "
						+ bananaTimerCountdown);
				overallGameTimerText.setText("Time left:  " + overallCountdown);
			}
		}, delay, period);
	}

	private final int setInterval() {

		if (overallCountdown == 0 || score == 10) {
			if(score == 10)
				JOptionPane.showMessageDialog(null, "You Won!!!");
			if (overallCountdown == 0)
				JOptionPane.showMessageDialog(null, "You ran out of time!!!");
			removeKeyListener(monkeyKeyListener);
			setFocusable(false);
			timer.cancel();
			running = false;
			if (getBananaLabel() != null)
				getBananaLabel().setVisible(false);
		} else {
			overallCountdown--;
		}
		if (bananaTimerCountdown == 0) {
			bananaTimerCountdown = 5;
			if (getBananaLabel() != null)
				getBananaLabel().setLocation(randomizer(), randomizer());
		}

		return --bananaTimerCountdown;
	}
}
