package ballpit;

public class RemoveBall implements Command{
    BallPit reciever;
    private Ball removedBall;

    public RemoveBall(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        this.removedBall = reciever.removeBall();
    }
}
