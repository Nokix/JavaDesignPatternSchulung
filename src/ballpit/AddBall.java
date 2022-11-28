package ballpit;

public class AddBall implements UndableCommand{
    Ball ball;
    BallPit reciever;

    public AddBall(Ball ball, BallPit reciever) {
        this.ball = ball;
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        UndoCommand.addUndoableCommand(this);
        reciever.addBall(ball);
    }

    @Override
    public Command getReverseCommand() {
        return new RemoveBall(reciever);
    }
}
