import java.util.Random;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(Game gp) {
        super(gp);

        direction = "down";
        speed = 2;

        getImage();
        setDialogue();
    }

    public void getImage() {

        up1 = setup("/npc/oldman_up_1");
        up2 = setup("/npc/oldman_up_2");
        down1 = setup("/npc/oldman_down_1");
        down2 = setup("/npc/oldman_down_2");
        left1 = setup("/npc/oldman_left_1");
        left2 = setup("/npc/oldman_left_2");
        right1 = setup("/npc/oldman_right_1");
        right2 = setup("/npc/oldman_right_2");
    }

    public void setDialogue() {

        dialogues[0] = "Hello there.";
        dialogues[1] = "I see that you have awakened \nin the land of Gronark.";
        dialogues[2] = "I too was once a young adventurer \nlike you, but my powers were \nstripped from a fellow named \nSliknakrovich.";
        dialogues[3] = "Who is he, you ask?";
        dialogues[4] = "Why he is the monster that rules \nover Gronark.";
        dialogues[5] = "Actually, on that note. \nI have a quest for you, young man!";
        dialogues[6] = "You look like you could take on \na challenge.";
        dialogues[7] = "Collect 3 keys in order to unlock \nSliknakrovich's castle!";
        dialogues[8] = "The first key is in the grasp of the \naqua snake.";
        dialogues[9] = "He is situated at the the north of \nGronark by the ocean.";
        dialogues[10] = "Deliver this key to me and I will tell \nyou where the others reside";
        dialogues[11] = "Good luck!";

    }
    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; //Pick number from 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";

            }
            actionLockCounter = 0;
        }
    }
    public void speak() {

        super.speak();
    }
}