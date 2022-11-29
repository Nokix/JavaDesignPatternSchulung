package ballpit;

import java.util.Iterator;
import java.util.Stack;

public class BallPit implements Iterable<Ball>, Cloneable{
    private Stack<Ball> balls = new Stack<>();

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public Ball removeBall() {
        return balls.empty() ? null : balls.pop();
    }

    @Override
    public Iterator<Ball> iterator() {
        return balls.iterator();
    }

	public Stack<Ball> getBallPits()  {
		return balls;
	}

    private void setBalls(Stack<Ball> balls){
        this.balls = balls;
    }
    @Override
    public BallPit clone() {
        try {
            BallPit clone = (BallPit) super.clone();
            Stack<Ball> ballsCopy = new Stack<>();
            this.forEach(ball -> ballsCopy.add(ball.clone()));
            clone.setBalls(ballsCopy);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
