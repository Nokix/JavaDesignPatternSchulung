package ballpit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallPanel extends JPanel implements MouseListener {
    private final BallPit ballPit;
    private int max_x;
    private int max_y;

    public BallPanel(BallPit ballPit, int max_x, int max_y) {
        addMouseListener(this);
        this.ballPit = ballPit;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Ball ball : ballPit) {
            g.setColor(ball.color);
            g.fillOval(ball.getX(), ball.getY(), ball.getBallWidth(), ball.getBallHeight());
            ball.updatePositionAndSpeed(max_x, max_y);
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Command command = null;
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> command = new AddBall(new Ball(), ballPit);
        }
        if (command != null) command.execute();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
