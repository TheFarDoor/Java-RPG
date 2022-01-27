import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;
import java.util.Properties;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Class: Login
 * Description: This class is responsible for giving the player the option to either login or register a new account, if they decided to login
 * their input is compared to a database to see if their login is valid or it will add the new login to the database if they chose to register an account
 * Input: The user can enter their username and password and click a 'Login' button or a 'Register' button.
 * Output: The login window will terminate and it will redirect the user to the main game.
 */

public class Login extends JFrame implements ActionListener
{

    public static JTextField userNameField;
    public static JPasswordField passwordField;

    private ImageIcon backgroundImage_login;
    private JLabel myLabel_login;

    //make function to open Game class
    public void gameOpener() {
        JFrame gameFrame = new JFrame();
        Game game = new Game();
        gameFrame.add(game);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(555, 250, 756, 576);
        Container c = getContentPane();
        gameFrame.pack();
    }

    public Login() {
        //make panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.black);
        loginPanel.setLayout(null);

        //create Game Frame
        setTitle("Gronark: The Game");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //make Login menu where if the user has a login in the database they will be logged into the game
        JButton loginButton = new JButton("Login");
        loginButton.setFont(Menu.f2);
        loginButton.setBackground(Color.WHITE);
        loginButton.setBounds(180,375,200,60);
        loginButton.addActionListener(this);
        loginButton.setActionCommand("Login Button");
        loginPanel.add(loginButton);

        //make Register button that adds the login of the user to the database
        JButton regButton = new JButton("Register");
        regButton.setFont(Menu.f2);
        regButton.setBackground(Color.WHITE);
        regButton.setBounds(400,375,200,60);
        regButton.addActionListener(this);
        regButton.setActionCommand("Register Button");
        loginPanel.add(regButton);

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
                if (userNameField.getText().equals("Username")) {
                    userNameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userNameField.getText().equals("")) {
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
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().equals("")) {
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

        //set background image behind the login system
        setLayout(new BorderLayout());
        backgroundImage_login = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/gronark_hell_finished.png")));
        myLabel_login = new JLabel(backgroundImage_login);
        setLocationRelativeTo(null);
        myLabel_login.setSize(800,590);

        loginPanel.add(myLabel_login);

        //make frame
        setTitle("Gronark: Login");
        setVisible(true);
        setBounds(555, 250, 800, 600);
        Container c = getContentPane();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(loginPanel);

    }
    //make the functionality of each button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login Button")) {
            gameOpener();
            dispose();
        }

    }
}
