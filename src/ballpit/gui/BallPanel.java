package ballpit.gui;

import ballpit.internals.Ball;
import ballpit.internals.BallPit;
import ballpit.commands.*;
import ballpit.observer.Subscriber;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

public class BallPanel extends JPanel implements MouseListener, KeyListener {
    private BallPit ballPit;
    private int max_x;
    private int max_y;
    private Memento savePoint = null;
    private Collection<Subscriber> subscribers = new ArrayList<>();

    public BallPanel(BallPit ballPit, int max_x, int max_y) {
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        this.ballPit = ballPit;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    public BallPit getBallPit() {
        return ballPit;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Object event) {
        subscribers.parallelStream().forEach(subscriber -> subscriber.update(event));
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
            case MouseEvent.BUTTON1 : command = new AddBall(new Ball(), ballPit); break;
            case MouseEvent.BUTTON3 : command = new RemoveBall(ballPit); break;
        }
        if (command != null){
            command.execute();
            notifySubscribers(this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Command command = null;
        switch (e.getKeyChar()) {
            case 'a': command = new AddBall(new Ball(), ballPit); break;
            case 'r': command = new RemoveBall(ballPit); break;
            case 'u': command = new UndoCommand(); break;
            case 'c': command = new ChangeColorToGreen(ballPit); break;
            case 's': save(); break;
            case 'l': restore(); break;
//            case 'z': command = new ChangeColorToPrevious(ballPit);  break;
        }
        if (command != null) {
            command.execute();
            notifySubscribers(this);
        }
    }

    class Memento {
        BallPit ballPitM;
        int max_xM;
        int max_yM;

        public Memento(BallPanel ballPanel) {
            this.ballPitM = ballPanel.ballPit.clone();
            this.max_xM = ballPanel.max_x;
            this.max_yM = ballPanel.max_y;
        }
    }

    public void restore() {
        if(this.savePoint != null) restore(this.savePoint);
    }

    public void restore(Memento memento) {
        this.ballPit = memento.ballPitM.clone();
        this.max_x = memento.max_xM;
        this.max_y = memento.max_yM;
    }

    public Memento save() {
        Memento memento = new Memento(this);
        this.savePoint = memento;
        return memento;
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


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
