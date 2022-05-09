
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Gui panel = new Gui();
    Frame() {
        this.setTitle("Space Invaders (Java)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
