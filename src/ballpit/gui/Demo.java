package ballpit.gui;

import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import ballpit.internals.BallPit;
import ballpit.observer.DisplayCommand;
import ballpit.observer.DisplayCount;

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

        DisplayCommand label = new DisplayCommand();
        ballPanel.subscribe(label);
        ballPanel.add(label);
        
        add(ballPanel);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
