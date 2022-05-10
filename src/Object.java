
public class Object {
    private int rotation;
    private boolean horizontal, vertical;
    private double speedhorizontal = 0;
    private double speedvertical = 0;
    private double maxspeed;
    private double weight;
    private double y;
    private double x;
    boolean accelerate = false;
    boolean decelerate = false;
    boolean l = false;
    boolean r = false;

    public void move() {
        setY(getY() + getSpeedvertical());
        setX(getX() - getSpeedhorizontal());

    }
    public void accelerate() {
        if (accelerate) {
                this.setSpeedhorizontal(getSpeedhorizontal() + (Math.sin(Math.toRadians(getRotation())) * 1));
                this.setSpeedvertical((getSpeedvertical() + (Math.cos(Math.toRadians(getRotation())) * 1)));
        }
        if (decelerate) {
            this.setX(getX() + (Math.sin(Math.toRadians(getRotation()))));
            this.setY(getY() - (Math.cos(Math.toRadians(getRotation()))));
        }
    }
    public void decelerate() {
        setSpeedhorizontal(getSpeedhorizontal()*0.99);
        setSpeedvertical(getSpeedvertical()*0.99);

    }
    public void rotate() {
        if (l) {
            this.setRotation(getRotation()-3);
        }  else if (r) {
            this.setRotation(getRotation()+3);
        }
        if (getRotation() >= 360) {
            setRotation(0);
        } else if (getRotation() < 0) {
            setRotation(359);
        }
    }
    public double getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(double maxspeed) {
        this.maxspeed = maxspeed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size;
    public double getX() {
        return x;
    }

    public int setX(double x) {
        this.x = x;
        return 0;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public double getSpeedhorizontal() {
        return speedhorizontal;
    }

    public void setSpeedhorizontal(double speedhorizontal) {
        this.speedhorizontal = speedhorizontal;
    }

    public double getSpeedvertical() {
        return speedvertical;
    }

    public void setSpeedvertical(double speedvertical) {
        this.speedvertical = speedvertical;
    }
    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }


    public boolean isAccelerate() {
        return accelerate;
    }

    public void setAccelerate(boolean accelerate) {
        this.accelerate = accelerate;
    }

    public boolean isDecelerate() {
        return decelerate;
    }

    public void setDecelerate(boolean decelerate) {
        this.decelerate = decelerate;
    }
    public boolean isL() {
        return l;
    }

    public void setL(boolean l) {
        this.l = l;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
}
