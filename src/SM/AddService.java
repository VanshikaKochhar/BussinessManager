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

public class AddService extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH    = 600;
	private static final int FRAME_HEIGHT   = 400;
	
	  // Button Declaration
	  private JButton cancelButton;
	  private JButton confirmButton;
	  
	  // Text Declaration
	  private JLabel serviceText;
	  private JLabel priceText;
	  private JLabel numberText;
	  
	  // Text Field Declaration
	  private JTextField serviceField;
	  private JTextField priceField;
	  private JTextField numberField;
	  
	  // font Declaration

	  private Font buttonfont = new Font("QuickSand", Font.BOLD, 12);

	  // Image Declaration

	  private JLabel bg;

	  // Variable Declaration

	  static int max = 1000000;
	  static int ctr = 0;
	  static int edit = 0;
	  static int asadd = 1;
	  static int asedit = 1;
	  static int asdel = 1;
	  
	  // Array Declaration

	  static String[] name = new String[max];
	  static String[] price = new String[max];
	  static String[] number = new String[max];

	  
	  public static void main(String[] args) 
	  {
	      AddService frame = new AddService();  
	      frame.setVisible(true); // Display the frame
	  }
	  
	  public AddService( ) 
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
	              name[i] = bufReader.readLine();
	              price [i] = bufReader.readLine();
	              number [i] = bufReader.readLine();
	          }
	          bufReader.close();        
	      }
	      catch(IOException e)
	      {
	          System.out.println("File communication error. Please contact the developer for assistance.");
	      }
	      setTitle("Add Service");
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      setResizable(false);
	      
	      // set the content pane properties
	      Container contentPane = getContentPane();   
	      contentPane.setLayout(null);
	      contentPane.setBackground(Color.white);
	      
	      // Buttons

	      cancelButton = new JButton("");
	      cancelButton.setBounds(116, 281, 123, 55);
	      cancelButton.addActionListener(this);
	      cancelButton.setFont(buttonfont);
	      cancelButton.setOpaque(false);
	      cancelButton.setContentAreaFilled(false);
	      cancelButton.setBorderPainted(false);
	      contentPane.add(cancelButton);

	      confirmButton = new JButton("");
	      confirmButton.setBounds(343, 281, 123, 55);
	      confirmButton.addActionListener(this);
	      confirmButton.setFont(buttonfont);
	      confirmButton.setOpaque(false);
	      confirmButton.setContentAreaFilled(false);
	      confirmButton.setBorderPainted(false);
	      contentPane.add(confirmButton);
	      
	      // Text

	      serviceText= new JLabel();     
	      serviceText.setText(""); 
	      serviceText.setBounds(84,83,354,25);
	      serviceText.setForeground(Color.black);
	      serviceText.setFont(buttonfont);
	      contentPane.add(serviceText);

	      priceText= new JLabel();     
	      priceText.setText(""); 
	      priceText.setBounds(89,146,349,25);
	      priceText.setForeground(Color.black);
	      priceText.setFont(buttonfont);
	      contentPane.add(priceText);

	      numberText= new JLabel();     
	      numberText.setText(""); 
	      numberText.setBounds(89,199,349,25);
	      numberText.setForeground(Color.black);
	      numberText.setFont(buttonfont);
	      contentPane.add(numberText);
	      
	      // Input Fields
	      serviceField = new JTextField();
	      serviceField.setBounds(248, 83, 190, 25);
	      contentPane.add(serviceField);  
	      serviceField.addActionListener(this);

	      priceField = new JTextField();
	      priceField.setBounds(248, 146, 190, 25);
	      contentPane.add(priceField);  
	      priceField.addActionListener(this);

	      numberField = new JTextField();
	      numberField.setBounds(248, 199, 190, 25);
	      contentPane.add(numberField);  
	      numberField.addActionListener(this);
	      
	      //Background Image Override
	      bg = new JLabel("");
	      bg.setIcon(new ImageIcon(this.getClass().getResource("/ServicesBg.jpeg")));
	      bg.setBounds(0,0,600,400);
	      contentPane.add(bg);

	      setLocationRelativeTo(null);

	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	  }
	  
	  public void actionPerformed(ActionEvent event)
	  {
		  JButton clickedButton = (JButton) event.getSource();
		  String buttonText = clickedButton.getText();
		  if (clickedButton == confirmButton)
		  {
	          String sname = serviceField.getText();
	          String sprice = priceField.getText();
	          String snumber = numberField.getText();
	          
	          name[ctr]= sname; //service name
	          price[ctr]= sprice; //service price
	          number[ctr]= snumber; //service number
	          
	          ctr++;
	          
	          try
	          {        
	              File outFile = new File("store.TXT");
	              FileOutputStream outFileStream = new FileOutputStream(outFile);
	              PrintWriter outStream = new PrintWriter(outFileStream);
	              for (int i = 0; i<ctr ;i++)
	              {
	                  outStream.println(name[i]);
	                  outStream.println(price[i]);
	                  outStream.println(number[i]);
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
	          
	          JOptionPane.showMessageDialog(null, "The product has been added to inventory system.", "Inventory Addition Success", JOptionPane.INFORMATION_MESSAGE);

	          Services frame = new Services();
	          frame.setVisible(true);
	          dispose();
		  }
		  
	      if (clickedButton == cancelButton)
	      {
	          int reply = JOptionPane.showConfirmDialog(
	                  null,
	                  "Are you sure you want to cancel the process?",
	                  "Confirm Cancel",
	                  JOptionPane.YES_NO_OPTION);

	          if (reply == JOptionPane.YES_OPTION){
	              Services frame = new Services();
	              frame.setVisible(true);
	              dispose();
	          }
	          else {
	              JOptionPane.getRootFrame().dispose();  
	          }
	      }
	  }

	
}
