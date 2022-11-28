package ballpit;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = 600;
        int width = 800;
        setSize(width, height);

        BallPit ballPit = new BallPit();
        ballPit.addBall(new Ball());
        BallPanel ballPanel = new BallPanel(ballPit, width, height);
        add(ballPanel);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
