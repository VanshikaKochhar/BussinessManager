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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import SM.EditService;
import SM.Services;

class EditLocate extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH    = 600;
	private static final int FRAME_HEIGHT   = 400;
	
	//Button Deceleration
	private JButton searchButton;
	private JButton cancelButton;
	
	//Text Deceleration
	private JLabel numText;
	private JLabel instructionsText;
	
	// Text Field Declaration
	private JTextField numField;
	
	// font Declaration
	private Font buttonfont = new Font("QucikSand", Font.PLAIN, 12);

	// Image Declaration
	private JLabel bg;
	
	// Variable Decleration

	static int max = 1000000;
	static int ctr = 0;
	static int edit = 0;
	static int asadd = 1;
	static int asedit = 1;
	static int asdel = 1;
	
	// Array Decleration

	static String[] service = new String[max];
	static String[] price = new String[max];
	static String[] number = new String[max];
	
	public static void main(String[]args)
	{
		EditLocate frame = new EditLocate();
		frame.setVisible(true);
		
	}
	
	public EditLocate()
	{
	      try
	      {
	          Scanner scanner = new Scanner(new File("dctr.TXT"));
	          while(scanner.hasNextInt()){
	              ctr = scanner.nextInt();
	              edit = scanner.nextInt();
	              asadd = scanner.nextInt();
	              asedit = scanner.nextInt();
	              asdel = scanner.nextInt();
	          }
	      }
	      catch(IOException e)
	      {
	          System.out.println("File communication error. Please contact the developer for assistance.");
	      }

	      try
	      {
	          File inFile = new File("store.TXT");
	          FileReader fileReader = new FileReader(inFile);
	          BufferedReader bufReader = new BufferedReader(fileReader);

	          for (int i = 0; i<ctr ;i++)
	          {
	              service[i] = bufReader.readLine();
	              price [i] = bufReader.readLine();
	              number [i] = bufReader.readLine();
	          }
	          bufReader.close();        
	      }
	      catch(IOException e)
	      {
	          System.out.println("File communication error. Please contact the developer for assistance.");
	      }
	      setTitle("Edit Locate");
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      setResizable(false);
	      
	      // set the content pane properties
	      Container contentPane = getContentPane();   
	      contentPane.setLayout(null);
	      contentPane.setBackground(Color.white);

	      // Buttons

	      cancelButton = new JButton("");
	      cancelButton.setBounds(113, 247, 126, 62);
	      cancelButton.addActionListener(this);
	      cancelButton.setFont(buttonfont);
	      cancelButton.setOpaque(false);
	      cancelButton.setContentAreaFilled(false);
	      cancelButton.setBorderPainted(false);
	      contentPane.add(cancelButton);

	      searchButton = new JButton("");
	      searchButton.setBounds(343, 247, 126, 62);
	      searchButton.addActionListener(this);
	      searchButton.setFont(buttonfont);
	      searchButton.setOpaque(false);
	      searchButton.setContentAreaFilled(false);
	      searchButton.setBorderPainted(false);
	      contentPane.add(searchButton);

	      // Text

	      numText= new JLabel();     
	      numText.setText(""); 
	      numText.setBounds(93,155,300,25);
	      numText.setForeground(Color.black);
	      numText.setFont(buttonfont);
	      contentPane.add(numText);

	      instructionsText= new JLabel();     
	      instructionsText.setText(""); 
	      instructionsText.setBounds(140,80,500,25);
	      instructionsText.setForeground(Color.black);
	      instructionsText.setFont(buttonfont);
	      contentPane.add(instructionsText);

	      // Input Fields
	      numField = new JTextField();
	      numField.setBounds(203, 154, 190, 25);
	      contentPane.add(numField);  
	      numField.addActionListener(this);

	      //Background Image Override
	      bg = new JLabel("");
	      bg.setIcon(new ImageIcon(this.getClass().getResource("/EditLocBg.jpeg")));
	      bg.setBounds(0,0,600,400);
	      contentPane.add(bg);

	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void actionPerformed(ActionEvent event) 
	{
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
		String numcheck = numField.getText();

		if (clickedButton == cancelButton)
		{
			int reply = JOptionPane.showConfirmDialog(
					null,
					"Are you sure you want to cancel the process?",
					"Confirm Cancel",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
				Services frame = new Services();
				frame.setVisible(true);
				dispose();
			}
			else
			{
				JOptionPane.getRootFrame().dispose();
			}
		}
		int sw = 0;
		if (clickedButton == searchButton)
		{
	          for (int i = 0; i<number.length ;i++)
	          {
	              if (numcheck.equals(number[i]))
	              {
	                  int reply = JOptionPane.showConfirmDialog(
	                          null,
	                          "Item found. Continue to editing form?",
	                          "Continue to Edit Form",
	                          JOptionPane.YES_NO_OPTION);

	                  if (reply == JOptionPane.YES_OPTION)
	                  {
	                      edit = i;
	                      try
	                      {        
	                          File outFile = new File("dctr.TXT");
	                          FileOutputStream outFileStream = new FileOutputStream(outFile);
	                          PrintWriter outStream = new PrintWriter(outFileStream);

	                          outStream.println(ctr);
	                          outStream.println(edit);
	                          outStream.println(asadd);
	                          outStream.println(asedit);
	                          outStream.println(asdel);

	                          outStream.close();
	                      }
	                      catch(IOException e)
	                      {
	                          System.out.println("Data communication error. Please contact the program developer for assistance.");
	                      }
	                      sw = 1;

	                      EditService frame = new EditService();
	                      frame.setVisible(true);
	                      dispose();
	                  }

	                  else {
	                      JOptionPane.getRootFrame().dispose();  
	                      sw = 1;
	                  }
	              }
	          }

	          if (sw==0)
	          {
	              JOptionPane.showMessageDialog(null,"Item not found. Remember, numbers are case-sensitive.", "Item Search Error", JOptionPane.ERROR_MESSAGE);    
	          }
		}
		
	}


}
