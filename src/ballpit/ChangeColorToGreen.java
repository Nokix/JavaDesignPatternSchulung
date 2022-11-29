package ballpit;

import java.awt.Color;
import java.util.Iterator;

public class ChangeColorToGreen extends UndableCommand {
    BallPit reciever;

    public ChangeColorToGreen(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        super.execute();
        Iterator<Ball> iterator = reciever.getBallPits().iterator();
        while(iterator.hasNext()) {
        	iterator.next().setColor(new Color(0,130,0));
        }
    }

    @Override
    public UndableCommand getReverseCommand() {
        return new RemoveBall(reciever);
    }
}