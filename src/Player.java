
public class Player extends Object {
    Player(int x, int y, int rotation, int size) {
        setX(x);
        setY(y);
        setRotation(rotation);
        setSize(size);
    }
    public void acceleration() {
        double prevh = getSpeedhorizontal();
        double prevv = getSpeedvertical();
        if (accelerate) {
            if (Math.abs(getSpeedhorizontal()) + Math.abs(getSpeedvertical()) >= 10) {
                double px = (10 / (Math.abs(Math.sin(Math.toRadians(getRotation()))) + Math.abs(Math.cos(Math.toRadians(getRotation()))))) * Math.sin(Math.toRadians(getRotation()));
                double py = (10 / (Math.abs(Math.sin(Math.toRadians(getRotation()))) + Math.abs(Math.cos(Math.toRadians(getRotation()))))) * Math.cos(Math.toRadians(getRotation()));
                System.out.println("-----------------------------------");
                System.out.println(px);
                System.out.println(py);
                System.out.println(Math.abs(px) + Math.abs(py));
                setSpeedhorizontal(px);
                setSpeedvertical(py);
            }
        }
    }


}
