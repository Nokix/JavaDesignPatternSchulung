package ballpit;

public interface UndableCommand extends Command{
    Command getReverseCommand();
}
