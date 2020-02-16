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
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import SM.Identification;
import SM.MainManager;
import SM.StartUpPage;

class Identification extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 300;
	private static int max;
	
	// Button Declaration
	private JButton cancelButton;
	private JButton confirmButton;
	
	//Text Declaration
	private JLabel userText;
	private JLabel passText;
	
	// Text Field Declaration
    private JTextField userField;
    private JTextField passField;
    
    // font Declaration
    private Font buttonfont = new Font("Verdana", Font.PLAIN, 12);
    
    // Image Declaration
    private JLabel bg;
    
 // Authorization Data
    String username = "test";
    String password = "test";
    int errorswitch = 0;

    // Array Declaration
    static String[] account = new String[2];

    public static void main(String[] args) 
    {
        Identification frame = new Identification();  
        frame.setVisible(true); // Display the frame
    }

    public Identification( ) 
    {  
        try
        {
            File inFile = new File("userpass.TXT");
            FileReader fileReader = new FileReader(inFile);
            BufferedReader bufReader = new BufferedReader(fileReader);

           account[0] = bufReader.readLine();
           account[1] = bufReader.readLine();
           
           username = account[0];
           password = account[1];

            bufReader.close();        
        }
        catch(IOException e)
        {
            System.out.println("File communication error. Please contact the developer for assistance.");
        }

        setTitle("Authentication");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        // set the content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        // Buttons

        cancelButton = new JButton("");
        cancelButton.setBounds(77, 221, 160, 35);
        cancelButton.addActionListener(this);
        cancelButton.setOpaque(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setFont(buttonfont);
        contentPane.add(cancelButton);

        confirmButton = new JButton("");
        confirmButton.setBounds(270, 221, 160, 35);
        confirmButton.addActionListener(this);
        confirmButton.setOpaque(false);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setFont(buttonfont);
        contentPane.add(confirmButton);

        // Text

        userText= new JLabel();     
        userText.setText("Username:"); 
        userText.setBounds(110,90,300,25);
        userText.setForeground(Color.white);
        userText.setFont(buttonfont);
        contentPane.add(userText);

        passText= new JLabel();     
        passText.setText("Password:"); 
        passText.setBounds(110,130,300,25);
        passText.setForeground(Color.white);
        passText.setFont(buttonfont);
        contentPane.add(passText);


        // Input Fields
        userField = new JTextField();
        userField.setBounds(220, 90, 190, 25);
        contentPane.add(userField);  
        userField.addActionListener(this);

        passField = new JTextField();
        passField.setBounds(220, 130, 190, 25);
        contentPane.add(passField);  
        passField.addActionListener(this);

        //Background Image Override
        bg = new JLabel("");
        bg.setIcon(new ImageIcon(this.getClass().getResource("/AuthenticationBackground.jpeg")));
        bg.setBounds(0,0,500,278);
        contentPane.add(bg);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) // Action Perform / Component that executes the actions
    {      
        JButton clickedButton = (JButton) event.getSource();        
        String buttonText = clickedButton.getText();
        String usercheck = userField.getText();
        String passcheck = passField.getText();
        if (clickedButton == cancelButton)
        {
            StartUpPage frame = new StartUpPage();
            frame.setVisible(true);
            dispose();
        }
        if (clickedButton == confirmButton)
        {
            if (usercheck.equals(account[0]))
            {
                if (passcheck.equals(account[1]))
                {
                    errorswitch = 0;
                }
                else
                {
                    errorswitch = 2;
                }
            }
            else
            {
                errorswitch = 1;
            }

            if (errorswitch == 0)
            {
                MainManager frame = new MainManager();
                frame.setVisible(true);
                dispose();
            }
            if (errorswitch == 1)
            {
                JOptionPane.showMessageDialog(null,"Invalid Username. Please try again.");
                Identification frame = new Identification();
                frame.setVisible(true);
                dispose();
            }
            if (errorswitch == 2)
            {
                JOptionPane.showMessageDialog(null,"Invalid Password. Please try again.");
                Identification frame = new Identification();
                frame.setVisible(true);
                dispose();
            }

        }
    }
}

