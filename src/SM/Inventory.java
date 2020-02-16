package SM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Inventory extends JFrame implements ActionListener
{
    static int max = 1000000;
    static int ctr = 0;
    static int edit = 0;
    static int asadd = 1;
    static int asedit = 1;
    static int asdel = 1;
    
    static String[] service = new String[max];
    static String[] price = new String[max];
    static String[] number = new String[max];
    
    public static void main(String args[])
    {
    	Inventory frame = new Inventory();
    	frame.setVisible(true);
    }
    
    public Inventory()
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
        
        Object columns[] = { "Service", "Price", "Number"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for(int i=0;i<ctr ;i++)
        {
            Vector row = new Vector(100000);
            if (number[i]!="----")
            {
                row.add(service[i]);
                row.add(price[i]);
                row.add(number[i]);
                model.addRow(row);
            }
        }
        
        setTitle("Inventory");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        
        Container contentPane = getContentPane();   
        contentPane.setLayout(new GridLayout());

        JTable table = new JTable( model );
        table.getTableHeader().setResizingAllowed(true);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setEnabled(false);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
