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

        //set background image
        backgroundImage = new ImageIcon(this.getClass().getResource("/gronark_bgi_finished.png"));
        myLabel = new JLabel(backgroundImage);
        myLabel.setSize(600,450);
        panel.add(myLabel);


        //make buttons
        JButton playButton = new JButton("Play");
        playButton.setBackground(Color.WHITE);
        playButton.setBounds(180,375,200,60);
        panel.add(playButton);

        JButton setButton = new JButton("Settings");
        setButton.setBackground(Color.WHITE);
        setButton.setBounds(400,375,200,60);
        panel.add(setButton);

        JButton credButton = new JButton("Credits");
        credButton.setBackground(Color.WHITE);
        credButton.setBounds(180,445,200,60);
        panel.add(credButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.WHITE);
        exitButton.setBounds(400,445,200,60);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Close Menu");
        panel.add(exitButton);

        JButton secretButton = new JButton();
        secretButton.setBackground(Color.BLACK);
        secretButton.setBorderPainted(false);
        secretButton.setBounds(380,435,20,10);
        panel.add(secretButton);

        //make entry field
        JTextField userNameField = new JTextField("Username");
        Font f2 = new Font("SansSerif", Font.BOLD, 15);
        userNameField.setFont(f2);
        userNameField.setBounds(240, 100, 310, 60);
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
