import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame
{
    public static JTextField userNameField;
    public static JPasswordField passwordField;
    public Login() {
        //make panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.black);
        loginPanel.setLayout(null);

        //make frame
        setTitle("Gronark: Login");
        setVisible(true);
        setBounds(555, 250, 800, 600);
        Container c = getContentPane();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(loginPanel);

        //set background image
        setLayout(new BorderLayout());
        backgroundImage = new ImageIcon(this.getClass().getResource("/gronark_bgi_finished.png"));
        myLabel = new JLabel(backgroundImage);
        setLocationRelativeTo(null);
        myLabel.setSize(800,590);

        loginPanel.add(myLabel);


        //add username entry field
        userNameField = new JTextField("Username");
        userNameField.setFont(Menu.f2);
        userNameField.setForeground(Color.white);
        userNameField.setBorder(BorderFactory.createLineBorder(Color.decode("#54ab6f"), 1));
        userNameField.setOpaque(false);
        userNameField.setBounds(240, 160, 310, 60);
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
        loginPanel.add(userNameField);

        //add password field onto the panel
        passwordField = new JPasswordField("Password");
        passwordField.setFont(Menu.f2);
        passwordField.setForeground(Color.white);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#54ab6f"), 1));
        passwordField.setOpaque(false);
        passwordField.setBounds(240, 230, 310, 60);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().equals("")){
                    passwordField.setText("Password");
                }
            }
        });
        loginPanel.add(passwordField);

        //add invisible text field to fix automatically hovering on username text field
        JTextField secretField = new JTextField("");
        secretField.setOpaque(false);
        secretField.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        secretField.setBounds(240, 0, 310, 0);

        loginPanel.add(secretField);








}
