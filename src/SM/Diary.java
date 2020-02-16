package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Diary extends JFrame implements java.awt.event.ActionListener
{
	private static final int FRAME_WIDTH    = 800;
	private static final int FRAME_HEIGHT   = 500;

	//Button Deceleration
	private JButton readButton;
	private JButton eraseButton;
	private JButton addButton;
	private JButton backButton;

	//Table Deceleration
	private JTable table = new JTable();

	//Scroll Declaration
	private JScrollPane tableScroll = new JScrollPane();

	// font Declaration
	private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);

	//RAF Deceleration
	RandomAccessFile RAFFile;
	int RECORDLENGTH = 56;

	// Image Declaration
	private JLabel bg;

	public static void main(String[] args) 
	{
		Diary frame = new Diary();  
		frame.setVisible(true); // Display the frame
	}

	public Diary()
	{

		setTitle("Diary");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocation(new java.awt.Point(0, 0));

		// content pane properties
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		read();

		//Buttons
		readButton = new JButton("");
		readButton.setBounds(10, 121, 186, 61);
		readButton.addActionListener(this);
		readButton.setFont(buttonfont);
		readButton.setOpaque(false);
		readButton.setContentAreaFilled(false);
		readButton.setBorderPainted(false);
		contentPane.add(readButton);

		eraseButton = new JButton("");
		eraseButton.setBounds(10, 202, 186, 68);
		eraseButton.addActionListener(this);
		eraseButton.setFont(buttonfont);
		eraseButton.setOpaque(false);
		eraseButton.setContentAreaFilled(false);
		eraseButton.setBorderPainted(false);
		contentPane.add(eraseButton);

		addButton = new JButton("");
		addButton.setBounds(10, 28, 186, 68);
		addButton.addActionListener(this);
		addButton.setFont(buttonfont);
		addButton.setOpaque(false);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		contentPane.add(addButton);
		
		backButton = new JButton ("");
		backButton.setBounds(10, 292, 186, 61);
		backButton.addActionListener(this);
		backButton.setFont(buttonfont);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		contentPane.add(backButton);

		bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/DiaryBg.jpeg")));
		bg.setBounds(0,0,800,478);
		contentPane.add(bg);
	}

	public void actionPerformed(java.awt.event.ActionEvent event)
	{
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
		if (clickedButton == backButton)
		{
			MainManager frame = new MainManager();
			frame.setVisible(true);
			dispose();
			
		}
		if (clickedButton == readButton)
		{
			read();
		}

		if (clickedButton == eraseButton)
		{
			int dialogDelete=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Personnel?", "DELETE PERSONNEL",JOptionPane.YES_NO_OPTION);
            if(dialogDelete==JOptionPane.YES_OPTION)
            {
            	DefaultTableModel model = (DefaultTableModel)table.getModel();
            	int row = table.getSelectedRow();
            	int modelRow = table.convertRowIndexToModel( row );
            	model.removeRow( modelRow );
            	overwriteFile();
            }
		}

		if (clickedButton == addButton)
		{
			writeToFile();
			read();
		}
	}

	void table(){
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {{"", "", ""}}/*this is the initial data inside the table*/,
				new String [] {"Name", "Main Service", "Notes"}//These are the column names
				){//this determines whether a column is editable
			boolean[] canEdit = new boolean [] {
					true, true, true //won't let you edit on the table itself
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		table.setAutoCreateRowSorter(true);//Allows each column to be sorted  
		tableScroll.setViewportView(table);
		getContentPane().add(tableScroll);
		tableScroll.setBounds(200, 10, 500, 400);
	}

	void overwriteFile(){
		Object [][] temp = new Object [table.getRowCount()][table.getColumnCount()];
		for(int i=0;i<table.getRowCount();i++)
		{
			for(int j=0;j<table.getColumnCount();j++)
			{
				temp[i][j]=table.getValueAt(i, j);
			}
		}
		File f = new File("students.txt");
		f.delete();
		try{
			RAFFile = new RandomAccessFile("students.txt","rw");

			long filelength = RAFFile.length(); // number of characters in the kotse.txt
			long recno = filelength / RECORDLENGTH;

			for(int i=0;i<table.getRowCount();i++){
			RAFFile.seek(i*RECORDLENGTH); 
			RAFFile.writeUTF((String)temp[i][0]); // utf = writing in unicode

			RAFFile.seek((i*RECORDLENGTH)+23); //0+12
			RAFFile.writeUTF((String)temp[i][1]);

			RAFFile.seek((i*RECORDLENGTH)+46); //13+12
			RAFFile.writeUTF((String)temp[i][2]);

			RAFFile.seek((i*RECORDLENGTH)+52); //46+5
			RAFFile.writeUTF("**");
			}
			for(int i=table.getRowCount();i<recno;i++){
				
			}
			System.out.println("L:"+ filelength +" LR:"+ recno);

			RAFFile.close();
		}
		catch(Exception e){

			System.out.println("File Error");

		}
	}
	
	void writeToFile(){
		try{
			RAFFile = new RandomAccessFile("students.txt","rw");

			long filelength = RAFFile.length(); // number of characters in the kotse.txt
			long recno = filelength / RECORDLENGTH;

			RAFFile.seek(recno*RECORDLENGTH); 
			RAFFile.writeUTF(JOptionPane.showInputDialog("Name?")); // utf = writing in unicode

			RAFFile.seek((recno*RECORDLENGTH)+23); //0+12
			RAFFile.writeUTF(JOptionPane.showInputDialog("Main Service?"));

			RAFFile.seek((recno*RECORDLENGTH)+46); //13+12
			RAFFile.writeUTF(JOptionPane.showInputDialog("Notes"));

			RAFFile.seek((recno*RECORDLENGTH)+52); //46+5
			RAFFile.writeUTF("**");


			RAFFile.close();
		}
		catch(Exception e){

			System.out.println("File Error");

		}
	}

	void read(){
		Object returnFile[][] = new Object[5][2];

		try
		{
			RAFFile = new RandomAccessFile("students.txt","rw");

			long filelength = RAFFile.length();
			long numberOfRecords = filelength / RECORDLENGTH;

			returnFile = new Object[(int) numberOfRecords][3];

			for (int recno = 0; recno < numberOfRecords; recno++)
			{
				RAFFile.seek(recno*RECORDLENGTH);
				returnFile[recno][0] = RAFFile.readUTF();

				RAFFile.seek(recno*RECORDLENGTH+23);
				returnFile[recno][1] = RAFFile.readUTF();

				RAFFile.seek(recno*RECORDLENGTH+46);
				returnFile[recno][2] = RAFFile.readUTF();
			}

			RAFFile.close();
		}
		catch (Exception e)
		{
			System.out.println("File error");
		}

		table.setModel(new javax.swing.table.DefaultTableModel(
				returnFile/*This is the new data for the table*/,
				new String [] {"Name", "Main Service", "Notes"}//These are the column names
				){//this determines whether a column is editable
			boolean[] canEdit = new boolean [] {
					false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});

		table.setAutoCreateRowSorter(true);//Allows each column to be sorted  

		tableScroll.setViewportView(table);
		getContentPane().add(tableScroll);
		tableScroll.setBounds(261, 31, 500, 400);
	}

}
