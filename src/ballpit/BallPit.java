package ballpit;

import java.util.Iterator;
import java.util.Stack;

public class BallPit implements Iterable<Ball>{
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
}
