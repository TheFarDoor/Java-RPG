import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Key extends SuperObject {

    Game gp;

    public OBJ_Key(Game gp) {

        this.gp = gp;

        name = "Key";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/key.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
