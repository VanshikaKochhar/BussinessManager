package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class MainManager extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 580;

	// Button Declaration
	private JButton serviceButton;
	private JButton pandlButton;
	private JButton diaryButton;
	private JButton quitButton;
    private JButton helpButton;

	// Image Declaration
	private JLabel bg;

	// Switch Decleration
	private int opensw;

	public static void main(String[]args)
	{
		MainManager frame = new MainManager();
		frame.setVisible(true);
	}

	public MainManager( )
	{
		setTitle("Manager");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);

		// Content Pane Properties
		Container contentPane = getContentPane();   
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		// Button
        helpButton = new JButton("?");
        helpButton.setBounds(756,0,44,34);
        helpButton.addActionListener(this);
		helpButton.setFont(new Font("QuickSand", Font.PLAIN, 12));
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(true);
        contentPane.add(helpButton);
		
		serviceButton = new JButton("");
		serviceButton.setBounds(0, 64, 800, 75);
		serviceButton.addActionListener(this);
		serviceButton.setFont(new Font("QuickSand", Font.PLAIN, 12));
		serviceButton.setContentAreaFilled(false);
		serviceButton.setBorderPainted(false);
		contentPane.add(serviceButton);

		pandlButton = new JButton("");
		pandlButton.setBounds(0, 189, 800, 75);
		pandlButton.addActionListener(this);
		pandlButton.setFont(new Font("QuickSand", Font.PLAIN, 12));
		pandlButton.setContentAreaFilled(false);
		pandlButton.setBorderPainted(false);
		contentPane.add(pandlButton);

		diaryButton = new JButton("");
		diaryButton.setBounds(0, 315, 800, 75);
		diaryButton.addActionListener(this);
		diaryButton.setFont(new Font("QuickSand", Font.PLAIN, 12));
		diaryButton.setContentAreaFilled(false);
		diaryButton.setBorderPainted(false);
		contentPane.add(diaryButton);

		quitButton = new JButton("");
		quitButton.setBounds(0, 442, 800, 75);
		quitButton.addActionListener(this);
		quitButton.setFont(new Font("QuickSand", Font.PLAIN, 12));
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		contentPane.add(quitButton);

		// Background Image
		bg = new JLabel ("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/MainManBackground.jpeg")));
		bg.setBounds(0,0,800,560);
		contentPane.add(bg);


		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}

	public void actionPerformed(ActionEvent event) 
	{
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
		if (clickedButton == serviceButton)
		{
			Services frame = new Services();
			frame.setVisible(true);
			dispose();
		}
		if (clickedButton == pandlButton)
		{
			TProfit frame = new TProfit();
			frame.setVisible(true);
			dispose();
			opensw = 1;

			try
			{
				File outFile = new File("opensw.TXT");
				FileOutputStream outFileStream = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);

				outStream.println(opensw);
				outStream.close();
			}
			catch (IOException e)
			{
				System.out.println("Data communication error.");
			}
		}
		if (clickedButton == diaryButton)
		{
			Diary frame = new Diary();
			frame.setVisible(true);
			dispose();
		}
		if (clickedButton == quitButton)
		{
			int reply = JOptionPane.showConfirmDialog(
					null,
					"Are you sure you want to exit the program?",
					"Confirm Exit",
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		if (clickedButton == helpButton)
		{
			MainMenuHelp frame = new MainMenuHelp();
			frame.setVisible(true);
			dispose();
		}

	}



}
