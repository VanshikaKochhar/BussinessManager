package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TProfit extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTable table;
	private JTextField profitTF;
	//private JTextField noteTF;
	private JTextField dayTF;

	private int ctr = 0;
	
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
	
    // Image Declaration
    private JLabel bg;

	// String Declaration
	String[] monthArray = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	// ComboBox Declaration
	JComboBox<String> monthList = new JComboBox<>(monthArray);



	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TProfit frame = new TProfit();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TProfit()
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
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 307, 434, 207);
		contentPane.add(scrollPane);

		// TABLE PROPERTIES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[] columns = {"Month","Day","Profit"};
		final DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columns);

		// set the model to the table
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("",1,12);
		table.setFont(font);
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);

		final Object[] row = new Object[3];

		// LOAD Data from File - - - - - - - - - - - - - - - - - - - - - - -    
		try
		{
			File f = new File("data.txt");
			FileReader in = new FileReader(f);
			BufferedReader r = new BufferedReader(in);

			//Reads the number of lines that contains content
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			int lines = 0;
			while (reader.readLine() != null) 
			{
				lines++;
			}

			reader.close();

			for(int y = 0; y < (lines/3); y++)
			{
				model.addRow(row);
			}

			System.out.println(lines); //debug statement

			for (int tr = 0; tr < lines; tr++) 
			{
				for (int col = 0; col < 3; col++) 
				{
					table.setValueAt(r.readLine(), tr, col);
				}
			}

		}
		catch (Exception e1)
		{
			System.out.println("There was an error"+e1);

		}


		// Selects the information from the Table and places it on the Text Field - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  

		table.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e){

				// i = the index of the selected row
				int i = table.getSelectedRow();

				monthList.setSelectedItem(model.getValueAt(i, 0));
				dayTF.setText(model.getValueAt(i, 1).toString());
				profitTF.setText(model.getValueAt(i, 2).toString());

			}
		});

		//  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -



		JButton addBtn = new JButton("");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(monthList.getSelectedItem().toString().equals("January"))
				{
					Janctr++;
				}
				if (monthList.getSelectedItem().toString().equals("February"))
				{
					Febctr++;
				}
				if (monthList.getSelectedItem().toString().equals("March"))
				{
					Marctr++;
				}
				if (monthList.getSelectedItem().toString().equals("April"))
				{
					Aprctr++;
				}
				if (monthList.getSelectedItem().toString().equals("May"))
				{
					Mayctr++;
				}
				if (monthList.getSelectedItem().toString().equals("June"))
				{
					Junctr++;
				}
				if (monthList.getSelectedItem().toString().equals("July"))
				{
					Julctr++;
				}
				if (monthList.getSelectedItem().toString().equals("August"))
				{
					Augctr++;
				}
				if (monthList.getSelectedItem().toString().equals("September"))
				{
					Sepctr++;
				}
				if (monthList.getSelectedItem().toString().equals("October"))
				{
					Octctr++;
				}
				if (monthList.getSelectedItem().toString().equals("November"))
				{
					Novctr++;
				}
				if (monthList.getSelectedItem().toString().equals("December"))
				{
					Decctr++;
				}
				// Add items to the table
				row[0] = monthList.getSelectedItem();
				row[1] = dayTF.getText();
				row[2] = profitTF.getText();

				System.out.println("Row count "+table.getRowCount());

				// add row to the model
				model.addRow(row);
				table.setModel(model);
				// sets the textfields to null after every add
				monthList.setSelectedIndex(0);
				profitTF.setText(null);           
			}
		});
		addBtn.setBounds(450, 25, 135, 49);
		contentPane.add(addBtn);
        addBtn.setOpaque(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setBorderPainted(false);
        


		// Combo Box
		monthList.setBounds(113, 104, 184, 28);
		monthList.addActionListener(this);
		contentPane.add(monthList);

		profitTF = new JTextField();
		profitTF.setBounds(112, 206, 93, 28);
		contentPane.add(profitTF);
		profitTF.setColumns(10);

		/*
		noteTF = new JTextField();
		noteTF.setBounds(112, 250, 134, 28);
		contentPane.add(noteTF);
		noteTF.setColumns(10);
		*/
		//112, 155, 93, 28
		
		dayTF = new JTextField();
		dayTF.setBounds(112, 155, 93, 28);
		contentPane.add(dayTF);
		dayTF.setColumns(10);
		Calendar calendar = Calendar.getInstance();
		dayTF.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));


		JButton helpButton = new JButton ("?");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		ProfitHelp frame = new ProfitHelp();
	    		frame.setVisible(true);
	    		dispose();
			}
		});
		helpButton.setBounds(0, 0, 49, 38);
		contentPane.add(helpButton);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(true);
		
		JButton btnDaily = new JButton ("");
		btnDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		MonthT frame = new MonthT();
	    		frame.setVisible(true);
	    		dispose();
			}
		});
		btnDaily.setBounds(452, 337, 133, 49);
		contentPane.add(btnDaily);
        btnDaily.setOpaque(false);
        btnDaily.setContentAreaFilled(false);
        btnDaily.setBorderPainted(false);
        
		
		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// i = the index of the selected row
				int i = table.getSelectedRow();

				if(i >= 0) 
				{
					model.setValueAt(monthList.getSelectedItem(), i, 0);
					model.setValueAt(dayTF.getText(), i, 1);
					model.setValueAt(profitTF.getText(), i, 2);
				}
				else
				{
					System.out.println("Update Error");
				}

			}
		});
		btnUpdate.setBounds(450, 86, 135, 49);
		contentPane.add(btnUpdate);
        btnUpdate.setOpaque(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setBorderPainted(false);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monthList.getSelectedItem().toString().equals("January"))
				{
					Janctr--;
				}
				if (monthList.getSelectedItem().toString().equals("February"))
				{
					Febctr--;
				}
				if (monthList.getSelectedItem().toString().equals("March"))
				{
					Marctr--;
				}
				if (monthList.getSelectedItem().toString().equals("April"))
				{
					Aprctr--;
				}
				if (monthList.getSelectedItem().toString().equals("May"))
				{
					Mayctr--;
				}
				if (monthList.getSelectedItem().toString().equals("June"))
				{
					Junctr--;
				}
				if (monthList.getSelectedItem().toString().equals("July"))
				{
					Julctr--;
				}
				if (monthList.getSelectedItem().toString().equals("August"))
				{
					Augctr--;
				}
				if (monthList.getSelectedItem().toString().equals("September"))
				{
					Sepctr--;
				}
				if (monthList.getSelectedItem().toString().equals("October"))
				{
					Octctr--;
				}
				if (monthList.getSelectedItem().toString().equals("November"))
				{
					Novctr--;
				}
				if (monthList.getSelectedItem().toString().equals("December"))
				{
					Decctr--;
				}

				// This selects the index of the whole row (i = the index of the selected row)
				int i = table.getSelectedRow();
				if(i >= 0){
					// This function removes a row from jtable
					model.removeRow(i);
				}
				else{
					System.out.println("Delete Error");
				}

			}
		});
		btnDelete.setBounds(450, 214, 135, 52);
		contentPane.add(btnDelete);
        btnDelete.setOpaque(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setBorderPainted(false);

        Date date = new Date();
		Calendar calendar1 = Calendar.getInstance();
		Date cl = calendar1.getTime();
		int cd = calendar1.get(Calendar.DAY_OF_MONTH);
		String day = Integer.toString(cd);
        
        JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
	            {        
	                File outFile = new File("ctr.txt");
	                FileOutputStream outFileStream = new FileOutputStream(outFile);
	                PrintWriter outStream = new PrintWriter(outFileStream);

	                outStream.println(Janctr);
	                outStream.println(Febctr);
	                outStream.println(Marctr);
	                outStream.println(Aprctr);
	                outStream.println(Mayctr);
	                outStream.println(Junctr);
	                outStream.println(Julctr);
	                outStream.println(Augctr);
	                outStream.println(Sepctr);
	                outStream.println(Octctr);
	                outStream.println(Novctr);
	                outStream.println(Decctr);
	                outStream.close();
	            }
	            catch(IOException e1)
	            {
	                System.out.println("Data communication error. Please contact the program developer for assistance.");
	            }
				
				
				 // THIS GETS FROM THE COMBO BOX
					
				for(int i=0;i<monthArray.length;i++)
				{
					String mon = monthArray[i];
					try
					{
						File f = new File(mon + ".txt");
						FileOutputStream out = new FileOutputStream(f);
						PrintWriter w = new PrintWriter(out);

						for (int row = 0; row < table.getRowCount(); row++) 
						{
							if(((String) table.getValueAt(row, 0)).equals(mon)){
								//w.println(monthList.getSelectedItem());
								w.println(table.getValueAt(row, 2));
							}
						}

						w.close();


					}

					catch (Exception ex)
					{

					} 
				}
				
				//Run SAVE to text Function - - - - - - - - - - - - - - - - - - - - - -
				try
				{
					File f = new File("data.txt");
			        FileOutputStream out = new FileOutputStream(f);
			        PrintWriter w = new PrintWriter(out);

			        for (int row = 0; row < table.getRowCount(); row++) 
			        {
						
						for (int col = 0; col < table.getColumnCount(); col++) 
						{
							String val = (String) table.getValueAt(row, col);
							w.println(val);
						}
			        }
			        
			        w.close();
			        
			        JOptionPane.showMessageDialog(null, "Save Successful.");
			        
				}
				
				catch (Exception ex)
				{
					
				} 

			}
		});
		btnSave.setBounds(452, 273, 133, 49);
		contentPane.add(btnSave);
        btnSave.setOpaque(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setBorderPainted(false);

		JButton btnClearInfo = new JButton("");
		btnClearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				monthList.setSelectedItem(null);
				profitTF.setText(null);
				dayTF.setText(null);

			}
		});
		btnClearInfo.setBounds(450, 145, 135, 50);
		contentPane.add(btnClearInfo);
        btnClearInfo.setOpaque(false);
        btnClearInfo.setContentAreaFilled(false);
        btnClearInfo.setBorderPainted(false);
        
        JButton btnBack = new JButton("");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
	    		MainManager frame = new MainManager();
	    		frame.setVisible(true);
	    		dispose();
        	}
        });
		btnBack.setBounds(458, 443, 123, 50);
		contentPane.add(btnBack);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
		
		// B A C K G R O U N D   I M A G E 
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/ProfitBg.jpeg")));
		label.setBounds(0, 0, 609, 514);
		contentPane.add(label);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
