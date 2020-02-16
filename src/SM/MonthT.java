package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
import javax.swing.border.EmptyBorder;

public class MonthT extends JFrame implements ActionListener
{

	private static final int FRAME_WIDTH    = 750;
	private static final int FRAME_HEIGHT   = 475;

	private JButton BackBtn;
	
	private int Janctr = 0;
	private int Febctr = 0;
	private int Marctr = 0;
	private int Aprctr = 0;
	private int Mayctr = 0;
	private int Junctr = 0;
	private int Julctr = 0;
	private int Augctr = 0;
	private int Sepctr = 0;
	private int Octctr = 0;
	private int Novctr = 0;
	private int Decctr = 0;

	private JPanel contentPane;

	// Image Declaration
	private JLabel bg;

	// Text Area
	private JTextArea textArea;

	static String[] month = new String[10000];
	static String[] profit = new String[10000];

	String text_data = "";

	int[] Jan = new int[10000];
	int[] Feb = new int[10000];
	int[] Mar = new int[10000];
	int[] Apr = new int[10000];
	int[] May = new int[10000];
	int[] Jun = new int[10000];
	int[] Jul = new int[10000];
	int[] Aug = new int[10000];
	int[] Sep = new int[10000];
	int[] Oct = new int[10000];
	int[] Nov = new int[10000];
	int[] Dec = new int[10000];
	
	int JanSum = 0;
	int FebSum = 0;
	int MarSum = 0;
	int AprSum = 0;
	int MaySum = 0;
	int JunSum = 0;
	int JulSum = 0;
	int AugSum = 0;
	int SepSum = 0;
	int OctSum = 0;
	int NovSum = 0;
	int DecSum = 0;
	
	public static void main(String[]args)
	{
		MonthT frame = new MonthT();
		frame.setVisible(true);
	}


	public MonthT()
	{
		try
        {
            Scanner scanner = new Scanner(new File("ctr.txt"));
            while(scanner.hasNextInt()){
                Janctr = scanner.nextInt();
                Febctr = scanner.nextInt();
                Marctr = scanner.nextInt();
                Aprctr = scanner.nextInt();
                Mayctr = scanner.nextInt();
                Junctr = scanner.nextInt();
                Julctr = scanner.nextInt();
                Augctr = scanner.nextInt();
                Sepctr = scanner.nextInt();
                Octctr = scanner.nextInt();
                Novctr = scanner.nextInt();
                Decctr = scanner.nextInt();
            }
        }
        catch(IOException e)
        {
            System.out.println("File communication error. Please contact the developer for assistance.");
        }

		try
		{
			File inFile = new File("January.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Janctr ;i++)
			{
				String temp = bufReader.readLine();
				int tempint = Integer.parseInt(temp);
				Jan[i] = tempint;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		JanSum = Arrays.stream(Jan).sum();
		
		try
		{
			File inFile = new File("February.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Febctr ;i++)
			{
				String tempF = bufReader.readLine();
				int tempintF = Integer.parseInt(tempF);
				Feb[i] = tempintF;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		FebSum = Arrays.stream(Feb).sum();
		
		
		try
		{
			File inFile = new File("March.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Marctr ;i++)
			{
				String tempM = bufReader.readLine();
				int tempintM = Integer.parseInt(tempM);
				Mar[i] = tempintM;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		MarSum = Arrays.stream(Mar).sum();
		
		
		try
		{
			File inFile = new File("April.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Aprctr ;i++)
			{
				String tempA = bufReader.readLine();
				int tempintA = Integer.parseInt(tempA);
				Apr[i] = tempintA;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		AprSum = Arrays.stream(Apr).sum();
		
		try
		{
			File inFile = new File("May.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Mayctr ;i++)
			{
				String tempMA = bufReader.readLine();
				int tempintMA = Integer.parseInt(tempMA);
				May[i] = tempintMA;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		MaySum = Arrays.stream(May).sum();
		
		try
		{
			File inFile = new File("June.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Junctr ;i++)
			{
				String tempJ = bufReader.readLine();
				int tempintJ = Integer.parseInt(tempJ);
				Jun[i] = tempintJ;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		JunSum = Arrays.stream(Jun).sum();
		
		try
		{
			File inFile = new File("July.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Julctr ;i++)
			{
				String tempJU = bufReader.readLine();
				int tempintJU = Integer.parseInt(tempJU);
				Jul[i] = tempintJU;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		JulSum = Arrays.stream(Jul).sum();
		
		try
		{
			File inFile = new File("August.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Augctr ;i++)
			{
				String tempA = bufReader.readLine();
				int tempintA = Integer.parseInt(tempA);
				Aug[i] = tempintA;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		AugSum = Arrays.stream(Aug).sum();
		
		try
		{
			File inFile = new File("September.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Sepctr ;i++)
			{
				String tempS = bufReader.readLine();
				int tempintS = Integer.parseInt(tempS);
				Sep[i] = tempintS;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		SepSum = Arrays.stream(Sep).sum();
		
		try
		{
			File inFile = new File("October.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Octctr ;i++)
			{
				String tempO = bufReader.readLine();
				int tempintO = Integer.parseInt(tempO);
				Oct[i] = tempintO;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		OctSum = Arrays.stream(Oct).sum();
		
		try
		{
			File inFile = new File("November.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Novctr ;i++)
			{
				String tempN = bufReader.readLine();
				int tempintN = Integer.parseInt(tempN);
				Nov[i] = tempintN;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		NovSum = Arrays.stream(Nov).sum();
		
		try
		{
			File inFile = new File("December.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);

			for (int i = 0; i<Decctr ;i++)
			{
				String tempD = bufReader.readLine();
				int tempintD = Integer.parseInt(tempD);
				Dec[i] = tempintD;
			}
			bufReader.close();     
			
		}
		catch(IOException e)
		{
			System.out.println("File communication error. Please contact the developer for assistance.");
		}
		DecSum = Arrays.stream(Dec).sum();
		
		try
        {        
            File outFile = new File("TotalText.txt");
            FileOutputStream outFileStream = new FileOutputStream(outFile);
            PrintWriter outStream = new PrintWriter(outFileStream);

            outStream.println("January: " + JanSum);
            outStream.println("\n");
            outStream.println("February: " + FebSum);
            outStream.println("\n");
            outStream.println("March: " + MarSum);
            outStream.println("\n");
            outStream.println("April: " + AprSum);
            outStream.println("\n");
            outStream.println("May: " + MaySum);
            outStream.println("\n");
            outStream.println("June: " + JunSum);
            outStream.println("\n");
            outStream.println("July: " + JulSum);
            outStream.println("\n");
            outStream.println("August: " + AugSum);
            outStream.println("\n");
            outStream.println("September: " + SepSum);
            outStream.println("\n");
            outStream.println("October: " + OctSum);
            outStream.println("\n");
            outStream.println("November: " + NovSum);
            outStream.println("\n");
            outStream.println("December: " + DecSum);
            outStream.println("\n");
            
            outStream.close();
        }
        catch(IOException e)
        {
            System.out.println("Data communication error. Please contact the program developer for assistance.");
        }
		
		try
        {    
            FileReader read = new FileReader("TotalText.txt");
            Scanner scan = new Scanner(read);
            while(scan.hasNextLine()){
                String temp=scan.nextLine()+"\n";
                text_data=text_data+temp;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

		setTitle("Total");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container contentPane = getContentPane();   
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		// Text Area
		textArea = new JTextArea();  
		textArea.setLocation(0, 0);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setText(text_data);
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		textArea.setWrapStyleWord(true);


		contentPane.add(textArea);

		JScrollPane scrollText = new JScrollPane(textArea);        
		scrollText.setBounds(200, 130, 540, 200);
		scrollText.setBorder(BorderFactory.createLineBorder(Color.black));        
		contentPane.add(scrollText);

		BackBtn = new JButton ("");
		BackBtn.setBounds(10, 210, 178, 63);
		BackBtn.addActionListener(this);
		BackBtn.setOpaque(false);
		BackBtn.setContentAreaFilled(false);
		BackBtn.setBorderPainted(false);
		contentPane.add(BackBtn);
		
		//Background Image

		bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/TotalBg.jpeg")));
		bg.setBounds(0,0,750,475);
		contentPane.add(bg);

	}

	public void actionPerformed(ActionEvent event) 
	{
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
		if (clickedButton == BackBtn)
		{
			TProfit frame = new TProfit();
			frame.setVisible(true);
			dispose();
		}
	}


}



