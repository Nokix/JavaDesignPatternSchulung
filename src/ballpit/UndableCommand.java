package ballpit;

public abstract class UndableCommand implements Command{
    abstract UndableCommand getReverseCommand();

    @Override
    public void execute() {
        UndoCommand.addUndoableCommand(this);
    }
}
