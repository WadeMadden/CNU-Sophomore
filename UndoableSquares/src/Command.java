
public interface Command {
    Command execute();

    Command undo();
}