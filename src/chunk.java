import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class chunk {
    Random r = new Random();
    ArrayList<Rectangle> stars = new ArrayList();
    int x;
    int y;
    int xs;
    int ys;

    chunk(int x,int y,int xs,int ys) {
        this.setX(x);
        this.setY(y);
        this.setXs(xs);
        this.setYs(ys);
        starmaker(x,y,xs,ys);
    }

    void starmaker(int x, int y, int xs, int ys) {
        int rand = r.nextInt(100);
        for (int i = 0; i < rand; i++) {
            int randx = r.nextInt(xs) + x;
            int randy = r.nextInt(ys) + y;
            int rands = r.nextInt(5, 10);
            Rectangle Rectangle = new Rectangle(randx, randy, rands, rands);
            stars.add(Rectangle);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(int xs) {
        this.xs = xs;
    }

    public int getYs() {
        return ys;
    }

    public void setYs(int ys) {
        this.ys = ys;
    }
}