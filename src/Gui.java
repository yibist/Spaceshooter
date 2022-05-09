
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Gui extends JPanel implements ActionListener {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private final int HEIGHT = (int) size.getHeight() - 100;
    private final int WIDTH = (int) size.getWidth() - 100;
    final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    static final int tickrate =1;
    Timer timer;
    boolean running = true;

    Player pl = new Player(WIDTH / 2 - 25, HEIGHT / 2 - 25, 0, 50);
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
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();
        Random r = new Random();
        if (running) {
            g2d.setPaint(Color.RED);
            g2d.drawString(String.valueOf(Math.abs(pl.getRotation())),1,20);
            g2d.drawString(String.valueOf(Math.abs(Math.sin(pl.getRotation()))),1,60);
            g2d.drawString(String.valueOf(Math.abs(Math.cos(pl.getRotation()))),1,80);
            g2d.drawString(String.valueOf(pl.getSpeedhorizontal()),1,120);
            g2d.drawString(String.valueOf(pl.getSpeedvertical()),1,140);
            g2d.rotate(Math.toRadians(pl.getRotation()),getWidth()/2, getHeight()/2);
            g2d.setPaint(Color.GREEN);
            g2d.fillRect((int) getWidth()/2-25, (int) getHeight()/2-25, pl.getSize(), pl.getSize());
            g2d.setPaint(Color.RED);
            g2d.drawLine((int) getWidth()/2-25, (int) (getHeight()/2-25+pl.getSize()), (int) (getWidth()/2-25+pl.getSize()), (int) (getHeight()/2-25+pl.getSize()));
            g2d.setTransform(reset);
            g2d.translate(pl.getX(),pl.getY());
            g2d.fillRect(100,100,100,100);
            g2d.setTransform(reset);
            int x = r.nextInt((int)100);;
            g2d.setPaint(Color.WHITE);
            for (int i= 0;i<x;i++) {
                g2d.fillRect(r.nextInt((int)(WIDTH)),r.nextInt((int)(HEIGHT)),5,5);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            pl.rotate();
            pl.accelerate();
            pl.move();
            pl.decelerate();
        }
        repaint();
    }
}
