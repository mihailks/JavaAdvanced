package barracksWars.core.commands;

import barracksWars.interfaces.Repository;

import jdk.jshell.spi.ExecutionControl;

@NamedCommand(commandName = "retire")
public class RetireCommand extends Command {
    Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            repository.removeUnit(getData()[1]);
            return getData()[1] + " retired!";
        } catch (IllegalStateException | ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
    }
}
