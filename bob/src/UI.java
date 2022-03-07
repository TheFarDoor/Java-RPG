import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    Game gp;
    Graphics2D g2;
    Font sansSerif_40, sansSerif_80B;
//    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue= "";

    public UI(Game gp) {
        this.gp = gp;

        sansSerif_40 = new Font("SansSerif", Font.PLAIN, 40);
        sansSerif_80B = new Font("SansSerif", Font.BOLD, 80);
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(sansSerif_40);
        g2.setColor(Color.white);

        //CHARACTER SELECTION SCREEN
        if(gp.gameState == gp.charSelectState) {
            drawCharSelectScreen();
        }

        //PLAY STATE
        if(gp.gameState == gp.playState) {

        }
        //BATTLE STATE
        if(gp.gameState == gp.battleState) {
            drawBattleScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
    }
    public void drawCharSelectScreen() {

        //MAIN TEXT
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 69F));
        String text1 = "Select Your Class";
        int x = getXforCenteredText(text1);
        int y = gp.tileSize * 3;


        //MAIN TEXT DRAW + SHADOWS
        g2.setColor(Color.darkGray);
        g2.drawString(text1, x-5, y-5);
        g2.setColor(Color.gray);
        g2.drawString(text1, x-3, y-3);
        g2.setColor(Color.white);
        g2.drawString(text1, x, y);

        //CLASS WORD
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 34F));
        g2.setColor(Color.white);
        String text2 = "> Swordsman";
        x = getXforCenteredText(text2);
        y = gp.tileSize * 8;

        //CLASS WORD DRAW + SHADOWS
        g2.setColor(Color.gray);
        g2.drawString(text2, x-2, y-2);
        g2.setColor(Color.white);
        g2.drawString(text2, x, y);

        //DRAW SWORDSMAN
        x = gp.screenWidth/2 - (gp.tileSize * 2)/2;
        y += gp.tileSize * 2 - (gp.tileSize * 5);
        g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

    }

    public void drawBattleScreen() {

        //MAKE BATTLE SCREEN
    }
    public void drawDialogueScreen() {

        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 230);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 23);
    }

    public int getXforCenteredText(String text) {

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
