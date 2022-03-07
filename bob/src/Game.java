import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

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

    public final int tileSize = originalTileSize * scale; //48x48 tile (sprite is scaled to be bigger on a 1920x1080 screen
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol; //756 pixels wide
    public int screenHeight = tileSize * maxScreenRow; //576 pixels tall

    //World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //Set FPS for the game
    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public ObjectMaker oMaker = new ObjectMaker(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject[] obj = new SuperObject[10];
    public Entity npc[] = new Entity[10];

    //GAME STATE
    public int gameState;
    public int charSelectState = 0;
    public final int playState = 1;
    public final int battleState = 2;
    public final int dialogueState = 3;


    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public Game() {
        //Fetch the initial values
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {

        oMaker.setObject();
        oMaker.setNPC();
        gameState = charSelectState;
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

    //Update the sprite's position
    public void update() {
        if(gameState == playState) {
            //PLAYER
            player.update();
            //NPC
            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].update();
                }
            }
        }
        if(gameState == battleState) {

        }
    }

    public void paintComponent(Graphics g) { //Draw graphics onto the JPanel screen

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }
        //PLAYER SELECTION SCREEN
        if(gameState == charSelectState) {
            ui.draw(g2);
        }
        //OTHERS
        else {
            //DRAW TILES
            tileM.draw(g2);

            //DRAW OBJECTS
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }
            //DRAW NPCS
            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].draw(g2);
                }
            }

            //DRAW PLAYER
            player.draw(g2);

            //UI
            ui.draw(g2);
        }


        if(keyH.checkDrawTime == true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;

            g2.setFont(Menu.f2);
            g2.setColor(Color.white);
            int x = 10;
            int y = 400;
            int lineHeight = 20;

            g2.drawString("WorldX" + player.worldX, x, y); y+= lineHeight;
            g2.drawString("WorldY" + player.worldY, x, y); y+= lineHeight;
            g2.drawString("Col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y+= lineHeight;
            g2.drawString("Row" + (player.worldY + player.solidArea.y)/tileSize, x, y); y+= lineHeight;

            g2.drawString("Draw Time: " + passed, x, y);
        }

        g.dispose();
    }

}