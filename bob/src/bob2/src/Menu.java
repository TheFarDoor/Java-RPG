import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Class: Menu
 * Description: this class is the first window that acts as a gateway for the user to choose, either to play the game, change their settings around,
 * see the credits for the game or exit the window and not play the game.
 * Input: The user's button presses when they click the buttons on the window
 * Output: Depending on the user's input a series of actions will occur (e.g. when the 'Play' button is pressed a
 * 'Login' window pops up prompting the user to enter their credentials in the game.
 */

public class Menu extends JFrame implements ActionListener
{
    public static String version;
    public static int resx;
    public static int resy;

    private ImageIcon backgroundImage;
    private JLabel myLabel;
    public static Font f2 = new Font("SansSerif", Font.BOLD, 15);
    public Menu() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("properties.ini"));


        }

        catch(Exception e) {
        }

        //make panel
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        menuPanel.setLayout(null);

        //make font for the game
        f2 = new Font("SansSerif", Font.BOLD, 15);

        //make Play button, when pressed prompts the user to login to their account
        JButton playButton = new JButton("Play");
        playButton.setFont(f2);
        playButton.setBackground(Color.WHITE);
        playButton.setBounds(180,375,200,60);
        playButton.addActionListener(this);
        playButton.setActionCommand("Play Menu");
        menuPanel.add(playButton);

        //make Settings button that allows the user to modify their ini file and change it to their liking
        JButton setButton = new JButton("Settings");
        setButton.setFont(f2);
        setButton.setBackground(Color.WHITE);
        setButton.setBounds(400,375,200,60);
        setButton.addActionListener(this);
        setButton.setActionCommand("Settings Menu");
        menuPanel.add(setButton);

        //make Credits button to show the credits of the people that made the game
        JButton credButton = new JButton("Credits");
        credButton.setFont(f2);
        credButton.setBackground(Color.WHITE);
        credButton.setBounds(180,445,200,60);
        menuPanel.add(credButton);

        //make Exit button, when pressed closes the menu window
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(f2);
        exitButton.setBackground(Color.WHITE);
        exitButton.setBounds(400,445,200,60);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Close Menu");
        menuPanel.add(exitButton);

        //make Secret button, when pressed user enters hard mode
        JButton secretButton = new JButton();
        secretButton.setBackground(Color.BLACK);
        secretButton.setOpaque(false);
        secretButton.setContentAreaFilled(false);
        secretButton.setBorderPainted(false);
        secretButton.setBounds(380,435,20,10);
        menuPanel.add(secretButton);

        //set background image
        setLayout(new BorderLayout());
        backgroundImage = new ImageIcon(this.getClass().getResource("/gronark_bgi_finished.png"));
        myLabel = new JLabel(backgroundImage);
        setLocationRelativeTo(null);
        myLabel.setSize(800,590);

        menuPanel.add(myLabel);

        //make frame
        setTitle("Gronark: The Rebirth");
        setVisible(true);
        setBounds(555, 250, 800, 600);
        Container c = getContentPane();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        add(menuPanel);

    }
    //make the functionality for each of the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Close Menu")) {
            dispose();
        }
        if (e.getActionCommand().equals("Play Menu")) {
            Login login = new Login();
            dispose();
        }
        if (e.getActionCommand().equals("Settings Menu")) {
            Login login = new Login();
            dispose();
        }
    }
}

