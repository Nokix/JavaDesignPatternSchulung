package ballpit.commands;

import ballpit.internals.Ball;
import ballpit.internals.BallPit;

public class AddBall extends UndableCommand {
    Ball ball;
    BallPit reciever;

    public AddBall(Ball ball, BallPit reciever) {
        this.ball = ball;
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        super.execute();
        reciever.addBall(ball);
    }

    @Override
    public UndableCommand getReverseCommand() {
        return new RemoveBall(reciever);
    }
}
