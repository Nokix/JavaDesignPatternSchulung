package ballpit;

import java.awt.Color;
import java.util.Iterator;

public class ChangeColorToGreen implements Command {
    BallPit reciever;

    public ChangeColorToGreen(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        for (Ball ball : reciever) {
            ball.setColor(new Color(0, 130, 0));
        }

//        Iterator<Ball> iterator = reciever.iterator();
//        while(iterator.hasNext()) {
//        	iterator.next().setColor(new Color(0,130,0));
//        }
    }
}