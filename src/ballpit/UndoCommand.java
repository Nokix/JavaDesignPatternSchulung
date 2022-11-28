package ballpit;

import java.util.Stack;

public class UndoCommand implements Command{
    static Stack<UndableCommand> commandStack = new Stack<>();

    public static void addUndoableCommand(UndableCommand command) {
        commandStack.add(command);
    }

    @Override
    public void execute() {
        if(commandStack.empty()) return;
        commandStack.pop().getReverseCommand().execute();
    }

    public static void resetHistory() {
        commandStack.clear();
    }
}
