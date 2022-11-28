package ballpit;

public class RemoveBall implements UndableCommand{
    BallPit reciever;
    private Ball removedBall;

    public RemoveBall(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        UndoCommand.addUndoableCommand(this);
        this.removedBall = reciever.removeBall();
    }

    @Override
    public Command getReverseCommand() {
        return new AddBall(removedBall, reciever);
    }
}
