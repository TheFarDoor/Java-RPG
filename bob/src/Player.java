import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasOrcKey = 0;
    public int hasSnakeKey = 0;
    public int hasArcherKey = 0;
    int standCounter = 0;

    public Player(Game gp, KeyHandler keyH) {

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        up1 = setup("/player/swordsman_up_1");
        up2 = setup("/player/swordsman_up_2");
        down1 = setup("/player/swordsman_down_1");
        down2 = setup("/player/swordsman_down_2");
        left1 = setup("/player/swordsman_left_1");
        left2 = setup("/player/swordsman_left_2");
        right1 = setup("/player/swordsman_right_1");
        right2 = setup("/player/swordsman_right_2");
    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed ||
                keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
            }
            else if (keyH.downPressed) {
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else if (keyH.rightPressed) {
                direction = "right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT REGION
            int objIndex = gp.cChecker.checkObject(this, true);
//            pickUpObjects(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(!collisionOn){

                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            standCounter++;

            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }

        }
    }

//    public void pickUpObjects(int i) {
//        if(i != 999) {
//
//            String objectName = gp.obj[i].name;
//
//            switch (objectName) {
//                case "Key" -> {
//                    hasKey++;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("You got a key!");
//                }
//                case "Door" -> {
//                    if (hasKey > 0) {
//                        gp.obj[i] = null;
//                        hasKey--;
//                    }
//                    System.out.println("Key:" + hasKey);
//                }
//                case "Boots" -> {
//                    speed += 1;
//                    gp.obj[i] = null;
//                }
//                case "Chest" -> {
//                    gp.ui.gameFinished = true;
//                }
//            }
//        }
//    }
    public void interactNPC(int i) {

        if(i != 999) {

            if(gp.keyH.entityInteract == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
            gp.keyH.entityInteract = false;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }
        }

        int x = screenX;
        int y = screenY;

        if(screenX > worldX) {
            x = worldX;
        }
        if(screenY > worldY) {
            y = worldY;
        }
        int rightOffset = gp.screenWidth - screenX;
        if(rightOffset > gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomOffset = gp.screenHeight - screenY;
        if(bottomOffset > gp.worldHeight - worldY) {
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }

        g2.drawImage(image, x, y, null);
        //Check collision box for the player
//      g2.setColor(Color.RED);
//      g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
