
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JPanel implements ActionListener {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private final int HEIGHT = (int) size.getHeight() - 100;
    private final int WIDTH = (int) size.getWidth() - 100;
    final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    static final int tickrate = 1;
    int lvl, lvlw, lvlh;
    Timer timer;
    boolean running = true;
    Random r = new Random();
    Player pl = new Player(0, 0, 0, 50);
    ArrayList<chunk> chunkl = new ArrayList<>();

    int plchx = 0;
    int plchy = 0;


    Gui() {
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (running) {
                            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                            }
                            switch (e.getKeyCode()) {
                                case KeyEvent.VK_A -> {
                                    pl.setL(true);
                                    pl.setR(false);
                                }
                                case KeyEvent.VK_D -> {
                                    pl.setL(false);
                                    pl.setR(true);
                                }
                                case KeyEvent.VK_W -> {
                                    pl.setAccelerate(true);
                                }
                                case KeyEvent.VK_S -> {
                                    pl.setDecelerate(true);
                                }
                            }
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (running) {
                            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                            }
                            switch (e.getKeyCode()) {
                                case KeyEvent.VK_A -> {
                                    pl.setL(false);
                                    pl.setR(false);
                                }
                                case KeyEvent.VK_D -> {
                                    pl.setL(false);
                                    pl.setR(false);
                                }
                                case KeyEvent.VK_W -> {
                                    pl.setAccelerate(false);
                                }
                                case KeyEvent.VK_S -> {
                                    pl.setDecelerate(false);
                                }
                            }
                        }
                    }
                }
        );

        this.setBackground(Color.BLACK);
        startgame();
    }

    private void startgame() {
        timer = new Timer(tickrate, this);
        timer.start();
        lvlw = WIDTH * 500;
        lvlh = WIDTH * 500;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();
        if (running) {

            g2d.setTransform(reset);
            g2d.setPaint(Color.RED);
            g2d.drawLine(0, 0, lvlw, 0);
            g2d.drawLine(0, 0, 0, lvlh);
            g2d.drawLine(lvlw, lvlh, lvlw, 0);
            g2d.drawLine(lvlw, lvlh, 0, lvlh);
            g2d.drawString(String.valueOf(Math.abs(pl.getRotation())), 1, 20);
            g2d.drawString(String.valueOf(Math.round(pl.getX() / WIDTH)), 1, 60);
            g2d.drawString(String.valueOf(Math.round(pl.getY() / HEIGHT)), 1, 80);
            g2d.drawString(String.valueOf(plchx), 100, 60);
            g2d.drawString(String.valueOf(plchy), 100, 80);
            g2d.drawString(String.valueOf(pl.getX()), 1, 120);
            g2d.drawString(String.valueOf(pl.getY()), 1, 140);
            g2d.rotate(Math.toRadians(pl.getRotation()), getWidth() / 2, getHeight() / 2);
            g2d.setPaint(Color.GREEN);
            g2d.fillRect((int) getWidth() / 2 - 25, (int) getHeight() / 2 - 25, pl.getSize(), pl.getSize());
            g2d.setPaint(Color.RED);
            g2d.drawLine((int) getWidth() / 2 - 25, (int) (getHeight() / 2 - 25 + pl.getSize()), (int) (getWidth() / 2 - 25 + pl.getSize()), (int) (getHeight() / 2 - 25 + pl.getSize()));
            g2d.setTransform(reset);
            g2d.translate(pl.getX()*-1, pl.getY()*-1);
            int x = r.nextInt((int) 100);
            g2d.setPaint(Color.WHITE);

            for (chunk chunk : chunkl) {
                for (Rectangle rectangle : chunk.stars) {
                    g2d.fill(rectangle);
                }
            }
            g2d.setPaint(Color.RED);
            g2d.drawLine(0, 0, lvlw, 0);
            g2d.drawLine(0, 0, 0, lvlh);
            g2d.drawLine(lvlw, lvlh, lvlw, 0);
            g2d.drawLine(lvlw, lvlh, 0, lvlh);
            g2d.setTransform(reset);

        }
    }

    public void chunkmaker() {
        int x = (int) (Math.round(pl.getX() / WIDTH));
        int y = (int) (Math.round(pl.getY() / HEIGHT));

        if (x > plchx) {
            chunkl.add(new chunk((x + 1) * WIDTH, (y - 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x + 1) * WIDTH, y * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x + 1) * WIDTH, (y + 1) * HEIGHT, WIDTH, HEIGHT));
            plchx = x;
        }
        if (x < plchx) {
            chunkl.add(new chunk((x - 1) * WIDTH, (y - 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x - 1) * WIDTH, y * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x - 1) * WIDTH, (y + 1) * HEIGHT, WIDTH, HEIGHT));
            plchx = x;
        }
        if (y > plchy) {
            chunkl.add(new chunk((x - 1) * WIDTH, (y + 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk(x * WIDTH, (y + 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x + 1) * WIDTH, (y + 1) * HEIGHT, WIDTH, HEIGHT));
            plchy = y;
        }
        if (y < plchy) {
            chunkl.add(new chunk((x - 1) * WIDTH, (y - 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk(x * WIDTH, (y - 1) * HEIGHT, WIDTH, HEIGHT));
            chunkl.add(new chunk((x + 1) * WIDTH, (y - 1) * HEIGHT, WIDTH, HEIGHT));
            plchy = y;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            pl.rotate();
            pl.accelerate();
            pl.move();
            pl.decelerate();
            chunkmaker();
        }
        repaint();
    }
}
