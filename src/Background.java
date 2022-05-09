import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Background {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private final int HEIGHT = (int) size.getHeight() - 100;
    private final int WIDTH = (int) size.getWidth() - 100;
    Random r = new Random();
    ArrayList<Rectangle> stars = new ArrayList();
    Background() {
        fill();
        System.out.println(stars);
    }

    public void fill() {
        int rand = r.nextInt(100);
        for (int i = 0; i<rand;i++) {
            int randx = r.nextInt(WIDTH);
            int randy = r.nextInt(HEIGHT);
            int rands = r.nextInt(5,10);
            Rectangle Rectangle = new Rectangle(randx,randy,rands,rands);
            stars.add(Rectangle);
        }
    }
}


