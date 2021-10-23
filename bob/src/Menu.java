import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Menu extends JFrame implements ActionListener
{
    private ImageIcon backgroundImage;
    private JLabel myLabel;
    public Menu() {
        //make panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(null);

        //make font for the main menu
        Font f2 = new Font("SansSerif", Font.BOLD, 15);

        //make buttons
        JButton playButton = new JButton("Play");
        playButton.setBackground(Color.WHITE);
        playButton.setFont(f2);
        playButton.setBounds(180,375,200,60);
        panel.add(playButton);

        JButton setButton = new JButton("Settings");
        setButton.setBackground(Color.WHITE);
        setButton.setFont(f2);
        setButton.setBounds(400,375,200,60);
        panel.add(setButton);

        JButton credButton = new JButton("Credits");
        credButton.setBackground(Color.WHITE);
        credButton.setFont(f2);
        credButton.setBounds(180,445,200,60);
        panel.add(credButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.WHITE);
        exitButton.setFont(f2);
        exitButton.setBounds(400,445,200,60);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Close Menu");
        panel.add(exitButton);

        JButton secretButton = new JButton();
        secretButton.setBackground(Color.BLACK);
        secretButton.setBorderPainted(false);
        secretButton.setBounds(380,435,20,10);
        panel.add(secretButton);

        //make redundant text field so that Username text field is visible to user when they start the program
        JTextField secretField = new JTextField("");
        secretField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        secretField.setOpaque(false);
        secretField.setBounds(240,0,310,60);
        panel.add(secretField);

        //make entry field
        JTextField userNameField = new JTextField("Username");
        userNameField.setFont(f2);
        userNameField.setForeground(Color.WHITE);
        userNameField.setBorder(BorderFactory.createLineBorder(Color.decode("#68a45b"), 1));
        userNameField.setOpaque(false);
        userNameField.setBounds(240, 165, 310, 60);
        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(userNameField.getText().equals("Username")) {
                    userNameField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(userNameField.getText().equals("")){
                    userNameField.setText("Username");
                }
            }
        });

        panel.add(userNameField);

        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setFont(f2);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#68a45b"), 1));
        passwordField.setOpaque(false);
        passwordField.setBounds(240, 235, 310, 60);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(passwordField.getText().equals("Password")) {
                    passwordField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().equals("")){
                    passwordField.setText("Password");
                }
            }
        });

        panel.add(passwordField);

        //set background image
        backgroundImage = new ImageIcon(this.getClass().getResource("/gronark_bgi_finished.png"));
        myLabel = new JLabel(backgroundImage);
        myLabel.setSize(800,600);
        panel.add(myLabel);

        //make frame
        setTitle("Gronark: The Rebirth");
        setVisible(true);
        setBounds(555, 250, 800, 600);
        Container c = getContentPane();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Close Menu")) {
            dispose();
        }

    }
}
