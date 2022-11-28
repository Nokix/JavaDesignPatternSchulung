package ballpit;

public class RemoveBall extends UndableCommand{
    BallPit reciever;
    private Ball removedBall;

    public RemoveBall(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        super.execute();
        this.removedBall = reciever.removeBall();
    }

    @Override
    public UndableCommand getReverseCommand() {
        return new AddBall(removedBall, reciever);
    }
}
