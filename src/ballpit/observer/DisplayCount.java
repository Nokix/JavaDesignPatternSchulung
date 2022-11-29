package ballpit.observer;

import ballpit.gui.BallPanel;

import javax.swing.*;

public class DisplayCount extends JLabel implements Subscriber {
    public DisplayCount() {
        super();
        setText("Anzahl Bälle: 0");
    }

    @Override
    public void update(Object event) {
        if (event instanceof BallPanel) {
            BallPanel panel = (BallPanel) event;
            setText("Anzahl Bälle: " + panel.getBallPit().getBallPits().size());
        }
    }
}
