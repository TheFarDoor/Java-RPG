import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Menu extends JFrame implements ActionListener
{
    public Menu() {
        //make panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(null);

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

        JLabel labelName = new JLabel("Enter Name :");
        labelName.setBounds(50,300,100,100);




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