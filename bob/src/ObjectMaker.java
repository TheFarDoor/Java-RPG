
public class ObjectMaker {

    Game gp;

    public ObjectMaker(Game gp) {
        this.gp = gp;
    }

    public void setObject() {

    }
    public void setNPC() {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }
}
