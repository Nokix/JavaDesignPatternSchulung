package ballpit.internals;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball implements Cloneable{
    private int x = 0;
    private int y = 0;
    private int ballWidth = 50;
    private int ballHeight = 50;
    int speedX;
    int speedY;
    public Color color;
    
	public Ball() {
        this.color = new Color(
                ThreadLocalRandom.current().nextInt(0, 256),
                ThreadLocalRandom.current().nextInt(0, 256),
                ThreadLocalRandom.current().nextInt(0, 256));
        this.speedX = ThreadLocalRandom.current().nextInt(-10, 11);
        this.speedY = ThreadLocalRandom.current().nextInt(-10, 11);
    }

    public Ball setX(int x) {
        this.x = x;
        return this;
    }

    public Ball setY(int y) {
        this.y = y;
        return this;
    }

    public Ball setBallWidth(int ballWidth) {
        this.ballWidth = ballWidth;
        return this;
    }

    public Ball setBallHeight(int ballHeight) {
        this.ballHeight = ballHeight;
        return this;
    }

    public Ball setSpeedX(int speedX) {
        this.speedX = speedX;
        return this;
    }

    public Ball setSpeedY(int speedY) {
        this.speedY = speedY;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBallWidth() {
        return ballWidth;
    }

    public int getBallHeight() {
        return ballHeight;
    }

    public void updatePositionAndSpeed(int max_x, int max_y) {
        // update Position
        x += speedX;
        y += speedY;

        // update Speed / Direction
        if (x > max_x || x < 0) speedX *= (-1);
        if (y > max_y || y < 0) speedY *= (-1);
    }

	public void setColor(Color color) {
		this.color = color;
	}

    @Override
    public Ball clone() {
        try {
            Ball clone = (Ball) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
