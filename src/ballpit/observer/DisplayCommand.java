package ballpit.observer;

import javax.swing.JLabel;

import ballpit.gui.BallPanel;

public class DisplayCommand extends JLabel implements Subscriber {
    public DisplayCommand() {
        super();
        setText("What is happening.");
    }

    @Override
    public void update(Object event) {
        if (event instanceof BallPanel) {
        	BallPanel panel = (BallPanel) event;
            setText("What is happening: " + panel.getCommand().get(0));
            panel.getCommand().remove(0);
        }
    }
}
