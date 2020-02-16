package SM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProfitHelp extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH    = 800;
    private static final int FRAME_HEIGHT   = 580;
    
    // Image Declaration
    private JLabel bg;
    
    //Button
    private JButton BackButton;
    
    // font Declaration
    private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);
	
    public static void main(String [] args)
    {
    	ProfitHelp frame = new ProfitHelp();
    	frame.setVisible(true);
    }
    
    public ProfitHelp()
    {
		setTitle("Help");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        
        // content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);
        
        // Buttons
        BackButton = new JButton("Back");
        BackButton.setBounds(754,518,46,40);
        BackButton.addActionListener(this);
        BackButton.setFont(buttonfont);
        BackButton.setOpaque(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setBorderPainted(true);
        contentPane.add(BackButton);
        
        // Background Image
        bg = new JLabel("");
        bg.setIcon(new ImageIcon(this.getClass().getResource("/ProfitHelp.jpeg")));
        bg.setBounds(0, 0, 800, 580);
        contentPane.add(bg);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent event)
    {
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
    	if (clickedButton == BackButton)
		{
			TProfit frame = new TProfit();
			frame.setVisible(true);
			dispose();
		}
    }
}
