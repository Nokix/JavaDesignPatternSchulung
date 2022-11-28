package ballpit;

public class AddBall implements Command{
    Ball ball;
    BallPit reciever;

    public AddBall(Ball ball, BallPit reciever) {
        this.ball = ball;
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.addBall(ball);
    }
}
