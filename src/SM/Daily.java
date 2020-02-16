package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Daily extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH    = 750;
	private static final int FRAME_HEIGHT   = 475;

	private JPanel contentPane;

	// Image Declaration
	private JLabel bg;

	//Button Declaration
	//private JButton ConfirmBtn;
	//private JButton BackBtn;


	// Text Area
	private JTextArea textArea;

	static String[] month = new String[10000];
	static String[] profit = new String[10000];

	String text_data = "";

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Daily frame = new Daily();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Daily()
	{

		setTitle("Daily");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container contentPane = getContentPane();   
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);


		//Buttons
		/*
		ConfirmBtn = new JButton ("");
		ConfirmBtn.setBounds(29,114,159,74);
		ConfirmBtn.addActionListener(this);
		ConfirmBtn.setOpaque(false);
		ConfirmBtn.setContentAreaFilled(false);
		ConfirmBtn.setBorderPainted(false);
		contentPane.add(ConfirmBtn);

		BackBtn = new JButton ("");
		BackBtn.setBounds(29, 210, 159, 74);
		BackBtn.addActionListener(this);
		BackBtn.setOpaque(false);
		BackBtn.setContentAreaFilled(false);
		BackBtn.setBorderPainted(false);
		contentPane.add(BackBtn);
		*/

		// Text Area
		textArea = new JTextArea();  
		textArea.setLocation(0, 0);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		String stringText = "";
		textArea.setText(stringText);
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		textArea.setWrapStyleWord(true);


		contentPane.add(textArea);

		JScrollPane scrollText = new JScrollPane(textArea);        
		scrollText.setBounds(200, 130, 540, 200);
		scrollText.setBorder(BorderFactory.createLineBorder(Color.black));        
		contentPane.add(scrollText);

		//Background Image

		bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/DailyBg.jpeg")));
		bg.setBounds(0,0,750,453);
		contentPane.add(bg);

	}

	public void actionPerformed(ActionEvent event) 
	{
		
	}


}
