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
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import SM.EditLocate;

class Services extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH    = 800;
    private static final int FRAME_HEIGHT   = 580;
    
    // Button Declaration
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton diaryButton;
    private JButton invenButton;
    private JButton backButton;
    private JButton helpButton;
    
    // Text Declaration
    private JLabel numText;

    // font Declaration
    private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);

    // Image Declaration
    private JLabel bg;

    // Text Field Declaration
    private JTextField numField;

    // Text Area
    private JTextArea textArea;
    
    // Variable Deceleration

    static int max = 1000000;
    static int ctr = 0;
    static int edit = 0;
    static int asadd = 1;
    static int asedit = 1;
    static int asdel = 1;
    

    // Array Deceleration

    static String[] service = new String[max];
    static String[] price = new String[max];
    static String[] number = new String[max];
    
    public static void main(String[] args) 
    {
        Services frame = new Services();  
        frame.setVisible(true); // Display the frame
    }
    
    public Services( )
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
                service[i] = bufReader.readLine(); // Name
                price [i] = bufReader.readLine(); // Price
                number [i] = bufReader.readLine(); // Number
            }
            bufReader.close();        
        }
        catch(IOException e)
        {
            System.out.println("File communication error. Please contact the developer for assistance.");
        }
    	
    	setTitle("Services");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        
        // content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);
        
        // Buttons
        helpButton = new JButton("?");
        helpButton.setBounds(752,0,48,34);
        helpButton.addActionListener(this);
        helpButton.setFont(buttonfont);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(true);
        contentPane.add(helpButton);
        
        addButton =  new JButton("");
        addButton.setBounds(49, 56, 160, 77);
        addButton.addActionListener(this);
        addButton.setFont(buttonfont);
        addButton.setOpaque(false);
        addButton.setContentAreaFilled(false);
        addButton.setBorderPainted(false);
        contentPane.add(addButton);
        
        editButton = new JButton("");
        editButton.setBounds(319, 56, 160, 77);
        editButton.addActionListener(this);
        editButton.setFont(buttonfont);
        editButton.setOpaque(false);
        editButton.setContentAreaFilled(false);
        editButton.setBorderPainted(false);
        contentPane.add(editButton);
        
        deleteButton = new JButton("");
        deleteButton.setBounds(423, 56, 151, 77);
        deleteButton.addActionListener(this);
        deleteButton.setFont(buttonfont);
        deleteButton.setOpaque(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);
        contentPane.add(deleteButton);
        
        searchButton = new JButton("");
        searchButton.setBounds(49, 208, 151, 77);
        searchButton.addActionListener(this);
        searchButton.setFont(buttonfont);
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        contentPane.add(searchButton);
        
        diaryButton = new JButton("");
        diaryButton.setBounds(49, 481, 160, 71);
        diaryButton.addActionListener(this);
        diaryButton.setFont(buttonfont);
        diaryButton.setOpaque(false);
        diaryButton.setContentAreaFilled(false);
        diaryButton.setBorderPainted(false);
        contentPane.add(diaryButton);
        
        invenButton = new JButton("");
        invenButton.setBounds(602, 56, 160, 71);
        invenButton.addActionListener(this);
        invenButton.setFont(buttonfont);
        invenButton.setOpaque(false);
        invenButton.setContentAreaFilled(false);
        invenButton.setBorderPainted(false);
        contentPane.add(invenButton);
        
        backButton = new JButton ("");
        backButton.setBounds(602, 481, 160, 71);
        backButton.addActionListener(this);
        backButton.setFont(buttonfont);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        contentPane.add(backButton);
        
        // Text
        numText= new JLabel();     
        numText.setText("Number:"); 
        numText.setBounds(203,211,266,25);
        numText.setForeground(Color.black);
        numText.setFont(new Font("Superclarendon", Font.PLAIN, 12));
        contentPane.add(numText);

        // Text Field
        numField = new JTextField();
        numField.setBounds(278, 209, 190, 25);
        contentPane.add(numField);  
        numField.addActionListener(this);

        // Text Area
        textArea = new JTextArea();  
        textArea.setEnabled(false);
        textArea.setEditable(false);
        String stringText = "";
        textArea.setText(stringText);
        textArea.setLineWrap(true);
        textArea.setVisible(true);
        textArea.setWrapStyleWord(true);

        contentPane.add(textArea);

        JScrollPane scrollText = new JScrollPane(textArea);        
        scrollText.setBounds(200, 250, 540, 200);
        scrollText.setBorder(BorderFactory.createLineBorder(Color.black));        
        contentPane.add(scrollText);
        
      //Background Image

        bg = new JLabel("");
        bg.setIcon(new ImageIcon(this.getClass().getResource("/ServicesBackground.jpeg")));
        bg.setBounds(0,0,800,560);
        contentPane.add(bg);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	JButton clickedButton = (JButton) event.getSource();
    	String buttonText = clickedButton.getText();
    	if (clickedButton == addButton)
    	{
    		AddService frame = new AddService();
    		frame.setVisible(true);
    		dispose();
    	}
    	if (clickedButton == editButton)
    	{
    		EditLocate frame = new EditLocate();
    		frame.setVisible(true);
    		dispose();
    	}
    	if (clickedButton == deleteButton)
    	{
    		DeleteService frame = new DeleteService();
    		frame.setVisible(true);
    		dispose();
    	}
        if (clickedButton == searchButton)
        {
        	int sw = 0;
            String searchref = numField.getText();
            for (int i = 0; i<number.length ;i++)
            {
            	if (searchref.equals(number[i]))
                {
            		String searchText = "";
                    searchText = searchText + "Service Name: " + service[i] +
                    "\n\nPrice: " + price [i] +
                    "\n\nNumber: " + number[i];
                    textArea.setText(searchText);
                    sw = 1;

                    }
                }
                if (sw==0)
                {
                    JOptionPane.showMessageDialog(null,"Item not found. Remember, reference codes are case-sensitive.", "Product Search Error", JOptionPane.ERROR_MESSAGE);    
                }
            }
    	if (clickedButton == diaryButton)
    	{
    		Diary frame = new Diary();
    		frame.setVisible(true);
    		dispose();
    	}
    	if (clickedButton == invenButton)
    	{
    		Inventory frame = new Inventory();
    		frame.setVisible(true);
    	}
    	if (clickedButton == backButton)
    	{
    		MainManager frame = new MainManager();
    		frame.setVisible(true);
    		dispose();
    	}
		if (clickedButton == helpButton)
		{
			ServicesHelp frame = new ServicesHelp();
			frame.setVisible(true);
			dispose();
		}
    }



}
