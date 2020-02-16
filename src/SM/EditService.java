package SM;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.IOException;
import java.awt.Container;



class EditService extends JFrame implements ActionListener 
{
    private static final int FRAME_WIDTH    = 600;
    private static final int FRAME_HEIGHT   = 450;


    // Button Declaration
    private JButton cancelButton;
    private JButton confirmButton;
    private JButton changeButton;

    // Text Declaration
    private JLabel serviceText;
    private JLabel priceText;
    private JLabel numberText;


    // Text Field Declaration
    private JTextField serviceField;
    private JTextField priceField;
    private JTextField numberField;

    // font Declaration

    private Font titlefont = new Font("Verdana", Font.BOLD, 20);
    private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);

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

    static String[] service = new String[max];
    static String[] price = new String[max];
    static String[] number = new String[max];

    public static void main(String[] args) 
    {
        EditService frame = new EditService();  
        frame.setVisible(true); // Display the frame
    }

    public EditService( ) 
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
        setTitle("Edit Service");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        // set the content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        // Buttons

        cancelButton = new JButton("");
        cancelButton.setBounds(235, 350, 127, 72);
        cancelButton.addActionListener(this);
        cancelButton.setFont(buttonfont);
	    cancelButton.setOpaque(false);
	    cancelButton.setContentAreaFilled(false);
	    cancelButton.setBorderPainted(false);
        contentPane.add(cancelButton);

        confirmButton = new JButton("");
        confirmButton.setBounds(346, 268, 127, 70);
        confirmButton.addActionListener(this);
        confirmButton.setFont(buttonfont);
	    confirmButton.setOpaque(false);
	    confirmButton.setContentAreaFilled(false);
	    confirmButton.setBorderPainted(false);
        contentPane.add(confirmButton);
        
        changeButton = new JButton("");
        changeButton.setBounds(120, 268, 127, 70);
        changeButton.addActionListener(this);
        changeButton.setFont(buttonfont);
	    changeButton.setOpaque(false);
	    changeButton.setContentAreaFilled(false);
	    changeButton.setBorderPainted(false);
        contentPane.add(changeButton);


        // Text

        serviceText= new JLabel();     
        serviceText.setText(""); 
        serviceText.setBounds(120,90,300,25);
        serviceText.setForeground(Color.black);
        serviceText.setFont(buttonfont);
        contentPane.add(serviceText);

        priceText= new JLabel();     
        priceText.setText(""); 
        priceText.setBounds(120,140,300,25);
        priceText.setForeground(Color.black);
        priceText.setFont(buttonfont);
        contentPane.add(priceText);

        numberText= new JLabel();     
        numberText.setText(""); 
        numberText.setBounds(120,192,300,25);
        numberText.setForeground(Color.black);
        numberText.setFont(buttonfont);
        contentPane.add(numberText);


        // Input Fields
        serviceField = new JTextField();
        serviceField.setBounds(208, 90, 190, 25);
        serviceField.setText(service[edit]);
        contentPane.add(serviceField);  
        serviceField.addActionListener(this);

        priceField = new JTextField();
        priceField.setBounds(208, 137, 190, 25);
        priceField.setText(price[edit]);
        contentPane.add(priceField);  
        priceField.addActionListener(this);

        numberField = new JTextField();
        numberField.setBounds(208, 189, 190, 25);
        numberField.setText(number[edit]);
        contentPane.add(numberField);  
        numberField.addActionListener(this);


        //Background Image Override
        bg = new JLabel("");
        bg.setIcon(new ImageIcon(this.getClass().getResource("/EditSerBg.jpeg")));
        bg.setBounds(0,0,600,450);
        contentPane.add(bg);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) // Action Perform / Component that executes the actions
    {      
        JButton clickedButton = (JButton) event.getSource();        
        String buttonText = clickedButton.getText();  
        if (clickedButton == changeButton)
        {
            JFileChooser fileChooser = new JFileChooser();

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) 
            {
                File selectedFile = fileChooser.getSelectedFile();
            }
        }
        if (clickedButton == confirmButton)
        {
            int reply = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to edit the item data?",
                    "Confirm Edit",
                    JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION){
                try
                {
                    String sname = serviceField.getText();
                    String sprice = priceField.getText();
                    String snumber = numberField.getText();

                    service[edit]= sname;
                    price[edit]= sprice;
                    number[edit]=snumber;

                    try
                    {        
                        File outFile = new File("store.TXT");
                        FileOutputStream outFileStream = new FileOutputStream(outFile);
                        PrintWriter outStream = new PrintWriter(outFileStream);

                        for (int i = 0; i<ctr ;i++)
                        {
                            outStream.println(service[i]);
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

                    JOptionPane.showMessageDialog(null, "The item has been edited successfully.", "Inventory Edit Success", JOptionPane.INFORMATION_MESSAGE);

                    Services frame=new Services();
                    frame.setVisible(true);
                    dispose();
                }

                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Please ensure all fields are filled in.\nAlso please check that the quantity and restock quantity fields are only numeric characters that are 0 and above.", "DIS - Item Addition Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else {
            JOptionPane.getRootFrame().dispose();  
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
