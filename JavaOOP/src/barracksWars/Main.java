package barracksWars;

import barracksWars.core.commands.AddUnitCommand;
import barracksWars.core.commands.FightCommand;
import barracksWars.core.commands.ReportCommand;
import barracksWars.core.commands.RetireCommand;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Engine engine = new Engine(repository, unitFactory);
        engine.registerCommand(AddUnitCommand.class);
        engine.registerCommand(ReportCommand.class);
        engine.registerCommand(FightCommand.class);
        engine.registerCommand(RetireCommand.class);
        engine.run();
    }
}
