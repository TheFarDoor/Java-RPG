import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Boots extends SuperObject{

    Game gp;

    public OBJ_Boots(Game gp) {

        this.gp = gp;

        name = "Boots";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/boots.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
