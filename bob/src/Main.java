import javax.swing.*;
import java.io.*;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Class: Main
 * Description: This class is used for running the main code outside of any other classes in order to prevent errors, this then causes a domino effect of different
 * program branching off of the menu being run from this class.
 * Input: The user runs the program (Shift+F10).
 * Output: Instantiates the Main Menu, running the Menu class and making it pop up on the user's window.
 */

public class Main extends JFrame {


    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
    }


}
