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


public class DeleteService extends JFrame implements ActionListener
{
	  private static final int FRAME_WIDTH    = 600;
	  private static final int FRAME_HEIGHT   = 400;


	  // Button Declaration
	  private JButton cancelButton;
	  private JButton searchButton;

	  // Text Declaration
	  private JLabel refText;
	  private JLabel instructionsText;

	  // Text Field Declaration
	  private JTextField refField;

	  // font Declaration

	  private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);

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

	  public static void main(String[] args) 
	  {
	      DeleteService frame = new DeleteService();  
	      frame.setVisible(true); // Display the frame
	  }

	  public DeleteService( ) 
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
	      setTitle("Delete Service");
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      setResizable(false);

	      // set the content pane properties
	      Container contentPane = getContentPane();   
	      contentPane.setLayout(null);
	      contentPane.setBackground(Color.white);

	      // Buttons

	      cancelButton = new JButton("");
	      cancelButton.setBounds(85, 247, 126, 61);
	      cancelButton.addActionListener(this);
	      cancelButton.setFont(buttonfont);
	      cancelButton.setOpaque(false);
	      cancelButton.setContentAreaFilled(false);
	      cancelButton.setBorderPainted(false);
	      contentPane.add(cancelButton);

	      searchButton = new JButton("");
	      searchButton.setBounds(382, 247, 126, 61);
	      searchButton.addActionListener(this);
	      searchButton.setFont(buttonfont);
	      searchButton.setOpaque(false);
	      searchButton.setContentAreaFilled(false);
	      searchButton.setBorderPainted(false);
	      contentPane.add(searchButton);

	      // Text

	      refText= new JLabel();     
	      refText.setText(""); 
	      refText.setBounds(97,157,300,25);
	      refText.setForeground(Color.black);
	      refText.setFont(buttonfont);
	      contentPane.add(refText);

	      instructionsText= new JLabel();     
	      instructionsText.setText(""); 
	      instructionsText.setBounds(64,72,500,25);
	      instructionsText.setForeground(Color.black);
	      instructionsText.setFont(buttonfont);
	      contentPane.add(instructionsText);

	      // Input Fields
	      refField = new JTextField();
	      refField.setBounds(206, 157, 190, 25);
	      contentPane.add(refField);  
	      refField.addActionListener(this);

	      //Background Image Override
	      bg = new JLabel("");
	      bg.setIcon(new ImageIcon(this.getClass().getResource("/DeleteBg.jpeg")));
	      bg.setBounds(0,0,600,400);
	      contentPane.add(bg);

	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	  }

	  public void actionPerformed(ActionEvent event) // Action Perform / Component that executes the actions
	  {      
	      JButton clickedButton = (JButton) event.getSource();        
	      String buttonText = clickedButton.getText(); 
	      String refcheck = refField.getText();
	      int sw = 0;
	      if (clickedButton == cancelButton)
	      {
	          int reply = JOptionPane.showConfirmDialog(
	                  null,
	                  "Are you sure you want to cancel the process?",
	                  "Confirm Cancel",
	                  JOptionPane.YES_NO_OPTION);

	          if (reply == JOptionPane.YES_OPTION){
	              sw = 1;
	              Services frame = new Services();
	              frame.setVisible(true);
	              dispose();
	          }
	          else {
	              sw = 1;
	              JOptionPane.getRootFrame().dispose();  
	          }
	      }
	      if (clickedButton == searchButton)
	      {
	          for (int i = 0; i<number.length; i++)
	          {
	              if (refcheck.equals(number[i]))
	              {
	                  int reply = JOptionPane.showConfirmDialog(
	                          null,
	                          "Are you sure you want to delete this item?",
	                          "Confirm Delete",
	                          JOptionPane.YES_NO_OPTION);

	                  if (reply == JOptionPane.YES_OPTION){
	                      service[i]="----";
	                      price[i]="----";
	                      number[i]="----";

	                      try
	                      {        
	                          File outFile = new File("store.TXT");
	                          FileOutputStream outFileStream = new FileOutputStream(outFile);
	                          PrintWriter outStream = new PrintWriter(outFileStream);

	                          for (int j = 0; j<ctr ;j++)
	                          {
	                              outStream.println(service[j]);
	                              outStream.println(price[j]);
	                              outStream.println(number[j]);
	                          }
	                          outStream.close();
	                      }
	                      catch(IOException e)
	                      {
	                          System.out.println("Data communication error. Please contact the program developer for assistance.");
	                      }

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
	                      JOptionPane.showMessageDialog(null, "The item has been deleted from the inventory system.", "Inventory Deletion Success", JOptionPane.INFORMATION_MESSAGE);

	                      Services frame=new Services();
	                      frame.setVisible(true);
	                      dispose();
	                  }

	                  else {
	                      JOptionPane.getRootFrame().dispose();  
	                  }
	              }
	          }

	      }
	      if (sw == 0)
	      {
	          JOptionPane.showMessageDialog(null,"Item not found. Remember all reference codes are case sensitive.", "Item Not Found", JOptionPane.ERROR_MESSAGE);
	          sw = 1;
	      }
	  }
}
