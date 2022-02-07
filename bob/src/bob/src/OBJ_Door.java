import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject{

    Game gp;

    public OBJ_Door(Game gp) {

        this.gp = gp;

        name = "Door";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
