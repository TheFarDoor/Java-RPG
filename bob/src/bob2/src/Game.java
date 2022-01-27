import javax.swing.*;
import java.awt.*;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Class: Game
 * Description: This class is responsible for giving the player the option to either login or register a new account, if they decided to login
 * their input is compared to a database to see if their login is valid or it will add the new login to the database if they chose to register an account.
 * Input: The user can enter their username and password and click a 'Login' button or a 'Register' button.
 * Output: The login window will terminate and it will redirect the user to the main game.
 */

public class Game extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 tile (sprite is scaled to be bigger on a 1920x1080 screen
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //756 pixels wide
    final int screenHeight = tileSize * maxScreenRow; //576 pixels tall

    //Set FPS for the game
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);

    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public Game() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //0.01666 seconds between each sprite update
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            //Move the sprite in a different position
            update();

            //Draw the sprite again at updated position
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() { //Update the sprite's position
        player.update();
    }

    public void paintComponent(Graphics g) { //Draw graphics onto the JPanel screen

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }

}
