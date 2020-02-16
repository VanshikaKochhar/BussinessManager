package SM;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class StartUpPage extends JFrame implements ActionListener
{
	
	private static final int FRAME_WIDTH    = 800;
    private static final int FRAME_HEIGHT   = 580;
    
    //Button Declaration
    private JButton infoButton;
    private JButton startButton;
    private JButton quitButton;
    private JButton helpButton;
    

    // font Declaration
    private Font buttonfont = new Font("QuickSand", Font.PLAIN, 12);

    // Image Declaration
    private JLabel bg;


    public static void main(String [] args)
    {
    	StartUpPage frame = new StartUpPage();
    	frame.setVisible(true);
    }

	
	public StartUpPage() {
		
		setTitle("Manager");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        
        // content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);
        
        // Buttons
        helpButton = new JButton("?");
        helpButton.setBounds(754,0,46,40);
        helpButton.addActionListener(this);
        helpButton.setFont(buttonfont);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(true);
        contentPane.add(helpButton);
        
        infoButton = new JButton("");
        infoButton.setBounds(0, 416, 800, 71);
        infoButton.addActionListener(this);
        infoButton.setFont(buttonfont);
        infoButton.setOpaque(false);
        infoButton.setContentAreaFilled(false);
        infoButton.setBorderPainted(false);
        contentPane.add(infoButton);
        
        startButton = new JButton("");
        startButton.setBounds(0, 339, 800, 71);
        startButton.addActionListener(this);
        startButton.setFont(buttonfont);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        contentPane.add(startButton);
        
        quitButton = new JButton("");
        quitButton.setBounds(0, 486, 800, 74);
        quitButton.addActionListener(this);
        quitButton.setFont(buttonfont);
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        contentPane.add(quitButton);
        
        // Background Image
        bg = new JLabel("");
        bg.setIcon(new ImageIcon(this.getClass().getResource("/StartBackground.jpeg")));
        bg.setBounds(0, 0, 800, 560);
        contentPane.add(bg);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		JButton clickedButton = (JButton) event.getSource();
		String buttonText = clickedButton.getText();
		if (clickedButton == infoButton)
		{
			JOptionPane.showMessageDialog(null,"Made by: Vanshika Kochhar \nProgram: Bussiness Manager \nCreator Contact Info: \n Email - vanshikaak27@gmail.com \n Number - 09273147724");
		}
		if (clickedButton == startButton)
		{
			Identification frame = new Identification();
			frame.setVisible(true);
			dispose();
		}
		if (clickedButton == quitButton)
		{
			int reply = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to exit the program?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            else {
                StartUpPage frame = new StartUpPage();
            }
		}
		if (clickedButton == helpButton)
		{
			StartPageHelp frame = new StartPageHelp();
			frame.setVisible(true);
			dispose();
		}
	}
}
	

