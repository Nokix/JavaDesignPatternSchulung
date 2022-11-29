package ballpit.gui;

import ballpit.internals.Ball;
import ballpit.internals.BallPit;
import ballpit.observer.DisplayCount;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = 600;
        int width = 800;
        setSize(width, height);

        BallPit ballPit = new BallPit();
        BallPanel ballPanel = new BallPanel(ballPit, width, height);
        ballPanel.setLayout(new BoxLayout(ballPanel, BoxLayout.Y_AXIS));

        DisplayCount displayCount = new DisplayCount();
        ballPanel.subscribe(displayCount);
        ballPanel.add(displayCount);

        JLabel label = new JLabel("What is happening.");
        ballPanel.add(label);
        add(ballPanel);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
